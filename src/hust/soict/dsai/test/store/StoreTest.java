package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc d2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc d3 = new DigitalVideoDisc("Aladdin", "Animation", "Guy Ritchie", 90, 18.99f);
        DigitalVideoDisc d4 = new DigitalVideoDisc("The King", "Drama", "Someone", 120, 12.50f);

        store.addDVD(d1);
        store.addDVD(d2);
        store.addDVD(d3);
        store.addDVD(d4);

        System.out.println("\n-- Print store after add --");
        store.printStore();

        System.out.println("\n-- Search 'king' --");
        DigitalVideoDisc[] results = store.searchByTitle("king");
        if (results.length == 0) System.out.println("No results.");
        else {
            for (DigitalVideoDisc d : results) d.printInfo();
        }

        System.out.println("\n-- Remove Star Wars --");
        store.removeDVD(d2);

        System.out.println("\n-- Print store after remove --");
        store.printStore();

        System.out.println("\n-- Remove by id (d1 id) --");
        store.removeDVDById(d1.getId());
        store.printStore();
    }
}
