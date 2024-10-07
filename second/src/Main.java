public class Main {

    interface Shape {
        double calculateArea();
    }

    // Circle class implementing the Shape interface
    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    // Rectangle class implementing the Shape interface
    static class Rectangle implements Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    // AreaCalculator class that calculates the area of any Shape
    static class AreaCalculator {
        public double calculateShapeArea(Shape shape) {
            return shape.calculateArea();
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calculator = new AreaCalculator();

        // Calculate areas of different shapes
        System.out.println("Area of Circle: " + calculator.calculateShapeArea(circle));
        System.out.println("Area of Rectangle: " + calculator.calculateShapeArea(rectangle));
    }
}
