package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title) {
        this(title, "Unknown", "Unknown", 0, 0.0f);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public DigitalVideoDisc() {
        this("Unknown", "Unknown", "Unknown", 0, 0.0f);
    }

    @Override
    public String play() throws PlayerException {
        if (getLength() <= 0) {
            throw new PlayerException("DVD length is non-positive: " + getTitle());
        }
        return "Playing DVD: " + getTitle() + "\nDVD length: " + getLength();
    }
}
