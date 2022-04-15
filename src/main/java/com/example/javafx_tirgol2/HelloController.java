package com.example.javafx_tirgol2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.util.Observable;

public class HelloController extends Observable {

    @FXML
    Canvas joystick;

    void paint(){
        GraphicsContext gc = joystick.getGraphicsContext2D();
        double mx = joystick.getWidth()/2;
        double my = joystick.getHeight()/2;

        gc.strokeOval(mx-50,my-50,100,100);
    }
}