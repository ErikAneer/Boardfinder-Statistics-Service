package Boardfinder.stats.Event;

import java.io.Serializable;

import lombok.*;

/**
 * Event class used to receive information of each displayed board in the app from the Boardfinder service. 
 * The event contains info about board id, model name, brand name, board gender, and bend name. 
 * @author Erik
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BoardDisplayedEvent implements Serializable {
 
    private final long displayedBoardId;   
    private final String model;
    private final String brand;
    private final String gender;
    private final String bend;

    public BoardDisplayedEvent() {
        this.displayedBoardId = 0;
        this.gender = "";
        this.brand = "";
        this.bend = "";
        this.model = "";
    }
}
