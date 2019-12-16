
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
 *
 * @author Erik
 */

@RestController
@RequestMapping("/displayedboards")
public class BoardDisplayedController {
    
    private BoardDisplayedService boardDisplayedService;

    @Autowired
    public BoardDisplayedController(BoardDisplayedService boardDisplayedService) {
        this.boardDisplayedService = boardDisplayedService;
    }

    @GetMapping("/totalnumber")
    public Long getTotalNumberOfBoardSearches() {
        return boardDisplayedService.getTotalNumberOfDisplayedBoards();
    }
    
        @GetMapping("/top10displayedboards")
    public StatsResponseDtoForClient getTop10DisplayedBoards() {
           return boardDisplayedService.getTopXDisplayedBoards(10);
    }
    
        @GetMapping("/top3displayedboards")
    public List<Long> getTop3DisplayedBoards() {
           return boardDisplayedService.getTopXDisplayedBoardsAsIdList(3);
    }
    
    @GetMapping("/alldisplayedboards")
    public  StatsResponseDtoForClient getAllDisplayedBoards() {
           return boardDisplayedService.getAllDisplayedBoardsAsList();
    }
}
