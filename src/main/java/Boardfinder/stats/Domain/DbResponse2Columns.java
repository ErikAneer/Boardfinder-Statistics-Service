package Boardfinder.stats.Domain;

import lombok.Value;

/**
 * Generic database response object class used to fetch stats data from database in a generic stats specification along with it's count.  
 * @author Erik
 */
@Value
public class DbResponse2Columns {
    
  Object spec;
  Long count;


}
