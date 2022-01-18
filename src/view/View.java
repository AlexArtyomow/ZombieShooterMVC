package view;

import controller.Controller;
import model.ObjectInfo;
import model.enums.Resource;
import model.listeners.EventData;
import model.listeners.Listener;
import model.listeners.Sender;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements Listener  {

    private Controller controller;

    private JPanel gameField;
    private HunterView hunterView;

    public View(Controller controller) {
        this.controller = controller;
        this.controller.addListener(this);

        setImages();
        //initializePanel();
        initializeFrame();
    }

    private void initializeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        setTitle("Zombie Shooter");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        //JMenuBar menuBar = new JMenuBar(); //создание экземпляра объекта JMenuBar
        //menuBar.add(getMainMenu()); //получение меню
        //setJMenuBar(menuBar); //добавление меню на фрейм
        //pack();
        //addWindowListener(new ExitWindowAdapter());
    }

//    private void initializePanel() {
//        gameField = new JPanel() {
//            @Override
//            public void paint(Graphics g) {
//                View.this.paintComponent(g);
//            }
//        };
//    }
//
//    private void paintComponent(Graphics g) {
//        hunterView.paintComponent(g);
//    }

    @Override
    public void handleEvent(EventData eventData) {
        Sender sender = eventData.getSender();
        model.listeners.Event event = eventData.getEvent();
        Object data = eventData.getData();

        if(sender == Sender.GAME_FIELD && event == model.listeners.Event.GAME_FIELD_INITIALIZE) {
            initializeGameField(data);
        }
        if(sender == Sender.HUNTER && event == model.listeners.Event.HUNTER_INITIALIZE) {
            initializeHunter(data);
        }

    }

    private void initializeGameField(Object data) {
        ObjectInfo gameFieldInfo = (ObjectInfo) data;
        Dimension gameFieldDimension = gameFieldInfo.getDimension();
        gameField = new JPanel();
        this.gameField.setPreferredSize(gameFieldDimension);
        this.gameField.setBackground(Color.RED);
        //this.gameField.setLayout(null);
        this.add(gameField);
        this.pack();
    }

    private void initializeHunter(Object data) {
        ObjectInfo hunterInfo = (ObjectInfo) data;
        this.hunterView = new HunterView(hunterInfo);
        //hunterView.setBounds(20, 20, 50, 50);
        gameField.add(hunterView);
    }

    public void setImages()
    {
        for(Resource resource : Resource.values())
            resource.image = getImage(resource.name().toLowerCase());
    }

    private Image getImage(String name)
    {
        String filename = "/img/" + name + ".png";
        ImageIcon icon = new ImageIcon (getClass().getResource(filename));
        return icon.getImage();
    }
}
