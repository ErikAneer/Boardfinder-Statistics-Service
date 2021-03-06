
package Boardfinder.stats.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Entity class to store in database with info about the board search parameters from a board seacrh in the Boardfinder app.
 * @author Erik
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BoardSearched implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String gender;
    private int weight;
    private double shoeSize;
    private String riderLevel;
    private String terrain;
    private String shape;
    private String flex;
    private String bend;

    public BoardSearched(String gender, int weight, double shoeSize, String riderLevel, String terrain, String shape, String flex, String bend) {
        this.gender = gender;
        this.weight = weight;
        this.shoeSize = shoeSize;
        this.riderLevel = riderLevel;
        this.terrain = terrain;
        this.shape = shape;
        this.flex = flex;
        this.bend = bend;
    }
}
