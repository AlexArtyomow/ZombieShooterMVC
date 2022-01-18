package model;

import java.awt.*;

public class ObjectInfo {
    private Dimension dimension;
    private Point location;

    public ObjectInfo(Dimension dimension, Point location) {
        this.dimension = dimension;
        this.location = location;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }
}
