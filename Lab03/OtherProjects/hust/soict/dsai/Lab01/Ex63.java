import java.util.Scanner;
public class Ex63{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1;i<=n;i++){
            System.out.print(" ".repeat(n-i+2));
            System.out.print("*".repeat(2*i-1));
            System.out.println(" ".repeat(n-i+2));
        }
    }
}