package Boardfinder.stats.Domain;

import lombok.Value;

/**
 * Database response object class used to retrieve data of displayed boards from database in five columns: 
 * board id, brand name, board model, board gender, bend name and count of displays. 
 * @author Erik
 */
@Value
public class DBResponseDisplayedBoard5Columns {
    
    Long boardId;
    String brand;
    String model;
    String gender;
    String bend;
    Long count;
}
