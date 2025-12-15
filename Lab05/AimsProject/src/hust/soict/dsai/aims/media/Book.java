package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public void addAuthor(String authorName) {
        if (authorName == null)
            return;
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public int getContentLength(String content) {
        if (content == null || content.trim().isEmpty())
            return 0;
        return content.trim().split("\\s+").length;
    }

    @Override
    public String toString() {
        return String.format("Book: %s | Category: %s | Authors: %s | Cost: $%.2f",
                getTitle(), getCategory(), authors.toString(), getCost());
    }
}
