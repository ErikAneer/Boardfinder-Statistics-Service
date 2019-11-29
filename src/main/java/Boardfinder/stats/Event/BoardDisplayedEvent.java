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

    public BoardDisplayedEvent() {
        this.displayedBoardId = 0;
    }
}
