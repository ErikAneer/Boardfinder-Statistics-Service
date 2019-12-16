/*
    Object to store in database with info about the board shown in Boardfinder.
 */
package Boardfinder.stats.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Erik
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BoardDisplayed implements Serializable {
    
    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "boardid_s_generator", sequenceName = "boardid_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardid_s_generator")
    private long id;
    
    private long displayedBoardId;
    private String model;
    private String brand;
    private String gender;
    private String bend;

    public BoardDisplayed(long displayedBoardId, String model, String brand, String gender, String bend) {
        this.displayedBoardId = displayedBoardId;
        this.model = model;
        this.brand = brand;
        this.gender = gender;
        this.bend = bend;
    }
    

}
