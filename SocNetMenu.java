import java.util.*;

public class SocNetMenu{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        

        System.out.println("Enter File: ");
        String filePath = scanner.nextLine();
        SocialNetwork socialNetwork = new SocialNetwork(fileReader.loadGraphFromFile(filePath));

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("[1] Display friend list");
            System.out.println("[2] Display connections");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the person ID: ");
                    int personId = scanner.nextInt();
                    socialNetwork.showFriendList(personId);
                    break;
                case 2:
                    System.out.print("Enter the first person ID: ");
                    int person1 = scanner.nextInt();
                    System.out.print("Enter the second person ID: ");
                    int person2 = scanner.nextInt();
                    socialNetwork.dispConnection(person1, person2);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}