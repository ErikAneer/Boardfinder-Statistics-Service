/*

 */
package Boardfinder.stats.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BoardSearched implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "bend_s_generator", sequenceName = "bend_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bend_s_generator")
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
