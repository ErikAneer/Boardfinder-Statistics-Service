package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Repository.BoardSearchedRepository;
import Boardfinder.stats.Repository.CustomBoardSearchedQueryRepository;
import Boardfinder.stats.Util.ResponseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<BoardSearched> getAllBoardSearches() {
        return boardSearchedRepository.findAll();
    }

    public Long getTotalNumberOfSearches() {
        return boardSearchedRepository.count();
    }
    
    public double getAverageWeight() {
        return boardSearchedRepository.avgWeight();
    }

    public BoardSearched save(BoardSearched search) {
        return boardSearchedRepository.save(search);
    }

    public StatsResponseDtoForClient getSearchedFlexAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("flex"));
    }

    public StatsResponseDtoForClient getSearchedBendsAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("bend"));
    }

    public StatsResponseDtoForClient getSearchedShapesAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("shape"));
    }

    public StatsResponseDtoForClient getSearchedShoeSizesAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("shoeSize"));
    }
    
    public StatsResponseDtoForClient getSearchedGendersAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("gender"));
    }
    
     public StatsResponseDtoForClient getSearchedRiderLevelsAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("riderLevel"));
    }
     
     public StatsResponseDtoForClient getSearchedRiderTerrainsAndTheirCounts() {
        return responseMapper.createResponseDtoFromDBDto(customBoardSearchedRepository.getBoardSearchedStatsByColumnName("terrain"));
    }

    
}
