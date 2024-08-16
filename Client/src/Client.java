import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

public class Client {
    Socket client_socket;
    BufferedReader input_text;
    DataOutputStream output_text;
    public Client(String address, Integer port){
        try {
            client_socket = new Socket(address, port);
            input_text = new BufferedReader(new InputStreamReader(System.in));
            output_text = new DataOutputStream(client_socket.getOutputStream());
            String text = "";
            while (!(text.equals("Data transfer completed"))){
                try {
                    text = input_text.readLine();
                    output_text.writeUTF(text);
                } catch(IOException e){
                    System.out.println(e);
                }
            }
            input_text.close();
            output_text.close();
            client_socket.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        Client c1 = new Client("127.0.0.1",3030);
    }
}
