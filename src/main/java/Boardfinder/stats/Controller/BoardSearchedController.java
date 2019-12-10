package Boardfinder.stats.Controller;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Domain.DbResponse2ColumnsLongString;
import Boardfinder.stats.Domain.statsResponseDto;
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
    public statsResponseDto getFlexStats() {
        return boardSearchedService.getSearchedFlexAndTheirCounts();
    }
    
    @GetMapping("/bends")
    public statsResponseDto getBendStats() {
        return boardSearchedService.getSearchedBendsAndTheirCounts();
    }
    
    @GetMapping("/shapes")
    public statsResponseDto getShapeStats() {
        return boardSearchedService.getSearchedShapesAndTheirCounts();
    }
    
    @GetMapping("/shoesizes")
    public statsResponseDto getShoeSizeStats() {
        return boardSearchedService.getSearchedShoeSizesAndTheirCounts();
    }
    
    @GetMapping("/gender")
    public statsResponseDto getGenderStats() {
        return boardSearchedService.getSearchedGendersAndTheirCounts();
    }
    
    @GetMapping("/riderlevel")
    public statsResponseDto getRiderLevelStats() {
        return boardSearchedService.getSearchedRiderLevelsAndTheirCounts();
    }
    
    @GetMapping("/terrain")
    public statsResponseDto getTerrainStats() {
        return boardSearchedService.getSearchedRiderTerrainsAndTheirCounts();
    }
}
