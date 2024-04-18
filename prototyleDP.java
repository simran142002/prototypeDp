import java.util.HashMap;
import java.util.Map;

// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype classes
class Circle implements Prototype {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public Prototype clone() {
        return new Circle(this.color);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color='" + color + '\'' +
                '}';
    }
}

class Rectangle implements Prototype {
    private String type;

    public Rectangle(String type) {
        this.type = type;
    }

    @Override
    public Prototype clone() {
        return new Rectangle(this.type);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "type='" + type + '\'' +
                '}';
    }
}

// Prototype manager
class PrototypeManager {
    private static Map<String, Prototype> prototypes = new HashMap<>();

    static {
        prototypes.put("blueCircle", new Circle("blue"));
        prototypes.put("redRectangle", new Rectangle("red"));
    }

    public static Prototype getPrototype(String type) {
        return prototypes.get(type).clone();
    }
}

public class Main {
    public static void main(String[] args) {
        // Get and clone prototypes
        Prototype blueCircle = PrototypeManager.getPrototype("blueCircle");
        Prototype redRectangle = PrototypeManager.getPrototype("redRectangle");

        System.out.println("Cloned blue circle: " + blueCircle);
        System.out.println("Cloned red rectangle: " + redRectangle);
    }
}
