package dataBase;

import javafx.scene.Scene;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String massage_send;
            Socket socket = new Socket("localhost", 2412);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            while(true){
                massage_send = scanner.nextLine();
                if(massage_send.equals("exit"))
                    break;
                else {
                    objectOutputStream.writeObject(massage_send);
                    System.out.println((String) objectInputStream.readObject());
                }
            }

            objectOutputStream.close();
            objectInputStream.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}