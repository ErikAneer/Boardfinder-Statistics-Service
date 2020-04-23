package Boardfinder.stats.Repository.Stats;

import Boardfinder.stats.Domain.BoardSearched;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface in the stats service to retrieve data about board searches done in the Boardfinder app.
 * @author Erik
 */

@Repository
public interface BoardSearchedRepository extends JpaRepository<BoardSearched, Long>{
   
    /** 
     * Gets the total count of board searches for a certain terrain by terrain name. 
     * @param terrain name 
     * @return count of board searches done for the given terrain.
     */
    long countByTerrain(String terrain);
    
     /** 
     * Gets the total count of board searches for a certain riderlevel by riderlevel name. 
     * @param rider level name 
     * @return count of board searches done for the given riderlevel.
     */
    long countByRiderLevel(String riderLevel);
    
      /** 
     * Gets the total count of board searches for a certain shape by shape name. 
     * @param shape name 
     * @return count of board searches done for the given shape.
     */
    long countByShape(String shape);

    /** 
     * Gets the average rider weight for the searches done.
     * @return average rider weight as Double. 
     */
    @Query(value = "SELECT avg(b.weight) FROM BoardSearched b")
    Double avgWeight();

    /** 
     * Gets the total count of board searches.
     * @return 
     */
    long count();
}