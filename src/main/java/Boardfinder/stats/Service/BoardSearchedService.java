package Boardfinder.stats.Service;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Event.BoardSearchedEvent;
import Boardfinder.stats.Repository.BoardSearchedRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSearchedService {
    
    private BoardSearchedRepository boardSearchedRepository;

    @Autowired
    public BoardSearchedService(BoardSearchedRepository boardSearchedRepository) {
        this.boardSearchedRepository = boardSearchedRepository;
    }

    public List<BoardSearched> getAllBoardSearches() {
        return boardSearchedRepository.findAll();
    }

    public Long getTotalNumberOfSearches() {
        return boardSearchedRepository.count();
    }

    public BoardSearched save(BoardSearched search) {
        return boardSearchedRepository.save(search);
    }

}