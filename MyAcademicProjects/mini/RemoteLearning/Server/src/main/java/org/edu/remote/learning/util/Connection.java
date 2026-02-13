package org.edu.remote.learning.util;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread {
    Socket socket;
    ObjectOutputStream objectOutputStream;
    Image image;
    ImageIcon imageIcon;
    CaptureServerImage captureServerImage;

    public Connection(Socket client, CaptureServerImage captureServerImage) {
        try {
            this.socket = client;
            objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
            this.captureServerImage = captureServerImage;
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.start();
    }

    private void sendImage() throws IOException {
        try{
            this.image = captureServerImage.getImage();
            this.imageIcon = new ImageIcon(this.image);
            objectOutputStream.writeObject(imageIcon);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.image = null;
            this.imageIcon = null;
            objectOutputStream.flush();
        }
    }

    public void run() {
        for (;;){
            try{
                sendImage();
                sleep(2300);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


}
