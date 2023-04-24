import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
String message = "";

public String handleRequest(URI website) {
    if (website.getPath().contains("/")) {
        String[] parameters = website.getQuery().split("=");
        if (parameters[0].equals("s")) {
            message += parameters[1] + "\n";
            return message;
        }
    }
    return "No message yet";
}
}

class StringServer {
public static void main(String[] args) throws IOException {
int port = Integer.parseInt(args[0]);
Server.start(port, new Handler());
}
}
