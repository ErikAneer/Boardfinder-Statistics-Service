package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Repository.BoardDisplayedRepository;
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

    @Autowired
    public BoardDisplayedService(BoardDisplayedRepository boardDisplayedRepository) {
        this.boardDisplayedRepository = boardDisplayedRepository;
    }
    
   

    public Long getTotalNumberOfDisplayedBoards() {
        return boardDisplayedRepository.count();
    }

    //Get top 3 searched boards List<Long, Integer> id / count
    public List<Long> getTop3DisplayedBoards() {
        Pageable topThree = new PageRequest(0, 3);
        return boardDisplayedRepository.findTop3ByOrderByDisplayedBoardId(topThree);
    }    
    
    public BoardDisplayed save(BoardDisplayed dipslayedBoard) {
        return boardDisplayedRepository.save(dipslayedBoard);
    }

}
