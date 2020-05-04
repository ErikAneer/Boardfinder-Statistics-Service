package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Repository.BoardSearchedRepository;
import Boardfinder.stats.Repository.CustomBoardSearchedQueryRepository;
import Boardfinder.stats.Util.ResponseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * Service class to save and retrive stats of board searches.
 * @author Erik
 */
@Service
public class BoardSearchedService {

    private BoardSearchedRepository boardSearchedRepository;

    private CustomBoardSearchedQueryRepository customBoardSearchedRepository;
    
    private ResponseMapper responseMapper;

    @Autowired
    public BoardSearchedService(BoardSearchedRepository boardSearchedRepository, CustomBoardSearchedQueryRepository customBoardSearchedRepository, ResponseMapper responseMapper) {
        this.boardSearchedRepository = boardSearchedRepository;
        this.customBoardSearchedRepository = customBoardSearchedRepository;
        this.responseMapper = responseMapper;
    }

    /** 
     * Gets a list with all the board searches 
     * @return list with BoardSearched objects
     */
    public List<BoardSearched> getAllBoardSearches() {
        return boardSearchedRepository.findAll();
    }

    /** 
     * Gets the total number of board searches. 
     * @return the total number of searches as Long. 
     */
    public Long getTotalNumberOfSearches() {
        return boardSearchedRepository.count();
    }
    
    /** 
     * Gets the average rider weight of all the board searches. 
     * @return the average reider weight as double.
     */
    public double getAverageWeight() {
        return boardSearchedRepository.avgWeight();
    }

    /** 
     * Saves a board search
     * @param search
     * @return the same board if success.
     */
    public BoardSearched save(BoardSearched search) {
        return boardSearchedRepository.save(search);
    }

    /** 
     * Gets all the searched flexes, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
    public StatsResponseDtoForClient getSearchedFlexAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("flex"));
    }

    /** 
     * Gets all the searched bends, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
    public StatsResponseDtoForClient getSearchedBendsAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("bend"));
    }

    /** 
     * Gets all the searched shapes, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
    public StatsResponseDtoForClient getSearchedShapesAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("shape"));
    }

    /** 
     * Gets all the searched shoesizes, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
    public StatsResponseDtoForClient getSearchedShoeSizesAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("shoeSize"));
    }
    
    /** 
     * Gets all the searched genders, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
    public StatsResponseDtoForClient getSearchedGendersAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("gender"));
    }
    
    /** 
     * Gets all the searched riderlevels, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
     public StatsResponseDtoForClient getSearchedRiderLevelsAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("riderLevel"));
    }
     
     /** 
     * Gets all the searched riderterrains, the total count and stats for each of them in one object.
     * @return StatsResponseDtoForClient
     */
     public StatsResponseDtoForClient getSearchedRiderTerrainsAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("terrain"));
    }
}
