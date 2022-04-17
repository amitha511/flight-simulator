package com.example.javafx_tirgol2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Observable;

public class HelloController extends Observable {

    @FXML
    Canvas joystick;
    boolean mousePushed;
    double jx,jy;
    double my,mx;  //center

    double aileron,elevator;

    public HelloController()
    {
        this.mousePushed = false;
        this.jy=0;
        this.jx=0;
        this.elevator=0;
        this.aileron=0;
    }

    public double getAileron(){
        return aileron;
    }

    public double getElevator(){
        return elevator;
    }

    void paint(){
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth()/2;
        my = joystick.getHeight()/2;
        gc.clearRect(0,0, joystick.getWidth(),joystick.getHeight());
        gc.strokeOval(jx-50,jy-50,100,100);
        aileron = (jx-mx)/mx;
        elevator = (jy-mx)/mx;
        setChanged();
        notifyObservers();
        System.out.println(aileron+","+elevator);
    }

    public void mouseDown(MouseEvent me){
        if(!mousePushed){
            mousePushed = true;
            System.out.println("mouse is down");
        }
    }

    public void mouseUp(MouseEvent me){
        if(mousePushed)
            mousePushed = false;
            System.out.println("mouse is up");
            jx=mx;
            jy=my;
            paint();
    }

    public void mouseMove(MouseEvent me){
        if(mousePushed){
            System.out.println("mouse move " +me.getX()+","+me.getY());
            jx=me.getX();
            jy=me.getY();
            paint();

        }
    }

}