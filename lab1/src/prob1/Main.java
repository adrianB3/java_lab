package prob1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double width;
        double height;
        Console console = new Console();

        System.out.print("Width = ");
        width = Double.parseDouble(console.readLine());

        System.out.print("Height = ");
        height = Double.parseDouble(console.readLine());

        Rectangle re = new Rectangle(width, height);

        System.out.printf("Perimeter: %.2f \n", re.Perimeter());
        System.out.printf("Area: %.2f \n", re.Area());

    }
}
