
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    public void run() throws SocketException, IOException {
        int port = 8080;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true) {
            try {

                System.out.println("System is listning on port " + port);
                Socket acceptedConnection = socket.accept();
                System.out.println(acceptedConnection);
                System.out.println("Connection established with " + acceptedConnection.getInetAddress() + ":"
                        + acceptedConnection.getPort());
                PrintWriter toclient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromclient = new BufferedReader(
                        new InputStreamReader(acceptedConnection.getInputStream()));
                        toclient.println("Hello from server");
                        String Line = fromclient.readLine();
                        System.out.println("response from client: " + Line);
                toclient.close();
                fromclient.close();
                acceptedConnection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Server server =new Server();

        try{
            server.run();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}