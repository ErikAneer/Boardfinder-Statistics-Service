package Boardfinder.stats.Service;

import Boardfinder.stats.Repository.Tokens.TokenRepository;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class ActiveTokenService {
    
    
        private final TokenRepository repo;
        
        @Autowired 
        public ActiveTokenService (TokenRepository repo) {
                this.repo = repo;
        }
        
        public boolean checkIfActiveToken(String token) throws AccessDeniedException {
           
            Long activeTokenInDB = null;
            
           activeTokenInDB =  repo.getActiveTokenIdByToken(token);  
            
           if(activeTokenInDB == null){
                return false;
            } 
            
           repo.setTimeStampLastUpdatedByToken(LocalDateTime.now(), activeTokenInDB);
           return true;
        }
}
