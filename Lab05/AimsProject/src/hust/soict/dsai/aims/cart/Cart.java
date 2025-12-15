package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import javax.naming.LimitExceededException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media in cart has reached its limit");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }
}