import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

    private Socket clientSocket;

    private BufferedReader in;

    private PrintWriter out;


    public void startConnection(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);

    }

    public String sendMessage(String message) throws IOException {

        out.println(message);

        String serverMessage = in.readLine();

        return serverMessage;

    }

    public void close() throws IOException {

        clientSocket.close();
        in.close();
        out.close();


    }

}
