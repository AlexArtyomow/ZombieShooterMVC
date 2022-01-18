package model;

import model.gameObject.Hunter;
import model.listeners.Listener;
import model.listeners.Listeners;
import view.HunterView;

import java.awt.*;

public class Model {

    public static final int GAME_FIELD_WIDTH = 900;
    public static final int GAME_FIELD_HEIGHT = 600;
    public static final int HUNTER_WIDTH = 50;
    public static final int HUNTER_HEIGHT = 50;
    public static final int HUNTER_LOCATION_X = 100;
    public static final int HUNTER_LOCATION_Y = 100;

    private static boolean isGameOver = false;
    private GameField gameField;
    private Hunter hunter;
    private Listeners listeners;

    public Model() {
        listeners = new Listeners();
    }

    public static boolean isGameOver() {
        return isGameOver;
    }

    public static void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void start() {
        initialize();
    }

    private void initialize() {
        initializeGameField();
        initializePlayer();
    }

    private void initializeGameField() {
        Dimension gameFieldDimension = new Dimension(GAME_FIELD_WIDTH, GAME_FIELD_HEIGHT);
        ObjectInfo gameFieldInfo = new ObjectInfo(gameFieldDimension, null);
        this.gameField = new GameField(gameFieldInfo, this.listeners);
    }

    private void initializePlayer() {
        Dimension hunterDimension = new Dimension(HUNTER_WIDTH, HUNTER_HEIGHT);
        Point hunterLocation = new Point(HUNTER_LOCATION_X, HUNTER_LOCATION_Y);
        ObjectInfo hunterInfo = new ObjectInfo(hunterDimension, hunterLocation);
        this.hunter = new Hunter(10, hunterInfo, this.gameField, this.listeners);
    }

    public void addListener(Listener listener) {
        listeners.addListener(listener);
    }

}
