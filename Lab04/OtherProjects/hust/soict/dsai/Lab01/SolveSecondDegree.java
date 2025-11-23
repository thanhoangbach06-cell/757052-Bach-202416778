import java.util.Scanner;
public class SolveSecondDegree{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int Delta = b*b - 4*a*c;
        if (a == 0){
            System.out.println("This is not a Second-Degree equation");
        } else{
            if (Delta > 0){
                System.out.println("The solution is x1 = " + ((-b + Math.sqrt(Delta))/2/a) + " and x2 = " + ((-b-Math.sqrt(Delta))/2/a));
            } else if (Delta == 0){
                System.out.println("The double root is x = " + (-b/2/a));
            } else {
                System.out.println("The equation has no solution");
            }
        }
    }
}
