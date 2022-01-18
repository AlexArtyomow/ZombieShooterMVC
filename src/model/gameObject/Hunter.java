package model.gameObject;

import model.GameField;
import model.ObjectInfo;
import model.listeners.Event;
import model.listeners.EventData;
import model.listeners.Listeners;
import model.listeners.Sender;

import java.awt.*;

public class Hunter extends MovingObject {

    private int health;
    private ObjectInfo objectInfo;
    private GameField gameField;
    private Listeners listeners;

    public Hunter(int speed, ObjectInfo objectInfo, GameField gameField, Listeners listeners) {
        super(speed);
        this.health = 100;
        this.gameField = gameField;
        this.listeners = listeners;
        setObjectInfo(objectInfo);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ObjectInfo getObjectInfo() {
        return objectInfo;
    }

    public void setObjectInfo(ObjectInfo objectInfo) {
        this.objectInfo = objectInfo;

        EventData eventData = new EventData(Sender.HUNTER, model.listeners.Event.HUNTER_INITIALIZE, this.objectInfo);
        listeners.notifyListeners(eventData);
    }
}
