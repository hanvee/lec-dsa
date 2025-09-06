abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    // Methodd yang harus diimplementasikan oleh subclass
    public abstract double calculateArea();
    public abstract void draw();
}

//  Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public void draw() {
        System.out.println("Menggambar persegi panjang berwarna " + color);
    }
}

// Circle
class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Menggambar lingkaran berwarna " + color);
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle("Merah", 5, 10);
        Shape circle = new Circle("Biru", 7);
        
        rectangle.draw();
        System.out.println("Luas: " + rectangle.calculateArea());
        
        circle.draw();
        System.out.println("Luas: " + circle.calculateArea());
    }
}
