package dataBase;

import javafx.scene.Scene;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMore extends Thread {

    private Socket socket;

    public ServerMore(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

//        while (true){
            try {
                Scanner scanner = new Scanner(System.in);

                String massage;
                String out;

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


                while(true){
                    if((String) objectInputStream.readObject() == "exit")
                        break;
                    else {
                        out = (String) objectInputStream.readObject();
                        System.out.println(out);
                    }
                    massage = scanner.next();
                    objectOutputStream.writeObject(massage);
                }

                objectOutputStream.close();
                objectInputStream.close();


            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
            }

//        }

    }

}
