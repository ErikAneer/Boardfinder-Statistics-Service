/*

 */
package Boardfinder.stats.Repository;

import Boardfinder.stats.Domain.DbResponse2ColumnsLongString;
import Boardfinder.stats.Domain.DbResponse2ColumnLongDouble;
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
public class CustomBoardSearchedQueryRepository { //implements CustomBoardSearchedQueryRepository
    
    @PersistenceContext
   private EntityManager em;
    
    public List<DbResponse2ColumnsLongString> getBoardSearchedStatsByColumnNameString(String column) {
      TypedQuery<DbResponse2ColumnsLongString> query = em.createQuery(queryBuilderWithStringColumn(column), DbResponse2ColumnsLongString.class);
      return query.getResultList();

    }
    
    public List<DbResponse2ColumnLongDouble> getBoardSearchedStatsByColumnNameDouble(String column) {
      TypedQuery<DbResponse2ColumnLongDouble> query = em.createQuery(queryBuilderWithDoubleColumn(column), DbResponse2ColumnLongDouble.class);
      return query.getResultList();

    }
    
    private String queryBuilderWithStringColumn(String column) {
      StringBuilder sb = new StringBuilder("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnsLongString(b.");
      sb.append(column);
      sb.append(", count(b.");
      sb.append(column);
      sb.append(")) FROM BoardSearched b GROUP BY b.");
      sb.append(column);
      sb.append(" ORDER BY count(*) DESC");
      return sb.toString();
    }
    
    private String queryBuilderWithDoubleColumn(String column) {
      StringBuilder sb = new StringBuilder("SELECT new Boardfinder.stats.Domain.DbResponse2ColumnLongDouble(b.");
      sb.append(column);
      sb.append(", count(b.");
      sb.append(column);
      sb.append(")) FROM BoardSearched b GROUP BY b.");
      sb.append(column);
      sb.append(" ORDER BY count(*) DESC");
      return sb.toString();
    }
    
}
