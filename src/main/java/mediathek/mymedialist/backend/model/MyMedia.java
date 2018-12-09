package mediathek.mymedialist.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class MyMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private List list;
    private Type type;

    private String title;
    private int episodesWatched;
    private int episodesTotal;
    private int score;
    private String notes;

}
