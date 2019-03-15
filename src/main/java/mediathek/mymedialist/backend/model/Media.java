package mediathek.mymedialist.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String list;//WATCHING,COMPLETED,ON_HOLD,DROPPED,PLAN_TO_WATCH
    private String title;
    private int episodesWatched;
    private int episodesTotal;
    private String notes;
}
