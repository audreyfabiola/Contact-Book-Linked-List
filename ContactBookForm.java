import java.util.*;

public class ContactBookForm {
    private static class Contact {
        private String name;
        private String phoneNum;
        private String email;
        private Contact next;

        public Contact(String name, String phoneNum, String email) {
            this.name = name;
            this.phoneNum = phoneNum;
            this.email = email;
            this.next = null;
        }
    }

    private static Contact head = null;

    //Menu//
    public static void displayMenu() {
        System.out.println("\n******************************");
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail Search");
        System.out.println("(P)rint List");
        System.out.println("(S)earch");
        System.out.println("(Q)uit");
        System.out.println("******************************");
        System.out.print("Please enter a command: ");
    }

    //(A)dd//
    public static void addContact() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a name: ");
        String name = input.nextLine();

        System.out.print("Enter an email address: ");
        String email = input.nextLine();

        System.out.print("Enter a phone number: ");
        String phoneNum = input.nextLine();

        Contact contact = new Contact(name, phoneNum, email);

        //Add new contact to linkedList
        if (head == null) {
            head = contact;
        } else {
            Contact current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = contact; //Add new contact to end of list
        }
        System.out.println("✅Successfully added contact!");
    }

    //(D)elete//
    public static void deleteContact() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDelete contact (by name): ");
        String name = input.nextLine();

        //Check if list is empty
        if (head == null) {
            System.out.println("❌No contact found with that name!");
            return;
        }
        //Check if first contact has matching name
        else if (head.name.equals(name)) {
            head = head.next; //Remove first contact
            System.out.println("✅Successfully deleted contact!");
            return;
        }

        //Search for contact with matching name
        Contact current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        //Reaching the end of the linkedList without finding a matching name
        if (current.next == null) {
            System.out.println("❌No contact found with that name!");
            return;
        }

        //If found, remove contact from list
        current.next = current.next.next;
        System.out.println("✅Successfully deleted contact!");
    }

    //(E)mail Search//
    public static void searchEmail() {
        Scanner input = new Scanner(System.in);
        System.out.print("Search an email address: ");
        String email = input.nextLine();

        Contact current = head;
        boolean found = false;

        //Traverse linkedList and print contacts with matching email
        while (current != null) {
            if (current.email.equals(email)) {
                System.out.println("\n\uD83D\uDC64Name: " + current.name);
                System.out.println("\uD83D\uDCDEPhone Number: " + current.phoneNum);
                System.out.println("\uD83D\uDCE7Email Address: " + current.email);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("❌No contact found with that email address!");
        }
    }

    //(P)rint List//
    public static void printList() {
        Contact current = head;
        while (current != null) {
            System.out.println("\n\uD83D\uDC64Name: " + current.name);
            System.out.println("\uD83D\uDCDEPhone Number: " + current.phoneNum);
            System.out.println("\uD83D\uDCE7Email Address: " + current.email);
            current = current.next;
        }
    }

    //(S)earch//
    public static void searchContact() {
        Scanner input = new Scanner(System.in);
        System.out.print("Search a contact name: ");
        String name = input.nextLine();

        Contact current = head;
        boolean found = false;

        //Traverse linkedList and print contacts with matching name
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("\n\uD83D\uDC64Name: " + current.name);
                System.out.println("\uD83D\uDCDEPhone Number: " + current.phoneNum);
                System.out.println("\uD83D\uDCE7Email Address: " + current.email);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("❌No contact found with that name!");
        }
    }

    //Main Method and Program Execution//
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = input.nextLine();

            if (choice.equals("A")) {
                addContact();
            } else if (choice.equals("D")) {
                deleteContact();
            } else if (choice.equals("E")) {
                searchEmail();
            } else if (choice.equals("P")) {
                printList();
            } else if (choice.equals("S")) {
                searchContact();
            }
        } while(!choice.equals("Q"));
    }
}
