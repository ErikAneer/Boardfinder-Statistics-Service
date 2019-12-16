package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.DBResponseDisplayedBoard5Columns;
import Boardfinder.stats.Domain.DbResponse2Columns;
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
public interface BoardDisplayedRepository extends JpaRepository<BoardDisplayed, Long>{

    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2Columns(b.displayedBoardId, count(b.displayedBoardId)) FROM BoardDisplayed b GROUP BY b.displayedBoardId ORDER BY count(*) DESC")
    List<DbResponse2Columns>findTopXByOrderByDisplayedBoardId(Pageable pageable);
    
    @Query("SELECT new Boardfinder.stats.Domain.DBResponseDisplayedBoard5Columns(b.displayedBoardId, b.brand, b.model, b.gender, b.bend, count(b.displayedBoardId)) FROM BoardDisplayed b GROUP BY b.displayedBoardId ORDER BY count(*) DESC")
    List<DBResponseDisplayedBoard5Columns>findAllByDisplayedBoards();
    
    
    
    long countByDisplayedBoardId(long id);
}
