package package3.src;

import java.util.Scanner;

public class VideoLauncher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();
        int choice = 0;

        while (choice != 6) {
            System.out.println("MAIN MENU");
            System.out.println("=========");
            System.out.println("1.Add Videos:");
            System.out.println("2.Check Out Video :");
            System.out.println("3.Return Video :");
            System.out.println("4.Receive Rating :");
            System.out.println("5.List Inventory :");
            System.out.println("6.Exit :");
            System.out.print("Enter your choice (1..6): ");
            choice = Integer.parseInt(sc.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    String addName = sc.nextLine().trim();
                    videoStore.addVideo(addName);
                    break;

                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    String checkoutName = sc.nextLine().trim();
                    videoStore.doCheckout(checkoutName);
                    break;

                case 3:
                    System.out.print("Enter the name of the video you want to Return: ");
                    String returnName = sc.nextLine().trim();
                    videoStore.doReturn(returnName);
                    break;

                case 4:
                    System.out.print("Enter the name of the video you want to Rate: ");
                    String rateName = sc.nextLine().trim();
                    System.out.print("Enter the rating for this video: ");
                    int rating = Integer.parseInt(sc.nextLine().trim());
                    videoStore.receiveRating(rateName, rating);
                    break;

                case 5:
                    videoStore.listInventory();
                    break;

                case 6:
                    System.out.println("Exiting...!! Thanks for using the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            System.out.println();
        }

        sc.close();
    }
}
