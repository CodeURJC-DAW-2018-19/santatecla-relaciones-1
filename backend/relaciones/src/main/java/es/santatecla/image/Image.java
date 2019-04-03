package es.santatecla.image;

public class Image {

    private int id;
    private String title;

    public Image(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Image [id=" + id + ", title=" + title + "]";
    }

}
