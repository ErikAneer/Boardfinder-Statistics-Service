package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.BoardSearched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */

@Repository
public interface BoardSearchedRepository extends JpaRepository<BoardSearched, Long>{
    
    //List<BoardSearch> countOrderByGenderDesc();   
    long countByGender(String gender);
    
    long countByTerrain(String terrain);
    
    long countByRiderLevel(String riderLevel);
    
    long countByShape(String shape);
    
    
    
    
}