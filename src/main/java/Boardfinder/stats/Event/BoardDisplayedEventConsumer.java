package Boardfinder.stats.Event;

import Boardfinder.stats.Domain.BoardDisplayed;
import Boardfinder.stats.Service.BoardDisplayedService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Event consumer class that receives events via a RabbitMQ queue and saves the received events to the database. 
 * @author Erik
 */
@Slf4j
@Component
public class BoardDisplayedEventConsumer {

    private final BoardDisplayedService boardDisplayedService;

    BoardDisplayedEventConsumer(final BoardDisplayedService boardDisplayedService) {
        this.boardDisplayedService = boardDisplayedService;
    }

    /** 
     *  Listens to the RabbitMQ queue to receive events from the Boardfinder service containing information about boards displayed.
     *  Calls the boardDisplayedService to store the incoming event to the database. 
     * @param BoardDisplayedEvent
     */
    @RabbitListener(queues = "${boarddisplayed.queue}")
    void handleBoardSearched(final BoardDisplayedEvent event) {
        log.info("Received sent board Id: {}");

        try {
            boardDisplayedService.save(new BoardDisplayed(event.getDisplayedBoardId(), event.getModel(), event.getBrand(), event.getGender(), event.getBend()));
        } catch (final Exception e) {
            log.error("Error when trying to processe the save of the search.");
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
