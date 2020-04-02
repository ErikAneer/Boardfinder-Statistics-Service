
package Boardfinder.stats.Domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import java.io.Serializable;

/**
 * Generic data transfer object class used to store stats data to be used in return object(s) in controller class with specification, count and percentage. 
 * @author Erik
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class StatsResponseDto implements Serializable{
        
        Object spec;
        Long count;
        double percentage;

    public StatsResponseDto(Object spec, Long count, double percentage) {
        this.spec = spec;
        this.count = count;
        this.percentage = percentage;
    }

    
}
