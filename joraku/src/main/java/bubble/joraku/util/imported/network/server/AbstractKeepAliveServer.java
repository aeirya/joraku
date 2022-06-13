package bubble.joraku.util.imported.network.server;

import bubble.joraku.util.imported.network.connection.IConnection;

public abstract class AbstractKeepAliveServer extends AbstractServer {

    @Override
    public void acceptConnection(IConnection connection) {
        while (connection.isAlive()) {
            receive(connection, connection.nextLine());   
        }
    }

    public abstract void receive(IConnection connection, String request);
    
}
