package clientserverapk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServerApk {

    public static void main(String[] args) {
        //PORT= MEDIUM OF COMMUNICATION BTWN HOSTS
        //SOCKET =MANAGES A PORT
        try {

            ServerSocket ss = new ServerSocket(2024);     //waits for a request to come over a network
            System.out.println("Server started at " + ss);
            System.out.println("Waiting for client to connect");

            Socket socket = ss.accept();        //this will block the thread until there's a client that connects to the port 2024

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            System.out.println("Client says "+br.readLine());
            
            PrintWriter pW= new PrintWriter(socket.getOutputStream(),true);
            pW.println("Hey client, How are you?");
            
            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
