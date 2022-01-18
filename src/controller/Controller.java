package controller;

import model.listeners.Listener;
import model.Model;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void addListener(Listener listener) {
        model.addListener(listener);
    }
}
