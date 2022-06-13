package bubble.joraku.util.imported.network.message;

public enum MessageCode {
    BEGIN, END;

    @Override
    public String toString() {
        return "~~~" + super.toString() + "~~~";
    }

    public boolean match(String string) {
        return toString().equals(string);
    }
}
