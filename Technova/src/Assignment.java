import java.util.Scanner;

public class Assignment {
    public static void main (String[] args) {
//        UsingDataTypes();
//        UsingConditional();
        UsingLoop();
    }
    public static void UsingDataTypes (){
        char singleValue = 'a';
        int regularInteger = 9999999;
        short shortInteger = 5556;
        long largeInteger = 557788986;
        double decimalValue = 2.5;
        String message = "Using some data types";
        boolean yesNoValue = true;

        System.out.println(regularInteger + 5);
        System.out.println(shortInteger -5);
        System.out.println(largeInteger * 10);
        System.out.println(decimalValue/2);
        System.out.println(regularInteger++);
        System.out.println(shortInteger--);

        System.out.println(message + " " + singleValue + " " + regularInteger + " " + shortInteger + " " + largeInteger + " " + decimalValue + " " + yesNoValue);
    }

    public static void UsingConditional (){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if(age >= 18){
            System.out.println("You are eligible to vote!");
        } else {
            System.out.println("Sorry, you are not eligible to vote!");
        }

        System.out.println();

        System.out.print("Enter any number: ");
        int num = input.nextInt();
        if(num >= 0){
            if(num == 0) {
                System.out.println("The given number is 0");
            } else {
                System.out.println("The given number is positive.");
            }
        } else {
            System.out.println("The given number is negative");
        }

        System.out.println();

        System.out.print("Enter any two number followed by space or Enter : ");
        int firstNum = input.nextInt();
        int secondNum = input.nextInt();

        if(firstNum > secondNum){
            System.out.println(firstNum + " is greater than " + secondNum);
        } else {
            System.out.println(secondNum + " is greater than " + firstNum);
        }
        System.out.println();

        System.out.print("Enter any number to check even or odds: ");
        num = input.nextInt();
        if(num%2 == 0){
            System.out.println("The given number is even");
        } else {
            System.out.println("The given number is odd");
        }
    }

    public static void UsingLoop () {

        //Prints 10 even numbers and 10 odd numbers
        int range = 20;
        System.out.println("even" + "    " + "odd");
        while(range >0){
            if(range>8) {
                System.out.println(range + "      " + (range - 1));
            } else {
                System.out.println(range + "       " + (range - 1));
            }
            range-=2;
        }

        //Finds the factorial of a number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number to find the factorial: ");
        int num = input.nextInt();
        int factorial = 1;
        while(num>0){
            factorial *= num;
            num--;
        }
        System.out.println("Your factorial is " + factorial);

        //Generates the tables of 10
        System.out.print("Enter your number to generate tables of 10 :");
        num = input.nextInt();
        for (int i =1; i<=10; i++){
            System.out.println(num + " * " + i + " = " + num*i);
        }
        //Program to add the digits of a number
        System.out.print("Enter your number to add their digits :");
        num = input.nextInt();
        int sum = 0;
        do{
            sum += num%10;
            num/=10;
        } while(num >=10);
        System.out.println(sum+num);

        //Reverse the digits of a number
        System.out.print("Enter your number to reverse its digits :");
        String digitToReverse = input.next();

        for(int i=digitToReverse.length()-1; i>=0; i--){
            System.out.print(digitToReverse.charAt(i));
        }
        System.out.println();

        //numbers to generate 10 Fibonacci numbers
        System.out.println();
        System.out.print("First 10 Fibonacci numbers: ");
        int x = 0;
        int y = 1;
        int z = 0;
        for (int i = 0; i<10 ; i++){
            System.out.print(z + " ");
            x = y;
            y = z;
            z = x+y;
        }
        System.out.println();

    }
}
