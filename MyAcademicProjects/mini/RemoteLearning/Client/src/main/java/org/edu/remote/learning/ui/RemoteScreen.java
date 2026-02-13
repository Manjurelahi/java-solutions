package org.edu.remote.learning.ui;

import org.edu.remote.learning.Client;

import javax.swing.*;
import java.awt.*;

public class RemoteScreen extends JFrame implements Runnable {
    static JPanel panel;
    static JLabel label;
    Image image;
    Client client;
    Thread thread;

    RemoteScreen() {
        setSize(874, 768);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel("Welcome! Please wait. Remote Screen Learning will start soon..."
                , SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        getContentPane().add(panel);
        setVisible(true);
        client = new Client();
        thread = new Thread(this);
        thread.start();
    }

    public void showImage() {
        label.setIcon(client.getImageIcon());
    }

    @Override
    public void run() {
        for(;;) {
            try {
                showImage();
                thread.sleep(60000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new RemoteScreen();
    }
}
