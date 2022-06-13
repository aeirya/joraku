package bubble.joraku.util.imported.network.connection;

import java.io.IOException;
import java.io.Serializable;
import java.util.function.Consumer;

import bubble.joraku.util.imported.serialize.Deserializer;
import bubble.joraku.util.imported.serialize.Serializer;

/** connection which can also send objects through serialization */
public class DataConnection implements IConnection {

    private final Serializer serializer;
    private final Deserializer deserializer;

    private final IConnection connection;

    public DataConnection(int port) throws IOException {
        this(new Connection(port));
    }
    
    /**
     *  use this to make a connection be also able to send and read objects
     */
    public DataConnection(IConnection connection) {
        this.connection = connection;
        
        serializer = new Serializer();
        deserializer = new Deserializer();
    }

    public void sendObject(Serializable object) {
        send(serializer.serialize(object));
    }

    public Object readObject() {
        return deserializer.deserialize(nextLine());
    }

    @Override
    public void send(String message) {
        connection.send(message);
    }

    @Override
    public String nextLine() {
        return connection.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return connection.hasNextLine();
    }

    @Override
    public boolean isAlive() {
        return connection.isAlive();
    }

    @Override
    public void listen(Consumer<String> onReceive) {
        connection.listen(onReceive);
    }
}
