

import java.util.Scanner;
public class TestRedBirdLifeEvent {




    public static void main(String[] args) {


        RedBirdLifeEvent event1 = new RedBirdLifeEvent("Success in IT168", "Workshop");
        RedBirdLifeEvent event2 = new RedBirdLifeEvent("Test Prep Seminar","Seminar", 50);
        RedBirdLifeEvent event3 = new RedBirdLifeEvent("Working in Teams","Workshop", 10);
        RedBirdLifeEvent event4 = new RedBirdLifeEvent("SIT career fair","Career fair");


        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Welcome to RedBirdLifeEvents page!");
            System.out.println("Please choose one of the following:");
            System.out.println("L - list all available events");
            System.out.println("IR - individual registration");
            System.out.println("GR - group Registration");
            System.out.println("Q - quit");

            System.out.println("Enter your choice: ");
            choice = scanner.next();

            switch (choice) {
                case "L":
                    System.out.println(event1.toString());
                    System.out.println(event2.toString());
                    System.out.println(event3.toString());
                    System.out.println(event4.toString());
                    break;
                case "IR":
                    System.out.println("For which event? ");
                    String response = scanner.nextLine();
                    if (response.equals(event1.getBarcode())) {
                        if (event1.getAvailableSeats() < event1.getEventCapacity()) {
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    if (response.equals(event2.getBarcode())) {
                        if (event2.getAvailableSeats() < event2.getEventCapacity()) {
                            System.out.println("Registration successful.");
                        } else{
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    if (response.equals(event3.getBarcode())) {
                        if (event3.getAvailableSeats() < event3.getEventCapacity()) {
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    if (response.equals(event4.getBarcode())) {
                        if (event4.getAvailableSeats() < event4.getEventCapacity()) {
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    else {
                        System.out.println("Sorry, no matching order was found.");

                    }
                    break;
                case "GR":
                    System.out.println("For which event? ");
                    String response2 = scanner.nextLine();
                    if (response2.equals(event2.getBarcode())) {
                        if (event1.getAvailableSeats() < event1.getEventCapacity()) {
                            System.out.println("How many seats? ");
                            String response3 = scanner.nextLine();
                            int num = Integer.parseInt(response3);
                            event1.register(num);
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    else if (response2.equals(event2.getBarcode())) {
                        if (event2.getAvailableSeats() < event2.getEventCapacity()) {
                            System.out.println("How many seats? ");
                            String response3 = scanner.nextLine();
                            int num = Integer.parseInt(response3);
                            event2.register(num);
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    else if (response2.equals(event1.getBarcode())) {
                        if (event3.getAvailableSeats() < event3.getEventCapacity()) {
                            System.out.println("How many seats? ");
                            String response3 = scanner.nextLine();
                            int num = Integer.parseInt(response3);
                            event3.register(num);
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    }

                    else if (response2.equals(event1.getBarcode())) {
                        if (event4.getAvailableSeats() < event4.getEventCapacity()) {
                            System.out.println("How many seats? ");
                            String response3 = scanner.nextLine();
                            int num = Integer.parseInt(response3);
                            event4.register(num);
                            System.out.println("Registration successful.");
                        } else {
                            System.out.println("Sorry, we have reached the maximum number of seats for this event.");
                        }

                    } else {
                        System.out.println("Sorry, no matching order was found.");

                    }
                    break;
                case "Q":
                    System.out.println("Goodbye! ");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (!choice.equals("Q"));

    }

}
