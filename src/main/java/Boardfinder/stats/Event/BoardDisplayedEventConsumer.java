package Boardfinder.stats.Event;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Event.BoardSearchedEvent;
import Boardfinder.stats.Service.BoardDisplayedService;
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
public class BoardDisplayedEventConsumer {

    private BoardDisplayedService boardDisplayedService;

    BoardDisplayedEventConsumer(final BoardDisplayedService boardDisplayedService) {
        this.boardDisplayedService = boardDisplayedService;
    }

    @RabbitListener(queues = "${boarddisplayed.queue}")
    void handleBoardSearched(final BoardDisplayedEvent event) {
        log.info("Received sent board Id: {}");

        try {
            boardDisplayedService.save(new BoardDisplayed(event.getDisplayedBoardId()));

        } catch (final Exception e) {
            log.error("Error when trying to processe the save of the search.");
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
