package prob1;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(){}

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double Perimeter(){
        return 2*(width + height);
    }

    public double Area(){
        return width*height;
    }
}
