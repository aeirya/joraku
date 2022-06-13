package bubble.joraku.util.imported.network.message;

import java.util.StringJoiner;

import bubble.joraku.util.imported.network.connection.IConnection;

/**
 * how to send message:
 * <pre>{@code
 *      new MessageBuilder()
 *          .add("HI this is the first line of message")
 *          .add("and this is the second")
 *          .biuldAndSend(connection);
 * }</pre> 
 * 
 * how to read message:
 * <pre>{@code
 *      List<String> lines = new MessageReader().readLines(connection);
 *      
 * }</pre> 
 * 
 */
public class MessageBuilder {
    private final StringJoiner joiner;

    public MessageBuilder() {
        joiner = new StringJoiner("\n");
        begin();
    }
    
    private void begin() {
        add(MessageCode.BEGIN);
    }

    private void end() {
        add(MessageCode.END);
    }

    public MessageBuilder add(String line) {
        joiner.add(line);
        return this;
    }

    public <T> MessageBuilder add(T item) {
        joiner.add(item.toString());
        return this;
    }

    private String build() {
        end();
        return joiner.toString();
    }

    public void buildAndSend(IConnection connection) {
        connection.send(build());
    }
}