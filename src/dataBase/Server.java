package dataBase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static ObjectInputStream objectInputStream;
    public static ObjectOutputStream objectOutputStream;
    public static ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {

        try {
            serverSocket = new ServerSocket(2412);

            while(true){
                Socket socket = serverSocket.accept();
                ServerMore serverMore = new ServerMore(socket);
                serverMore.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}