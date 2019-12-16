package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.DBResponseDisplayedBoard5Columns;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Repository.BoardDisplayedRepository;
import Boardfinder.stats.Util.ResponseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class BoardDisplayedService {

    private BoardDisplayedRepository boardDisplayedRepository;
    
     private ResponseMapper responseMapper;

    @Autowired
    public BoardDisplayedService(BoardDisplayedRepository boardDisplayedRepository,  ResponseMapper responseMapper) {
        this.boardDisplayedRepository = boardDisplayedRepository;
        this.responseMapper = responseMapper;
    }
    

    public Long getTotalNumberOfDisplayedBoards() {
        return boardDisplayedRepository.count();
    }

    public StatsResponseDtoForClient getTopXDisplayedBoards(int limit) {
        Pageable topTen = PageRequest.of(0, limit);
        return responseMapper.createResponseDtoFromDBDto(boardDisplayedRepository.findTopXByOrderByDisplayedBoardId(topTen));
    }
    
    public List<Long> getTopXDisplayedBoardsAsIdList(int limit) {
        Pageable topTen = PageRequest.of(0, limit);
        return responseMapper.mapStatsResponseDtoForClientToList(boardDisplayedRepository.findTopXByOrderByDisplayedBoardId(topTen));
    }
    
    public  StatsResponseDtoForClient getAllDisplayedBoardsAsList() {
    return responseMapper.createResponseDtoFromDB5ColumnsDto(boardDisplayedRepository.findAllByDisplayedBoards());
    }
    
    public BoardDisplayed save(BoardDisplayed dipslayedBoard) {
        return boardDisplayedRepository.save(dipslayedBoard);
    }

}

