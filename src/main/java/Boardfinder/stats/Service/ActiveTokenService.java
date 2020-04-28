package Boardfinder.stats.Service;

import Boardfinder.stats.Repository.Tokens.TokenRepository;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to handle tokens in the Stats application
 *
 * @author Erik
 */
@Service
public class ActiveTokenService {

    private final TokenRepository repo;

    @Autowired
    public ActiveTokenService(TokenRepository repo) {
        this.repo = repo;
    }

    /**
     * Checks if an ActiveToken exists in the database in order to be able to
     * grant or deny access.
     *
     * @param token as String
     * @return boolean
     * @throws AccessDeniedException when an ActiveToken is missing.
     */
    public boolean checkIfActiveToken(String token) throws AccessDeniedException {

        Long activeTokenInDB = null;

        activeTokenInDB = repo.getActiveTokenIdByToken(token);

        if (activeTokenInDB == null) {
            return false;
        }

        repo.setTimeStampLastUpdatedByToken(LocalDateTime.now(), activeTokenInDB);
        return true;
    }
}
