package bubble.joraku.util.imported.network.request;

import java.util.Optional;

import bubble.joraku.util.imported.network.connection.Connection;

public class Request {
    private final Object[] args;

    public Request(Object... args) {
        this.args = args;
    }

    public Response request(Connection connection) {
        for (Object obj : args) {
            connection.send(obj);
        }
        return new Response(connection.nextLine());
    }
    
    public Optional<Response> send(Connection connection) {
        for (Object obj : args) {
            connection.send(obj);
        }
        return Optional.of(new Response(connection.nextLine()));
    }
}
