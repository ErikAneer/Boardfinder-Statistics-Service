/*

 */
package Boardfinder.stats.Domain;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Erik
 */
@Component
public class ResponseMapper {


    public StatsResponseDtoForClient createResponseDtoFromDBDto(List<DbResponse2Columns> stats) {
        StatsResponseDtoForClient responseObject = new StatsResponseDtoForClient();
        long totalCount = stats.stream().mapToLong(DbResponse2Columns::getCount).sum();
        responseObject.setTotalCount(totalCount);
        stats.forEach(s -> {
            responseObject.getStatsSpecification().add(new StatsResponseDto(s.getSpec(), s.getCount(), (double) s.getCount() / totalCount * 100));
        });
        return responseObject;
    }

}
