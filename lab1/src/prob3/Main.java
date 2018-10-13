package prob3;

import prob1.Console;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        prob1.Console console = new Console();
        ArrayList<Integer> listOfDivisors = new ArrayList<Integer>();
        int n;
        System.out.print("N = ");
        n = Integer.parseInt(console.readLine());

        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0){
                listOfDivisors.add(i);
            }
        }

        if(listOfDivisors.size() >= 1){
            System.out.println(1);
            for(var i : listOfDivisors){
                System.out.println(i);
            }
            System.out.println(n);
        }
        else
        {
            System.out.println("Prime number");
        }
    }
}
