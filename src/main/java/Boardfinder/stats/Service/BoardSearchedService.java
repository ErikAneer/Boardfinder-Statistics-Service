package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Domain.DbResponse2ColumnsLongString;
import Boardfinder.stats.Domain.DbResponse2ColumnLongDouble;
import Boardfinder.stats.Domain.statsResponseDoubleDto;
import Boardfinder.stats.Domain.statsResponseDto;
import Boardfinder.stats.Domain.statsResponseStringDto;
import Boardfinder.stats.Event.BoardSearchedEvent;
import Boardfinder.stats.Repository.BoardSearchedRepository;
import Boardfinder.stats.Repository.CustomBoardSearchedQueryRepository;
import Boardfinder.stats.Domain.ResponseMapper;
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

    public statsResponseDto getSearchedFlexAndTheirCounts() {
        return responseMapper.createResponseDtoWithStringSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameString("flex"));
    }

    public statsResponseDto getSearchedBendsAndTheirCounts() {
        return responseMapper.createResponseDtoWithStringSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameString("bend"));
    }

    public statsResponseDto getSearchedShapesAndTheirCounts() {
        return responseMapper.createResponseDtoWithStringSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameString("shape"));
    }

    public statsResponseDto getSearchedShoeSizesAndTheirCounts() {
        return responseMapper.createResponseDtoWithDoubleSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameDouble("shoeSize"));
    }
    
    public statsResponseDto getSearchedGendersAndTheirCounts() {
        return responseMapper.createResponseDtoWithStringSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameString("gender"));
    }
    
     public statsResponseDto getSearchedRiderLevelsAndTheirCounts() {
        return responseMapper.createResponseDtoWithStringSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameString("riderLevel"));
    }
     
     public statsResponseDto getSearchedRiderTerrainsAndTheirCounts() {
        return responseMapper.createResponseDtoWithStringSpec(customBoardSearchedRepository.getBoardSearchedStatsByColumnNameString("terrain"));
    }

    
}
