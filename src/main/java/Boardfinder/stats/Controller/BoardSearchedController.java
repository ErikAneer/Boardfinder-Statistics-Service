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
 * Controller class for stats routes in the stats service. 
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

    /** 
     * Gets all the board searches with it's search parameters in a list of BoardSearched objects.
     * @return A list of BoardSearched objects.
     */
    @GetMapping
    public List<BoardSearched> getAllBoardSearches() {
        return boardSearchedService.getAllBoardSearches();
    }

    /** 
     * Gets the total number of board searches. 
     * @return total number of board searches as Long.
     */
    @GetMapping("/totalsearches")
    public Long getTotalNumberBoardSearches() {
        return boardSearchedService.getTotalNumberOfSearches();
    }
    
    /** 
     *  Gets the average rider weight for all the board searches done in the Boardfinder app.
     * @return the average rider weight as a double.
     */
    @GetMapping("/averageweight")
    public double getAverageWeight() {
        return boardSearchedService.getAverageWeight();
    }
    
    /** 
     * Gets the total number of flexes searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return flex search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/flex")
    public StatsResponseDtoForClient getFlexStats() {
        return boardSearchedService.getSearchedFlexAndTheirCounts();
    }
    
    /** 
     * Gets the total number of bends searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return bend search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/bends")
    public StatsResponseDtoForClient getBendStats() {
        return boardSearchedService.getSearchedBendsAndTheirCounts();
    }
    
     /** 
     * Gets the total number of shapes searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return shape search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/shapes")
    public StatsResponseDtoForClient getShapeStats() {
        return boardSearchedService.getSearchedShapesAndTheirCounts();
    }
    
     /** 
     * Gets the total number of shoesizes searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return shoesize search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/shoesizes")
    public StatsResponseDtoForClient getShoeSizeStats() {
        return boardSearchedService.getSearchedShoeSizesAndTheirCounts();
    }
    
     /** 
     * Gets the total number of genders searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return gender search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/gender")
    public StatsResponseDtoForClient getGenderStats() {
        return boardSearchedService.getSearchedGendersAndTheirCounts();
    }
    
     /** 
     * Gets the total number of riderlevels searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return riderlevels search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/riderlevel")
    public StatsResponseDtoForClient getRiderLevelStats() {
        return boardSearchedService.getSearchedRiderLevelsAndTheirCounts();
    }
    
     /** 
     * Gets the total number of rider terrains searched togehter with id and number of searches for each id in a list inside a StatsResponseDtoForClient object.
     * @return terrains search data in a StatsResponseDtoForClient object.
     */
    @GetMapping("/terrain")
    public StatsResponseDtoForClient getTerrainStats() {
        return boardSearchedService.getSearchedRiderTerrainsAndTheirCounts();
    }
}
