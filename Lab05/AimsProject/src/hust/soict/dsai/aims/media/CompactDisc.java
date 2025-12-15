package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private final ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, String artist, String director) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public boolean addTrack(Track t) {
        if (t == null)
            return false;
        if (tracks.contains(t)) {
            System.out.println("Track already exists in CD: " + t.getTitle());
            return false;
        }
        tracks.add(t);
        setLength(getLength() + t.getLength());
        return true;
    }

    public boolean removeTrack(Track t) {
        if (t == null)
            return false;
        boolean removed = tracks.remove(t);
        if (removed) {
            setLength(getLength() - t.getLength());
        }
        return removed;
    }

    public int getTotalLength() {
        int sum = 0;
        for (Track t : tracks)
            sum += t.getLength();
        return sum;
    }

    @Override
    public String play() throws PlayerException {
        if (getLength() <= 0) {
            throw new PlayerException("CD length is non-positive: " + getTitle());
        }
        return "Playing CD: " + getTitle() + "\nCD length: " + getLength();
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }
}
