/*
    Repository class for creation of dynamic queries 
 */
package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.DbResponse2Columns;
import java.text.MessageFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public class CustomBoardSearchedQueryRepository {
    
    @PersistenceContext
   private EntityManager em;
    
    public List<DbResponse2Columns> getBoardSearchedStatsByColumnName(String column) {
      TypedQuery<DbResponse2Columns> query = em.createQuery(queryBuilder("DbResponse2Columns",column), DbResponse2Columns.class);
      return query.getResultList();
    }
    
    private String queryBuilder(String className, String column) {
      return MessageFormat.format("SELECT new Boardfinder.stats.Domain.{0}(b.{1}, count(b.{1})) FROM BoardSearched b GROUP BY b.{1} ORDER BY count(*) DESC", className, column);
    }
}
