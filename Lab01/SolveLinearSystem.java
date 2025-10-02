import java.util.Scanner;
public class SolveLinearSystem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a11 = sc.nextInt();
        int a12 = sc.nextInt();
        int b1 = sc.nextInt();
        int a21 = sc.nextInt();
        int a22 = sc.nextInt();
        int b2 = sc.nextInt();
        int D = a11*a22 - a21*a12;
        int D1 = b1*a22-b2*a12;
        int D2 = a11*b2 - a21*b1;
        if (D!=0){
            System.out.println("The solution is x1 = " + (D1/D) + " and x2 = " + (D2/D));
        } else {
            if (D1==0 && D2==0){
                System.out.println("The system has infinity solution");
            } else {
                System.out.println("The system has no solution");
            }
        }
    }
}
