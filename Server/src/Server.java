import javax.xml.crypto.Data;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Socket server_socket;
    ServerSocket server;
    DataInputStream input;
    public Server(int port){
        try {
            server = new ServerSocket(port);
            server_socket = server.accept();
            System.out.println("Connection established...");
            input = new DataInputStream(new BufferedInputStream(server_socket.getInputStream()));
            String text = "";
            while (!(text.equals("Data transfer completed"))){
                try{
                    text = input.readUTF();
                    System.out.println(text);
                }catch (IOException e){
                    System.out.println(e);
                }
            }
            System.out.println("Closing connection");
            server_socket.close();
            input.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        Server serverSideProgram = new Server(3030);
    }
}
