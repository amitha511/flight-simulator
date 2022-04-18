package com.example.javafx_tirgol2;

import ViewModel.ViewModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    Canvas joystick;
    @FXML
    Slider throttle;
    @FXML
    Slider rudder;
    ViewModel vm;
    DoubleProperty  aileron,elevators;

    boolean mousePushed;
    double jx,jy;
    double my,mx;  //center

    public HelloController()
    {
        this.mousePushed = false;
        this.jy=0;
        this.jx=0;
        aileron = new SimpleDoubleProperty();
        elevators = new SimpleDoubleProperty();
    }

    public void init(ViewModel vm){
        this.vm = vm;
        vm.throttle.bind(throttle.valueProperty());
        vm.rudder.bind(rudder.valueProperty());
        vm.aileron.bind(aileron);
        vm.elevators.bind(elevators);
    }
    public void paint(){
        GraphicsContext gc = joystick.getGraphicsContext2D();
        mx = joystick.getWidth()/2;
        my = joystick.getHeight()/2;
        gc.clearRect(0,0, joystick.getWidth(),joystick.getHeight());
        gc.strokeOval(jx-50,jy-50,100,100);
        aileron.set((jx-mx)/mx);  //update
        elevators.set((my-jy)/my); //update
    }

    public void mouseDown(MouseEvent me){
        if(!mousePushed){
            mousePushed = true;
        }
    }

    public void mouseUp(MouseEvent me){
        if(mousePushed)
            mousePushed = false;
            jx=mx;
            jy=my;
            paint();
    }

    public void mouseMove(MouseEvent me){
        if(mousePushed){
            jx=me.getX();
            jy=me.getY();
            paint();

        }
    }

}