package model.gameObject;

import model.Model;
import model.ObjectInfo;
import model.enums.Direction;
import model.enums.HunterAction;
import model.listeners.Event;
import model.listeners.EventData;
import model.listeners.Listeners;
import model.listeners.Sender;

import java.awt.*;

public class HunterMover {

    private Hunter hunter;
    private Listeners listeners;
    private ObjectInfo objectInfo;
    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    private boolean isShot;

    public HunterMover(Hunter hunter, Listeners listeners) {
        this.hunter = hunter;
        this.listeners = listeners;
        this.objectInfo = hunter.getObjectInfo();
    }

    public void makeHunterAction(HunterAction hunterAction) {
        if(!Model.isGameOver()) {
            if(hunterAction ==  HunterAction.TURN_LEFT) {
                isLeft = true;
            }
            if(hunterAction ==  HunterAction.TURN_RIGHT) {
                isRight = true;
            }
            if(hunterAction ==  HunterAction.TURN_UP) {
                isUp = true;
            }
            if(hunterAction ==  HunterAction.TURN_DOWN) {
                isDown = true;
            }
            if(hunterAction ==  HunterAction.SHOT) {
                isShot = true;
            }
        }

        EventData eventData = new EventData(Sender.HUNTER_MOVER, model.listeners.Event.HUNTER_MAKE_ACTION, this.objectInfo);
        listeners.notifyListeners(eventData);
    }

    public void moveHunter() {
        int move = 0;
        Point location = hunter.getObjectInfo().getLocation();
        int speed = hunter.getSpeed();

        if (isLeft && location.x > 0)
        {
            move = location.x - speed;
            location.x += move;
            hunter.setDirection(Direction.LEFT);
        }
        if (isRight && location.x < Model.GAME_FIELD_WIDTH)
        {
            move = location.x + speed;
            location.x += move;
            hunter.setDirection(Direction.RIGHT);
        }
        if (isUp && location.y > 0)
        {
            move = location.y - speed;
            location.y += move;
            hunter.setDirection(Direction.UP);
        }
        if (isDown && location.y < Model.GAME_FIELD_HEIGHT)
        {
            move = location.y + speed;
            location.y += move;
            hunter.setDirection(Direction.DOWN);
        }

        EventData eventData = new EventData(Sender.HUNTER_MOVER, model.listeners.Event.HUNTER_MOVE, this.objectInfo);
        listeners.notifyListeners(eventData);
    }
}
