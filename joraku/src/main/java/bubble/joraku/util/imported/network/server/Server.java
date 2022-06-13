package bubble.joraku.util.imported.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

import bubble.joraku.util.imported.network.connection.Connection;
import bubble.joraku.util.imported.network.connection.IConnection;

/**
 *  example:
 *  <pre>
 *  {@code
 *      new Server(connection -> connection.send("HI from server!")).listen(port);
 *  }
 *  </pre>
 */
public class Server {

    private final Consumer<IConnection> onAccept;

    public Server(Consumer<IConnection> onAccept) {
        this.onAccept = onAccept;
    }

    public Server listen(int port) {
        new Thread(
            () -> {
                try (ServerSocket server = new ServerSocket(port)) {
                    listen(server);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        ).start();
        return this;
    }

    private void listen(ServerSocket server) throws IOException {
        addShutdownHook(server);
        
        while (!server.isClosed()) {
            Socket socket = server.accept();
            onAccept.accept(new Connection(socket));
        }
    }
    
    private void addShutdownHook(ServerSocket server) {
        Runtime.getRuntime().addShutdownHook(
            new Thread(    
                () -> {
                    try {
                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            )
        );
    }
}
