package Boardfinder.stats.Controller;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.DBResponseDisplayedBoard5Columns;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Service.BoardDisplayedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for promotion paths in the stats service. 
 * Open controller class. 
 * @author Erik
 */

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    
    private final BoardDisplayedService boardDisplayedService;

    @Autowired
    public PromotionController(BoardDisplayedService boardDisplayedService) {
        this.boardDisplayedService = boardDisplayedService;
    }
    
    /** 
     * Gets a list with the ids of the top three most displayed boards in the Boardfinder app.
     * @return list top three displayed boards ids
     */
        @GetMapping("/top3displayedboards")
    public List<Long> getTop3DisplayedBoards() {
           return boardDisplayedService.getTopXDisplayedBoardsAsIdList(3);
    }
}
