package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.StatsResponseDtoForClient;
import Boardfinder.stats.Repository.BoardDisplayedRepository;
import Boardfinder.stats.Domain.ResponseMapper;
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

    public StatsResponseDtoForClient getTop10DisplayedBoards() {
        Pageable topTen = PageRequest.of(0, 10);
        return responseMapper.createResponseDtoFromDBDto(boardDisplayedRepository.findTop10ByOrderByDisplayedBoardId(topTen));
    }    
    
    public BoardDisplayed save(BoardDisplayed dipslayedBoard) {
        return boardDisplayedRepository.save(dipslayedBoard);
    }

}

