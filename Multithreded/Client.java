import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Runnable getRunable() {
        return new Runnable() {
            @Override
            public void run(){
                int port = 8080;
                try {
                    InetAddress serverAddress = InetAddress.getByName("Localhost");
                    Socket socket = new Socket(serverAddress, port);
                    try(PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                    )
                     {

                        toServer.println("Hello from client");
                        String Line = fromServer.readLine();
                        System.out.println("Response from server: " + Line);

                    } catch (IOException e) {
                        e.printStackTrace();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    
            }

        };
    }
    public static void main(String[] args) {
        Client client = new Client();
        for(int i = 0; i < 100; i++) {
            try{
                Thread thread = new Thread(client.getRunable());
                thread.start();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
}
