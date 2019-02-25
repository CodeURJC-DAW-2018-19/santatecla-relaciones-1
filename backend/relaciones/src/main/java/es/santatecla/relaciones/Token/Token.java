package es.santatecla.relaciones.Token;

import es.santatecla.relaciones.user.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String subtitle;
    //private List<String> elements;
    private String firstFieldForWhat;
    private String secondFieldWhat;
    private String thirdFieldHow;
    private Image image;
    public Token(){}

    public Token(String title, String subtitle, /*List<String> elements,*/ String firstFieldForWhat, String secondFieldWhat, String thirdFieldHow){
        this.title = title;
        this.subtitle = subtitle;
        //this.elements = elements;
        this.firstFieldForWhat = firstFieldForWhat;
        this.secondFieldWhat = secondFieldWhat;
        this.thirdFieldHow = thirdFieldHow;
    }
    public Token(String title, String subtitle, /*List<String> elements,*/ String firstFieldForWhat, String secondFieldWhat, String thirdFieldHow,  Image image){
        this.title = title;
        this.subtitle = subtitle;
        //this.elements = elements;
        this.firstFieldForWhat = firstFieldForWhat;
        this.secondFieldWhat = secondFieldWhat;
        this.thirdFieldHow = thirdFieldHow;
        this.image = image;
    }


    public Token(Token token){
        this.title = token.title;
        this.subtitle = token.subtitle;
        this.firstFieldForWhat = token.firstFieldForWhat;
        this.secondFieldWhat = token.secondFieldWhat;
        this.thirdFieldHow = token.thirdFieldHow;
        this.image=token.image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /*
    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }
    */

    public String getFirstFieldForWhat() {
        return firstFieldForWhat;
    }

    public void setFirstFieldForWhat(String firstFieldForWhat) {
        this.firstFieldForWhat = firstFieldForWhat;
    }

    public String getSecondFieldWhat() {
        return secondFieldWhat;
    }

    public void setSecondFieldWhat(String secondFieldWhat) {
        this.secondFieldWhat = secondFieldWhat;
    }

    public String getThirdFieldHow() {
        return thirdFieldHow;
    }

    public void setThirdFieldHow(String thirdFieldHow) {
        this.thirdFieldHow = thirdFieldHow;
    }

}