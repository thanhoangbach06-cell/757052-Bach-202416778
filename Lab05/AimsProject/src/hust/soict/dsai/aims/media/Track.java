package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.Playable;
import java.util.Objects;
import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String play() throws PlayerException {
        if (length <= 0) {
            throw new PlayerException("Track length is non-positive: " + title);
        }
        return "Playing track: " + title + "\nTrack length: " + length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Track))
            return false;
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
