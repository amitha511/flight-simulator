package controller;

import com.example.javafx_tirgol2.HelloController;
import model.Model;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {


    Model m;
    HelloController wc;

    public Controller(Model m, HelloController wc){
        this.m=m;
        m.addObserver(this);
        this.wc = wc;
        wc.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
