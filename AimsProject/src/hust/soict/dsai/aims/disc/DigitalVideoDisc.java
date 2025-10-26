package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;


    public DigitalVideoDisc() {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public int getId() { return id; }


    public void setTitle(String title) {
        this.title = title;
    }

    public void printInfo() {
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Director: " + director);
        System.out.println("Length: " + length);
        System.out.println("Cost: " + cost);
    }
}
