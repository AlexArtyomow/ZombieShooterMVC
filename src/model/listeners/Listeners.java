package model.listeners;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Listeners {

    private List<Listener> listeners = new ArrayList<Listener>();

    public boolean addListener(Listener listener) {
        return listeners.add(listener);
    }

    public boolean removeListener(Listener listener) {
        return listeners.remove(listener);
    }

    public void notifyListeners(EventData eventData) {
        ListIterator<Listener> iterator = listeners.listIterator();

        while (iterator.hasNext()) {
            Listener listener = iterator.next();
            listener.handleEvent(eventData);
        }
    }
}
