package prob1;

public class Parabola {
    private double a, b, c;

    public Parabola(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Parabola(Parabola parabola){
        this(parabola.a, parabola.b, parabola.c);
    }

    public void printPolynomialForm(){
        System.out.println("f(x) = " + a + "x^2 + " + b + "x + " + c);
    }

    public Point calculatePeakCoord(){
        double px, py;

        px = -b/(2*a);
        py = (-b*b + 4*a*c)/(4*a);

        return new Point(px, py);
    }

    public static Point calculateSegMiddlePoint(Parabola parabola1, Parabola parabola2){
        Point p1 = parabola1.calculatePeakCoord();
        Point p2 = parabola2.calculatePeakCoord();

        double mx = (p1.getX() + p2.getX())/2;
        double my = (p1.getY() + p2.getY())/2;

        return new Point(mx, my);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
