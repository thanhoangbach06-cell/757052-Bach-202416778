package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qty = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (qty >= MAX_ITEMS_IN_STORE) {
            System.out.println("Store is full. Cannot add more DVDs.");
            return;
        }
        itemsInStore[qty++] = disc;
        System.out.println("Added to store: " + disc.getTitle());
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qty; i++) {
            if (itemsInStore[i] == disc) {
                found = true;
                for (int j = i; j < qty - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qty - 1] = null;
                qty--;
                System.out.println("Removed from store: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in store: " + (disc == null ? "null" : disc.getTitle()));
        }
    }

    public void removeDVDById(int id) {
        boolean found = false;
        for (int i = 0; i < qty; i++) {
            if (itemsInStore[i].getId() == id) {
                removeDVD(itemsInStore[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No DVD with id " + id + " found in store.");
    }

    public DigitalVideoDisc[] searchByTitle(String title) {
        DigitalVideoDisc[] results = new DigitalVideoDisc[qty];
        int r = 0;
        for (int i = 0; i < qty; i++) {
            if (itemsInStore[i].getTitle() != null && itemsInStore[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                results[r++] = itemsInStore[i];
            }
        }
        DigitalVideoDisc[] trimmed = new DigitalVideoDisc[r];
        System.arraycopy(results, 0, trimmed, 0, r);
        return trimmed;
    }

    public void printStore() {
        System.out.println("---------- STORE ----------");
        for (int i = 0; i < qty; i++) {
            System.out.print((i+1) + ". ");
            itemsInStore[i].printInfo();
            System.out.println("---------------------------");
        }
        if (qty == 0) System.out.println("Store is empty.");
    }

    public DigitalVideoDisc[] getItemsInStore() {
        DigitalVideoDisc[] copy = new DigitalVideoDisc[qty];
        System.arraycopy(itemsInStore, 0, copy, 0, qty);
        return copy;
    }

    public int getQty() {
        return qty;
    }
}
