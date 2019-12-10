/*

 */
package Boardfinder.stats.Domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Value;

/**
 *
 * @author Erik
 */

public class statsResponseDto {
    
        Long totalCount;
        List<Object> statsSpecification = new ArrayList();

    public statsResponseDto(Long totalCount, List<Object> statsSpecification) {
        this.totalCount = totalCount;
        this.statsSpecification = statsSpecification;
    }

    public statsResponseDto() {
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Object> getStatsSpecification() {
        return statsSpecification;
    }

    public void setStatsSpecification(List<Object> statsSpecification) {
        this.statsSpecification = statsSpecification;
    }

    
}
