package org.edu.remote.learning.util;

import java.awt.*;

public class CaptureServerImage {
    Rectangle rect;
    Robot robot;

    public CaptureServerImage() {
        try {
            robot = new Robot();
            rect = new Rectangle(0,0,1024,768);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return robot.createScreenCapture(rect);
    }
}
