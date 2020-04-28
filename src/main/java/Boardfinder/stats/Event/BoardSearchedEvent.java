package Boardfinder.stats.Event;

import java.io.Serializable;

import lombok.*;

/**
 * Event class used to receive information of each board search in the app from the Boardfinder service. 
 * The event class contains information about board gender, rider weight, shoesize, riderlevel, riderterrain, 
 * preferred shape, flex and bend. 
 * @author Erik
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BoardSearchedEvent implements Serializable {
 
    private final String gender;
    private final int weight;
    private final double shoeSize;
    private final String riderLevel;
    private final String terrain;
    private final String shape;
    private final String flex;
    private final String bend;

    public BoardSearchedEvent() {
        this.gender = null;
        this.weight = 0;
        this.shoeSize = 0.0;
        this.riderLevel = null;
        this.terrain = null;
        this.shape = null;
        this.flex = null;
        this.bend = null;
    }

    
    
}
