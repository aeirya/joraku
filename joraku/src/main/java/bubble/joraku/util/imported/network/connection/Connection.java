package bubble.joraku.util.imported.network.connection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Consumer;

import bubble.joraku.util.log.Logger;

/**
 *  wrapper around socket which can be used to send and receive messages
 */
public class Connection implements IConnection {
    private final PrintStream out;
    private final Scanner in;

    /**
     * @param port port of the server accepting new connections
     * @throws IOException
     */
    public Connection(int port) throws IOException {
        this(
            new Socket("localhost", port)
        );
    }

    /**
     * @param socket client socket
     * @throws IOException
     */
    public Connection(Socket socket) throws IOException {
        out = new PrintStream(socket.getOutputStream());
        in = new Scanner(socket.getInputStream());
    }

    public void send(String message) {
        out.println(message);
    }

    /**
     *  returns new message from server (if available),
     *  otherwise blocks
     */
    public String nextLine() {
        if (in.hasNextLine())
            return in.nextLine();
        return null;
    }

    /**
     *  @return true if there is new message
     *  @apiNote This method may block for input
     */
    public boolean hasNextLine() {
        return in.hasNextLine();
    }

    public boolean isAlive() {
        return true;
    }

    /**
     *  catch every message received by the connection and pass it to a callback
     * 
     *  @apiNote warning: either use nextLine or listen
     *  @param onReceive called everytime connection recevies a message
     */
    public void listen(Consumer<String> onReceive) {
        new Thread(() -> {
            while (true) {
                String msg = nextLine();
                Logger.log("connection received new line: " + msg);
                onReceive.accept(msg);
            }
        }).start();
    }
}
