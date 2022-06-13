package bubble.joraku.util.imported.network.connection;

import java.util.function.Consumer;

public interface IConnection {
    void send(String message);

    /** send an object (simply calls {@code object.toString()} before sending) */
    default void send(Object object) {
        send(object.toString());
    }

    /** calls {@code toString()} on each object and send all objects in order */
    default void send(Object... objects) {
        for (Object obj : objects) {
            send(obj);
        }
    }

    String nextLine();

    boolean hasNextLine();

    boolean isAlive();

    void listen(Consumer<String> onReceive);
}
