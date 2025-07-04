import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class server {
    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try{
                PrintWriter toClient =new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from server");
                toClient.close();
                clientSocket.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        int port =8080;
        server s=new server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(5000);
            System.out.println("Server listning from port " + port );
            while(true){
                Socket acceptedSocket = serverSocket.accept();
                Thread thread =new Thread(()->s.getConsumer().accept(acceptedSocket));
                thread.start();
            }   

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }    
}
