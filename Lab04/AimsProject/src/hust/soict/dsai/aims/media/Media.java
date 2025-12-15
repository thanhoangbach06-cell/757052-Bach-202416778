package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<>();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }
    
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }
    
    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d, Title: %s, Category: %s, Cost: $%.2f", 
                           id, title, category, cost);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return id == media.id && title.equals(media.title);
    }
}