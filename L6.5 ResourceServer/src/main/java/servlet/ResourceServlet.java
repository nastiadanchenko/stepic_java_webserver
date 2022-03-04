package servlet;

import resourceServer.ResourceServer;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";
    private final ResourceServer resourceServer;

    public ResourceServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceServer.setResource(resource);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
