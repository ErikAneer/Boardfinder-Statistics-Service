package Boardfinder.stats.Repository.Tokens;

import Boardfinder.stats.Domain.ActiveToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for ActiveToken entity class.
 * @author Erik
 */
@Repository
public interface ActiveTokensRepository  extends JpaRepository<ActiveToken, Long> {

        /**
         * Deteles an ActiveToken by the token String. 
         * @param token
         * @return 
         */
        boolean deleteActiveTokenByToken(String token);
}
