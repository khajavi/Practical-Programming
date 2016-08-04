package org.application.jetty;

import com.google.common.base.MoreObjects;
import com.google.common.primitives.Ints;
import org.eclipse.jetty.server.Server;


public class JettyStarter {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws Exception {

        int port = args.length >= 1 ? MoreObjects.firstNonNull(Ints.tryParse(args[0]), DEFAULT_PORT) : DEFAULT_PORT;

        Server server = new JettyFactory().port(port).build();
        JettyFactory.start(server);

        try {
            System.in.read();
        } finally {
            JettyFactory.stop(server);
        }
    }
}
