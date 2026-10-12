package package3.src;

public class VideoStore {

    private Video[] store;
    private int count;

    public VideoStore() {
        store = new Video[100];
        count = 0;
    }

    public void addVideo(String name) {
        store[count] = new Video(name);
        count++;
        System.out.println("Video \"" + name + "\" added successfully.");
    }

    private Video findVideo(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                return store[i];
            }
        }
        return null;
    }

    public void doCheckout(String name) {
        Video v = findVideo(name);
        if (v == null) {
            System.out.println("Video \"" + name + "\" not found in inventory.");
            return;
        }
        if (v.getCheckout()) {
            System.out.println("Video \"" + name + "\" is already checked out.");
            return;
        }
        v.doCheckout();
        System.out.println("Video \"" + name + "\" checked out successfully.");
    }

    public void doReturn(String name) {
        Video v = findVideo(name);
        if (v == null) {
            System.out.println("Video \"" + name + "\" not found in inventory.");
            return;
        }
        v.doReturn();
        System.out.println("Video \"" + name + "\" returned successfully.");
    }

    public void receiveRating(String name, int rating) {
        Video v = findVideo(name);
        if (v == null) {
            System.out.println("Video \"" + name + "\" not found in inventory.");
            return;
        }
        v.receiveRating(rating);
        System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
    }

    public void listInventory() {
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-18s | %-19s | %-6s%n", "Video Name", "Checkout Status", "Rating");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            Video v = store[i];
            System.out.printf("%-18s | %-19s | %-6d%n", v.getName(), v.getCheckout(), v.getRating());
        }
        System.out.println("-----------------------------------------------------------");
    }
}
