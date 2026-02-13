package org.edu.remote.learning;

import org.edu.remote.learning.util.CaptureServerImage;
import org.edu.remote.learning.util.Connection;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    ServerSocket serverSocket;
    CaptureServerImage captureServerImage;

    public Server() {
        try{
            serverSocket = new ServerSocket(2001);
            captureServerImage = new CaptureServerImage();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server is started");
        this.start();
    }

    public void run() {
        try{
            int i=0;
            while(true) {
                Socket client = serverSocket.accept();
                Connection connection = new Connection(client, captureServerImage);
                System.out.println("Active Client Connection: "+(++i));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
