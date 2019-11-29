package Boardfinder.stats.Controller;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Event.BoardSearchedEvent;
import Boardfinder.stats.Service.BoardSearchedService;

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
@RequestMapping("/stats")
@CrossOrigin(origins = "http://localhost:4200")
public class BoardSearchedController {

    private BoardSearchedService boardSearchedService;

    @Autowired
    public BoardSearchedController(BoardSearchedService boardSearchedService) {
        this.boardSearchedService = boardSearchedService;
    }

    @GetMapping
    public List<BoardSearched> getAllBoardSearches() {
        return boardSearchedService.getAllBoardSearches();
    }

    @GetMapping("/totalsearches")
    public Long getTotalNumberBoardSearches() {
        return boardSearchedService.getTotalNumberOfSearches();
    }
}
