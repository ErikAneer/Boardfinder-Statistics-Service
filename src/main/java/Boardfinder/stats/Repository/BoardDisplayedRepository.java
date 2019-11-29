package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.BoardDisplayed;
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

    @Query("SELECT b.displayedBoardId FROM BoardDisplayed b GROUP BY b.displayedBoardId ORDER BY count(*) DESC")
    List<Long>findTop3ByOrderByDisplayedBoardId(Pageable pageable);
    
    long countByDisplayedBoardId(long id);
}
