package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.DbResponse2ColumnLongLong;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Query("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnLongLong(b.displayedBoardId, count(b.displayedBoardId)) FROM BoardDisplayed b GROUP BY b.displayedBoardId ORDER BY count(*) DESC")
    List<DbResponse2ColumnLongLong>findTop10ByOrderByDisplayedBoardId(Pageable pageable);
    
    long countByDisplayedBoardId(long id);
}
