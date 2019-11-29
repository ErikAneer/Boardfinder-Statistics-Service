/*

 */
package Boardfinder.stats.Domain;

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
public class BoardDisplayed {
    
    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "boardid_s_generator", sequenceName = "boardid_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardid_s_generator")
    private long id;
    
    private long displayedBoardId;

    public BoardDisplayed(long displayedBoardId) {
        this.displayedBoardId = displayedBoardId;
    }

}
