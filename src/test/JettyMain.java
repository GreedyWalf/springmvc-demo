import org.mortbay.io.Connection;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Created by Administrator on 2016/8/13.
 */
public class JettyMain {
    public static void main(String[] args) throws Exception {
        Server jettyServer = new Server();
        SocketConnector conn = new SocketConnector();
        conn.setPort(8080);
        jettyServer.setConnectors(new Connector[]{conn});
        WebAppContext wah = new WebAppContext();
        wah.setContextPath("/springmvc");
        wah.setWar("src/main/webapp");
        jettyServer.setHandler(wah);
        jettyServer.start();
    }
}
