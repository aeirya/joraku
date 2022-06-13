package bubble.joraku.util.imported.network.request;

public class Response {
    private final String value;

    public Response(String value) {
        this.value = value;
    }

    public Integer toInt() {
        return Integer.parseInt(value);
    }

    public String toString() {
        return value;
    }
}
