package Boardfinder.stats.Event;

import java.io.Serializable;

import lombok.*;

/**
 *
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
