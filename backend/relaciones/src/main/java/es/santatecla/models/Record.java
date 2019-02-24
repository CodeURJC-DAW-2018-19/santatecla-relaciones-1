package es.santatecla.models;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRecord;

    @Column
    private String Image;


    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
    public long getIdRecordt() {
        return idRecord;
    }

    public void setIdRecord(long idRecord) {
        this.idRecord = idRecord;
    }


}

