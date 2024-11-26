import geometry.Point;
import shapes.Circle;
import shapes.Square;
import shapes.Rectangle;
import shapes.Triangle;
import correct.InputValidator;

public class Main {

    public static void main(String[] args) {
        Point center = InputValidator.getPointInput("Введите точку центра круга: ");
        double radius = InputValidator.getPositiveDoubleInput("Введите радиус круга: ");
        Circle circle = new Circle(center, radius);
        System.out.println(circle);
        System.out.println("Площадь круга: " + circle.calculateArea());

        Point topLeft = InputValidator.getPointInput("Введите точку левого верхнего угла квадрата: ");
        double side = InputValidator.getPositiveDoubleInput("Введите сторону квадрата: ");
        Square square = new Square(topLeft, side);
        System.out.println(square);
        System.out.println("Площадь квадрата: " + square.calculateArea());

        topLeft = InputValidator.getPointInput("Введите точку левого верхнего угла прямоугольника: ");
        double width = InputValidator.getPositiveDoubleInput("Введите ширину прямоугольника: ");
        double height = InputValidator.getPositiveDoubleInput("Введите высоту прямоугольника: ");
        Rectangle rectangle = new Rectangle(topLeft, width, height);
        System.out.println(rectangle);
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());

        Point p1 = InputValidator.getPointInput("Введите первую точку треугольника: ");
        Point p2 = InputValidator.getPointInput("Введите вторую точку треугольника: ");
        Point p3 = InputValidator.getPointInput("Введите третью точку треугольника: ");
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.println(triangle);
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
    }
}
