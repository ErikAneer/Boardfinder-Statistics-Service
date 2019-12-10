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
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class statsResponseLongDto {
    
        Long spec;
        Long count;
        double percentage;

    public statsResponseLongDto(Long spec, Long count, double percentage) {
        this.spec = spec;
        this.count = count;
        this.percentage = percentage;
    }
        
        
}
