package Boardfinder.stats.Event;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Event.BoardSearchedEvent;
import lombok.extern.slf4j.Slf4j;
import Boardfinder.stats.Service.BoardSearchedService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 *
 * @author Erik
 */
@Slf4j
@Component
public class BoardSearchedEventConsumer {

    private BoardSearchedService boardSearchedService;

    BoardSearchedEventConsumer(final BoardSearchedService boardSearchedService) {
        this.boardSearchedService = boardSearchedService;
    }

    @RabbitListener(queues = "${boardsearched.queue}")
    void handleBoardSearched(final BoardSearchedEvent event) {
        log.info("Received sent board search: {}");

        try {
            boardSearchedService.save(new BoardSearched(
                    event.getGender(), event.getWeight(), event.getShoeSize(), event.getRiderLevel(),
                    event.getTerrain(), event.getShape(), event.getFlex(), event.getBend()
            ));
        } catch (final Exception e) {
            log.error("Error when trying to processe the save of the search.");
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }

}
