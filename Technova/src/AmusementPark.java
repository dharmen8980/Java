import java.util.Scanner;
public class AmusementPark {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our Amusement Park! Our tickets are priced at Rs 400 per tickets.\nHowever,As part of our special program, if you buy more than 10 tickets, you will get 10% discount.");
        System.out.println();

        System.out.print("Enter the number of tickets you want: ");
        int numTickets = input.nextInt();

        if(numTickets < 10){
            System.out.println("Your total price is Rs " + numTickets * 400);
        } else {
            System.out.println("Your total price is Rs " + numTickets * 400 * 0.9);
        }
    }
}
