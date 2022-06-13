package bubble.joraku.util.log;

public class Logger {
    private static boolean isDebug = false;

    private Logger() {}

    public static void debugLog(String message) {
        if (isDebug) System.out.println(message);
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
