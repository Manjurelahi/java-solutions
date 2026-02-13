package org.edu.remote.learning;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    Socket socket;
    ObjectInputStream objectInputStream;
    ImageIcon imageIcon;

    public Client() {
        try {
            socket = new Socket("localhost", 2001);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getImageIcon() {
        imageIcon = null;
        try{
            imageIcon = (ImageIcon) objectInputStream.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            return imageIcon;
        }
    }
}
