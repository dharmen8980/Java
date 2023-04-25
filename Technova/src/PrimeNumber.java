import java.util.Scanner;

public class PrimeNumber {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your range for prime numbers: ");
        int range = input.nextInt();
        int base;
        String result = "";

        for (int i=2; i<=range; i++){
            for (base = 2; base<=i/2; base++){
                if(i%base==0){
                    break;
                }
            }
            if (base >= i/2){
                if(i !=4)
                   result +=i + " ";
            }
        }
        if(result.length() >1){
            System.out.println("Prime numbers in the given range of " + range + " are: " + result);
        } else {
            System.out.println("No prime numbers exist in the given range of " + range);
        }
        input.close();
    }
}
