
package Boardfinder.stats.Controller;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Service.BoardDisplayedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erik
 */

@RestController
@RequestMapping("/displayedboardstats")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class BoardDisplayedController {
    
    private BoardDisplayedService boardDisplayedService;

    @Autowired
    public BoardDisplayedController(BoardDisplayedService boardDisplayedService) {
        this.boardDisplayedService = boardDisplayedService;
    }

    @GetMapping("/totalsearches")
    public Long getTotalNumberOfBoardSearches() {
        return boardDisplayedService.getTotalNumberOfDisplayedBoards();
    }
    
    @GetMapping("/top3displayedboards")
    public List<Long> getTop3DisplayedBoards() {
           return boardDisplayedService.getTop3DisplayedBoards();
    }
}
