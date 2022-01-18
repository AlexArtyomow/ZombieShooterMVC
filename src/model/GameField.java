package model;

import model.listeners.Event;
import model.listeners.EventData;
import model.listeners.Listeners;
import model.listeners.Sender;

public class GameField {
    private ObjectInfo objectInfo;
    private Listeners listeners;

    public GameField(ObjectInfo objectInfo, Listeners listeners) {
        this.listeners = listeners;
        setObjectInfo(objectInfo);
    }

    public ObjectInfo getObjectInfo() {
        return objectInfo;
    }

    public void setObjectInfo(ObjectInfo objectInfo) {
        this.objectInfo = objectInfo;

        EventData eventData = new EventData(Sender.GAME_FIELD, model.listeners.Event.GAME_FIELD_INITIALIZE, this.objectInfo);
        listeners.notifyListeners(eventData);
    }
}
