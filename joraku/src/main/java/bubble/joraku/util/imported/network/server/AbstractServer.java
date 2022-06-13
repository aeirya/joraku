package bubble.joraku.util.imported.network.server;

import bubble.joraku.util.imported.network.connection.IConnection;

public abstract class AbstractServer {

    private final Server server;

    protected AbstractServer() {
        this.server = new Server(this::acceptConnection);
    }

    public abstract void acceptConnection(IConnection connection);

    public void listen(int port) {
        server.listen(port);
    }
}
