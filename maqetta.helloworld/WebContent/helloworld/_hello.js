dojo.provide("helloworld._hello");
dojo.require("dijit._WidgetBase");
dojo.declare("helloworld._hello", [dijit._WidgetBase], {

	buildRendering: function(){
		this.inherited(arguments);
        var dj = this.domNode.ownerDocument.defaultView.dojo;
		var url = dj.moduleUrl('helloworld', 'images/helloworld.png');
		this.domNode.style.border = '3px pink solid';
		this.domNode.innerHTML = '<img src="'+url+'"/>';
		this.domNode.style.display = 'inline-block';
	}
});