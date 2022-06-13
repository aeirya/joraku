package bubble.joraku.util.imported.network.message;

import java.util.ArrayList;
import java.util.List;

import bubble.joraku.util.imported.network.connection.IConnection;

public class MessageReader {

    public List<String> readLines(IConnection connection) {
        String line = connection.nextLine();
        if (!MessageCode.BEGIN.match(line)) return new ArrayList<>();
        
        List<String> list = new ArrayList<>();
        while (connection.hasNextLine()) {
            line = connection.nextLine();
            if (MessageCode.END.match(line)) break;
            list.add(line);
        }
        return list;
    }
}
