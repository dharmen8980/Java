import java.util.Scanner;

public class ArmstrongNumber {
    public static void main (String[] args){
        int temp, numDigit=0, armstrongNum=0;

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        temp = num;
        while(temp >0){
            temp/=10;
            numDigit+=1;
        }
        temp = num;
        while(temp>0){
            int digit = temp%10;
            armstrongNum += Math.pow(digit, numDigit);
            temp/=10;
        }
        System.out.println(armstrongNum);
    }
}
