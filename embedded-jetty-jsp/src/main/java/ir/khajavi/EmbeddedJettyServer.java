package ir.khajavi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedJettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);


        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setResourceBase("src/main/webapp/");

        // This webapp will use jsps and jstl. We need to enable the
        // AnnotationConfiguration in order to correctly
        // set up the jsp container
        Configuration.ClassList classlist = Configuration.ClassList
                .setServerDefault(server);
        classlist.addBefore(
                "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");

        // Set the ContainerIncludeJarPattern so that jetty examines these
        // container-path jars for tlds, web-fragments etc.
        // If you omit the jar that contains the jstl .tlds, the jsp engine will
        // scan for them instead.
        webapp.setAttribute(
                "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$");

        server.setHandler(webapp);
        server.start();
        server.join();
    }
}