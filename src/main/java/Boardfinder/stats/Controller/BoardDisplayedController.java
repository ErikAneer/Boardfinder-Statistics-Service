package Boardfinder.stats.Controller;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.DBResponseDisplayedBoard5Columns;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Service.BoardDisplayedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for displayedboards paths in the stats service.
 * Caller has to have a token with 'ROLE_ADMIN' to be able to access the class.
 * @author Erik
 */
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/displayedboards")
public class BoardDisplayedController {
    
    private final BoardDisplayedService boardDisplayedService;

    @Autowired
    public BoardDisplayedController(BoardDisplayedService boardDisplayedService) {
        this.boardDisplayedService = boardDisplayedService;
    }

    /** 
     * Gets the total number of board searches in the boardfinder app.
     * @return the total number of board searches.
     */
    @GetMapping("/totalnumber")
    public Long getTotalNumberOfBoardSearches() {
        return boardDisplayedService.getTotalNumberOfDisplayedBoards();
    }
    
     /** 
     * Gets the total number of displayed boards and the ids and count for the top ten most displayed boards in the Boardfinder app inside a StatsResponseDtoForClient object.
     * @ returnstats of the top ten displayed boards in a StatsResponseDtoForClient object.
     */
        @GetMapping("/top10displayedboards")
    public StatsResponseDtoForClient getTop10DisplayedBoards() {
           return boardDisplayedService.getTopXDisplayedBoards(10);
    }
    
    /** 
     * Gets a list with the ids of the top three most displayed boards in the Boardfinder app.
     * @return list top three displayed boards ids
     */
        @GetMapping("/top3displayedboards")
    public List<Long> getTop3DisplayedBoards() {
           return boardDisplayedService.getTopXDisplayedBoardsAsIdList(3);
    }
    
    /** 
     *  Gets the total number of displayed boards and the id's and count for all the displayed boards in the Boardfinder app inside a StatsResponseDtoForClient object.
     * @return total number of displayed boards along with ids and displayed counts for all boards in a StatsResponseDtoForClient object.
     */
    @GetMapping("/alldisplayedboards")
    public  StatsResponseDtoForClient getAllDisplayedBoards() {
           return boardDisplayedService.getAllDisplayedBoardsAsList();
    }
}
