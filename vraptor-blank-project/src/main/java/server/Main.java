package server;

public class Main {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        String webXmlLocation = "src/main/webapp/WEB-INF/web.xml";
        VRaptorServer vraptor = new VRaptorServer(webappDirLocation, webXmlLocation);
        vraptor.start();
    }
}
