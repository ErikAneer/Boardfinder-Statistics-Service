package Boardfinder.stats.Controller;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Domain.DbResponse2Columns;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Service.BoardSearchedService;

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
@RequestMapping("/stats")
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
    
    @GetMapping("/averageweight")
    public double getAverageWeight() {
        return boardSearchedService.getAverageWeight();
    }
    
    @GetMapping("/flex")
    public StatsResponseDtoForClient getFlexStats() {
        return boardSearchedService.getSearchedFlexAndTheirCounts();
    }
    
    @GetMapping("/bends")
    public StatsResponseDtoForClient getBendStats() {
        return boardSearchedService.getSearchedBendsAndTheirCounts();
    }
    
    @GetMapping("/shapes")
    public StatsResponseDtoForClient getShapeStats() {
        return boardSearchedService.getSearchedShapesAndTheirCounts();
    }
    
    @GetMapping("/shoesizes")
    public StatsResponseDtoForClient getShoeSizeStats() {
        return boardSearchedService.getSearchedShoeSizesAndTheirCounts();
    }
    
    @GetMapping("/gender")
    public StatsResponseDtoForClient getGenderStats() {
        return boardSearchedService.getSearchedGendersAndTheirCounts();
    }
    
    @GetMapping("/riderlevel")
    public StatsResponseDtoForClient getRiderLevelStats() {
        return boardSearchedService.getSearchedRiderLevelsAndTheirCounts();
    }
    
    @GetMapping("/terrain")
    public StatsResponseDtoForClient getTerrainStats() {
        return boardSearchedService.getSearchedRiderTerrainsAndTheirCounts();
    }
}
