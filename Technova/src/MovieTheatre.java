import java.util.Scanner;

public class MovieTheatre {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our movie theatre.\nWe have two tickets category: Silver, and Gold.\nSilver tickets are priced at Rs 450, and Gold tickets are priced at Rs 600 each.");

        System.out.println("Choose your ticket type:\n1. Silver\n2.Gold\nType wither 1 or silver for Silver and 2 or gold for Gold");
        System.out.print("Your ticket type: ");
        String ticketType = input.nextLine();

        boolean isCorrectTicketType = false;
        int numTickets;

        while(!isCorrectTicketType) {

            if (ticketType.equals("1") || ticketType.equals("silver")) {
                System.out.print("Choose number of tickets: ");
                numTickets = input.nextInt();
                System.out.println();
                System.out.println("Your total price is Rs " + numTickets * 450);
                isCorrectTicketType = true;

            } else if (ticketType.equals("2") || ticketType.equals("gold")) {
                System.out.print("Choose number of tickets: ");
                numTickets = input.nextInt();
                System.out.println();
                System.out.println("Your total price is Rs " + numTickets * 600);
                isCorrectTicketType = true;

            } else {
                System.out.println("Please choose a valid ticket type");
                ticketType = input.next();
            }
        }
    }
}
