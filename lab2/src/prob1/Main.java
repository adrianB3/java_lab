package prob1;

public class Main {

    public static void main(String[] args) {
        Parabola p1 = new Parabola(3,5.5,4);
        Parabola p2 = new Parabola(p1);
        Parabola p3 = new Parabola(5,6.2, 4);

        p1.printPolynomialForm();
        System.out.printf("Peak : (%.2f, %.2f)\n",p1.calculatePeakCoord().getX(),p1.calculatePeakCoord().getY());
        System.out.printf("Seg middle : (%.2f, %.2f)",
                Parabola.calculateSegMiddlePoint(p1, p3).getX(),
                Parabola.calculateSegMiddlePoint(p1, p3).getY()
        );


    }
}
