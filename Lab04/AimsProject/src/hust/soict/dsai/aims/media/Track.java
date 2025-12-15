package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.Playable;
import java.util.Objects;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (length <= 0) {
            System.out.println("Cannot play track: " + title + " (length <= 0)");
            return;
        }
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return this.length == other.length && Objects.equals(this.title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", title, length);
    }
}
