import javax.swing.JOptionPane;

public class SolveLinearEquation{
    public static void main(String[] args){
        String strNum1,strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2 + '\n';
        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        if (a == 0){
            if (b == 0){
                strNotification += "The equation has infinity solutions";
            } else {
                strNotification += "The equation has no solution";
            }
        } else {
            if (b==0){
                strNotification += "The equation has an unique solution x = 0";
            } else{
                strNotification += "The equation has an unique solution x = " + (-b/a);
            }
        }
        JOptionPane.showMessageDialog(null,strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
