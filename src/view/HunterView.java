package view;

import model.ObjectInfo;
import model.enums.Direction;
import model.enums.Resource;
import model.gameObject.Hunter;
import model.listeners.EventData;
import model.listeners.Listener;

import javax.swing.*;
import java.awt.*;

public class HunterView extends JLabel{

    private ObjectInfo objectInfo;

//    public HunterView() {
//        setIcon(new ImageIcon(HunterView.class.getResource("/img/ammo.png")));
//    }

    public HunterView(ObjectInfo objectInfo) {
        this.objectInfo = objectInfo;
        this.setPreferredSize(objectInfo.getDimension());
        this.setLocation(objectInfo.getLocation());
        this.setBackground(Color.BLUE);
        setIcon(new ImageIcon(HunterView.class.getResource("/img/ammo.png")));
    }

//    @Override
//    public void paintComponent(Graphics g) {
        //g.drawImage(this.getImage(Direction.LEFT), objectInfo.getLocation().x, objectInfo.getLocation().y, null);
//        g.setColor(Color.BLUE);
//        g.drawOval(0,
//                0,
//                objectInfo.getDimension().width,
//                objectInfo.getDimension().height);
//        g.fillOval(0,
//                0,
//                objectInfo.getDimension().width,
//                objectInfo.getDimension().height);
//        g.setColor(Color.BLUE);
//    }



    private Image getImage(Direction direction) {
        if(direction == Direction.LEFT) {
            return (Image) Resource.HUNTER_LEFT.image;
        }
        if(direction == Direction.RIGHT) {
            return (Image) Resource.HUNTER_RIGHT.image;
        }
        if(direction == Direction.UP) {
            return (Image) Resource.HUNTER_UP.image;
        }
        else {
            return (Image) Resource.HUNTER_DOWN.image;
        }
    }
}
