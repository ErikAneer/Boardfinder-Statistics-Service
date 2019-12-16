
/*

 */
package Boardfinder.stats.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import java.io.Serializable;

/**
 *
 * @author Erik
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StatsResponse5ColumnsDto implements Serializable {

        Long boardId;
        String brand;
        String model;
        String gender;
        String bend;
        Long count;
        double percentage;

    public StatsResponse5ColumnsDto(Long boardId, String brand, String model, String gender, String bend, Long count, double percentage) {
        this.boardId = boardId;
        this.brand = brand;
        this.model = model;
        this.gender = gender;
        this.bend = bend;
        this.count = count;
        this.percentage = percentage;
    }

}
