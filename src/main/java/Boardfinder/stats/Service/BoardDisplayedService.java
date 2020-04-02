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
 * Service class to save and retrive stats of displayed boards.
 *
 * @author Erik
 */
@Service
public class BoardDisplayedService {

    private BoardDisplayedRepository boardDisplayedRepository;

    private ResponseMapper responseMapper;

    @Autowired
    public BoardDisplayedService(BoardDisplayedRepository boardDisplayedRepository, ResponseMapper responseMapper) {
        this.boardDisplayedRepository = boardDisplayedRepository;
        this.responseMapper = responseMapper;
    }

    /**
     * Gets the total number of displayed boards.
     *
     * @return total number as Long
     */
    public Long getTotalNumberOfDisplayedBoards() {
        return boardDisplayedRepository.count();
    }

    /**
     * Gets the top X number of dipslayed boards as in one object.
     * @param limit - the number of boards to receive (descending order)
     * @return stats of the top X number of dipslayed boards in a
     * StatsResponseDtoForClient object
     */
    public StatsResponseDtoForClient getTopXDisplayedBoards(int limit) {
        Pageable topTen = PageRequest.of(0, limit);
        return responseMapper.createResponseDtoFromDBDto(boardDisplayedRepository.findTopXByOrderByDisplayedBoardId(topTen));
    }

    /**
     * Gets the top X number of dipslayed boards' ids as a list.
     * @param limit - the number of boards to receive (descending order)
     * @return a list of ids as Long
     */
    public List<Long> getTopXDisplayedBoardsAsIdList(int limit) {
        Pageable topTen = PageRequest.of(0, limit);
        return responseMapper.mapStatsResponseDtoForClientToList(boardDisplayedRepository.findTopXByOrderByDisplayedBoardId(topTen));
    }

    /**
     * Gets all dipslayed boards as in one object.
     * @param limit - the number of boards to receive (descending order)
     * @return stats of the top X number of dipslayed boards in a
     * StatsResponseDtoForClient object
     */
    public StatsResponseDtoForClient getAllDisplayedBoardsAsList() {
        return responseMapper.createResponseDtoFromDB5ColumnsDto(boardDisplayedRepository.findAllByDisplayedBoards());
    }

    /** 
     * saves info about a displayed board.
     * @param dipslayedBoard
     * @return 
     */
    public BoardDisplayed save(BoardDisplayed dipslayedBoard) {
        return boardDisplayedRepository.save(dipslayedBoard);
    }

}
