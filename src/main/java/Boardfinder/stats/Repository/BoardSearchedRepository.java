package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Domain.DbResponse2ColumnsLongString;
import Boardfinder.stats.Domain.DbResponse2ColumnLongDouble;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */

@Repository
public interface BoardSearchedRepository extends JpaRepository<BoardSearched, Long>{
    
    
    long countByTerrain(String terrain);
    
    long countByRiderLevel(String riderLevel);
    
    long countByShape(String shape);
    
    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnsLongString(b.flex, count(b.flex)) FROM BoardSearched b GROUP BY b.flex ORDER BY count(*) DESC")
    List<DbResponse2ColumnsLongString> getFlexesAndCountDescending();
    
    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnsLongString(b.bend, count(b.bend)) FROM BoardSearched b GROUP BY b.bend ORDER BY count(*) DESC")
    List<DbResponse2ColumnsLongString> getBendsAndCountDescending();
    
    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnsLongString(b.shape, count(b.shape)) FROM BoardSearched b GROUP BY b.shape ORDER BY count(*) DESC")
    List<DbResponse2ColumnsLongString> getShapesAndCountDescending();
    
    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnLongDouble(b.shoeSize, count(b.shoeSize)) FROM BoardSearched b GROUP BY b.shoeSize ORDER BY count(*) DESC")
    List<DbResponse2ColumnLongDouble> getShoeSizesAndCountDescending(); // lägg till (Pageable pageable); 
    
     @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnsLongString(b.gender, count(b.gender)) FROM BoardSearched b GROUP BY b.gender ORDER BY count(*) DESC")
    List<DbResponse2ColumnsLongString> countOrderByGenderDesc();
    
    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnsLongString(b.terrain, count(b.terrain)) FROM BoardSearched b GROUP BY b.terrain ORDER BY count(*) DESC")
    List<DbResponse2ColumnsLongString> countOrderByTerrainDesc();

    @Query(value = "SELECT avg(b.weight) FROM BoardSearched b")
    Double avgWeight();

    long count();
}