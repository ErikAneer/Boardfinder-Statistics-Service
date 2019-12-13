/*

 */
package Boardfinder.stats.Util;

import Boardfinder.stats.Domain.DbResponse2Columns;
import Boardfinder.stats.Domain.StatsResponseDto;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
            responseObject.getStatsSpecification().add(new StatsResponseDto(s.getSpec(), s.getCount(), (double)Math.round( (double) s.getCount() / totalCount * 100*100)/100));
        });
        return responseObject;
    }
    
    public List<Long> mapStatsResponseDtoForClientToList(List<DbResponse2Columns> stats) {
       List<Long> returnList = new ArrayList();
        stats.forEach(o-> {
            returnList.add((Long) o.getSpec());
        });
        
        return returnList;
    }

} 


