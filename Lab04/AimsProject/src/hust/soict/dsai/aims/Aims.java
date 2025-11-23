package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private final Store store = new Store();
    private final Cart cart = new Cart();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Aims().run();
    }

    public void run() {
        seedSampleMedia();
        while (true) {
            showMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": viewStore(); break;
                case "2": updateStoreMenu(); break;
                case "3": cartMenu(); break;
                case "0": System.out.println("Exiting. Bye!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private void viewStore() {
        store.printStore();
        while (true) {
            storeMenu();
            String c = sc.nextLine().trim();
            switch (c) {
                case "1": mediaDetailsFlow(); break;
                case "2": addMediaToCartFlow(); break;
                case "3": playMediaFlow(); break;
                case "4": cart.print(); return;
                case "0": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    private void mediaDetailsFlow() {
        System.out.print("Enter media title: ");
        String title = sc.nextLine().trim();
        Media m = store.findByTitle(title);
        if (m == null) { System.out.println("Media not found."); return; }
        System.out.println("=== Details ===");
        System.out.println(m.toString());
        mediaDetailsMenu();
        String c = sc.nextLine().trim();
        if ("1".equals(c)) {
            cart.addMedia(m);
            System.out.println("Current items in cart: " + cart.getItems().size());
        } else if ("2".equals(c)) {
            if (m instanceof Playable) ((Playable) m).play();
            else System.out.println("This media cannot be played.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private void addMediaToCartFlow() {
        System.out.print("Enter media title to add: ");
        String title = sc.nextLine().trim();
        Media m = store.findByTitle(title);
        if (m == null) { System.out.println("Media not found."); return; }
        cart.addMedia(m);
        System.out.println("Number of items in cart: " + cart.getItems().size());
    }

    private void playMediaFlow() {
        System.out.print("Enter media title to play: ");
        String title = sc.nextLine().trim();
        Media m = store.findByTitle(title);
        if (m == null) { System.out.println("Media not found."); return; }
        if (m instanceof Playable) ((Playable) m).play();
        else System.out.println("This media cannot be played.");
    }

    private void updateStoreMenu() {
        System.out.println("Update Store:");
        System.out.println("1. Add sample DVD");
        System.out.println("2. Add sample Book");
        System.out.println("3. Add sample CD");
        System.out.println("4. Remove by title");
        System.out.println("0. Back");
        String c = sc.nextLine().trim();
        switch (c) {
            case "1":
                store.addMedia(new DigitalVideoDisc(1, "The Matrix", "Action", 19.99f, 136, "Wachowski"));
                System.out.println("Added sample DVD.");
                break;
            case "2":
                Book b = new Book(2, "Learn Java", "Education", 29.99f);
                b.addAuthor("Author A");
                store.addMedia(b);
                System.out.println("Added sample Book.");
                break;
            case "3":
                CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 14.99f, "Famous Artist", "Producer");
                cd.addTrack(new Track("Hit 1", 200));
                cd.addTrack(new Track("Hit 2", 180));
                store.addMedia(cd);
                System.out.println("Added sample CD.");
                break;
            case "4":
                System.out.print("Title to remove: ");
                String title = sc.nextLine().trim();
                Media m = store.findByTitle(title);
                if (m != null) store.removeMedia(m);
                else System.out.println("Not found.");
                break;
            case "0": return;
            default: System.out.println("Invalid.");
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private void seedSampleMedia() {
        store.addMedia(new DigitalVideoDisc(100, "Spirited Away", "Animation", 12.0f, 125, "Miyazaki"));
        Book book = new Book(101, "Algorithms", "CS", 45.0f);
        book.addAuthor("Sedgewick");
        store.addMedia(book);
        CompactDisc cd = new CompactDisc(102, "Discovery", "Electronic", 9.99f, "Daft Punk", "DirectorX");
        cd.addTrack(new Track("One More Time", 320));
        cd.addTrack(new Track("Aerodynamic", 230));
        store.addMedia(cd);
    }
}
