import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();

        int d = digit;
        int counter = 0;
        while (d > 0) {
            d = d / 10;
            counter++;
        }
        System.out.println(" Digit length : " + counter);
        d = digit;
        boolean flag = false;
        for (int i = counter; i > 0; i--) {
            if (d % i == 0) {
                d = d / 10;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Digit is Polydivisble");
        } else {
            System.out.println("Digit is not Polydivisble");
        }
    }

}
