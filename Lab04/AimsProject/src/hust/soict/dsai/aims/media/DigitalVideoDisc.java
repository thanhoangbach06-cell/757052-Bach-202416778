package hust.soict.dsai.aims.media;

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
    public void play() {
        if (getLength() <= 0) {
            System.out.println("Cannot play DVD: " + getTitle() + " (length <= 0)");
            return;
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}
