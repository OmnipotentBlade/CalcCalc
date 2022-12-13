import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class derivative {
    public static void main(String[] args) {

        ArrayList<String> fprime = new ArrayList<String>();
        
        System.out.print("Please enter the function you wish to differentiate.\nf(x): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // ************************************ Parse input ************************************
        String delim = "[ ]+";
        String[] function = input.split(delim);

        for (int i = 0; i < function.length; i++) {

            boolean isVar = false;
            boolean isExp = false;
            int coefficient = 1;
            Integer exp = 1;

            System.out.println(function[i]);

            int indexOfExp = function[i].indexOf("^");
            int indexOfVar = function[i].indexOf("x");

            if (indexOfVar > 0) {
                isVar = true;
                
                try {
                    if (fprime.get(i - 1).equals("-")) {
                        coefficient = -(Integer.parseInt(function[i].substring(0, indexOfVar)));
                    } else {
                        coefficient = Integer.parseInt(function[i].substring(0, indexOfVar));
                    }
                } catch (IndexOutOfBoundsException e) {
                    coefficient = Integer.parseInt(function[i].substring(0, indexOfVar));
                }
                System.out.println("Coefficient: " + coefficient);
            }
            if (indexOfExp > 0) {
                exp = Integer.parseInt(function[i].substring(indexOfExp + 1));
                System.out.println("Exponent: " + exp);
                isExp = true;
            }

            if (isVar && isExp) {
                if (exp > 1) {
                    Integer deriv = (coefficient * exp);
                    exp--;
                    fprime.add(deriv.toString() + "x^" + exp.toString());
                } else {
                   Integer deriv = (coefficient * exp);
                fprime.add(deriv.toString() + "x"); 
                }
            }
            else if (isVar && isExp == false) {
                Integer deriv = coefficient;
                fprime.add(deriv.toString());
            }
            else if (isVar == false && isExp == false) {
                Integer deriv = 0;
                fprime.add(deriv.toString());
            }

        }
        
        System.out.print("\nf'(x) = ");
        for (int i = 0; i < fprime.size(); i++) {
            System.out.print(fprime.get(i));
            try {
                if (function[i + 1].equals("-")) {
                    System.out.print(" - ");
                }
                else if (function[i + 1].equals("+")) {
                    System.out.print(" + ");
                }
            } catch (IndexOutOfBoundsException e) {}
        }

    }
}