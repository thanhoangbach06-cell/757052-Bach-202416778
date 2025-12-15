package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added to store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store: " + media.getTitle());
        }
    }

    public Media findByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}