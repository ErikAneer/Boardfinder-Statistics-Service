/*

 */
package Boardfinder.stats.Domain;

import Boardfinder.stats.Domain.DbResponse2ColumnLongDouble;
import Boardfinder.stats.Domain.DbResponse2ColumnLongLong;
import Boardfinder.stats.Domain.DbResponse2ColumnsLongString;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Erik
 */
@Component
public class ResponseMapper {


    public statsResponseDto createResponseDtoWithStringSpec(List<DbResponse2ColumnsLongString> stats) {
        statsResponseDto responseObject = new statsResponseDto();
        long totalCount = stats.stream().mapToLong(DbResponse2ColumnsLongString::getCount).sum();
        responseObject.setTotalCount(totalCount);
        stats.forEach(s -> {
            responseObject.getStatsSpecification().add(new statsResponseStringDto(s.getSpec(), s.getCount(), (double) s.getCount() / totalCount * 100));
        });
        return responseObject;
    }

    public statsResponseDto createResponseDtoWithDoubleSpec(List<DbResponse2ColumnLongDouble> stats) {

        statsResponseDto responseObject = new statsResponseDto();
        long totalCount = stats.stream().mapToLong(DbResponse2ColumnLongDouble::getCount).sum();
        responseObject.setTotalCount(totalCount);
        stats.forEach(s -> {
            responseObject.getStatsSpecification().add(new statsResponseDoubleDto(s.getSpec(), s.getCount(), (double) s.getCount() / totalCount * 100));
        });
        return responseObject;
    }
    
     public statsResponseDto createResponseDtoWithLongSpec(List<DbResponse2ColumnLongLong> stats) {

        statsResponseDto responseObject = new statsResponseDto();
        long totalCount = stats.stream().mapToLong(DbResponse2ColumnLongLong::getCount).sum();
        responseObject.setTotalCount(totalCount);
        stats.forEach(s -> {
            responseObject.getStatsSpecification().add(new statsResponseLongDto(s.getId(), s.getCount(), (double) s.getCount() / totalCount * 100));
        });
        return responseObject;
    }
    
}
