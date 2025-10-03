import java.util.Arrays;
public class Sorting{
    public static void main(String[] args){
        int[] array = {1789,2035,1899,1456,2013};
        Arrays.sort(array);

        double sum = 0;
        for (int num : array){
            sum += num;
        }
        double ave = sum / array.length;
        System.out.println("The sorted array: " + Arrays.toString(array));
        System.out.println("Sum of all elements in array: " + sum);
        System.out.println("Average value: " + ave);
    }
}
