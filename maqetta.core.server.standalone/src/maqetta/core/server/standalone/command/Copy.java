package maqetta.core.server.standalone.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maqetta.core.server.standalone.VResourceUtils;

import org.davinci.server.user.IUser;
import org.maqetta.server.Command;
import org.maqetta.server.IVResource;

public class Copy extends Command {

    @Override
    public void handleCommand(HttpServletRequest req, HttpServletResponse resp, IUser user) throws IOException {
        String src = req.getParameter("source");
        String des = req.getParameter("dest");
        boolean recurse = Boolean.parseBoolean(req.getParameter("recurse"));

        IVResource source = user.getResource(src);
        IVResource newResource = user.createResource(des);

        if (source.isDirectory()) {
            newResource.mkdir();
            VResourceUtils.copyDirectory(source, newResource, recurse);
        } else {
            VResourceUtils.copyFile(source, newResource);
        }
        this.responseString = "ok";
    }

}
