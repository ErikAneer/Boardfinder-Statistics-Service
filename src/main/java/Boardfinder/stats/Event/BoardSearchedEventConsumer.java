package Boardfinder.stats.Event;

import Boardfinder.stats.Domain.BoardSearched;
import Boardfinder.stats.Service.BoardSearchedService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Event consumer class that receives events via a RabbitMQ queue and saves the
 * received events to the database.
 *
 * @author Erik
 */
@Slf4j
@Component
public class BoardSearchedEventConsumer {

    private final BoardSearchedService boardSearchedService;

    BoardSearchedEventConsumer(final BoardSearchedService boardSearchedService) {
        this.boardSearchedService = boardSearchedService;
    }

    /*
    * Listens to the RabbitMQ queue to receive events from the Boardfinder service containing information about boards searched.
     *  Calls the boardDisplayedService to store the incoming event to the database. 
     */
    @RabbitListener(queues = "${boardsearched.queue}")
    void handleBoardSearched(final BoardSearchedEvent event) {
        log.info("Received sent board search");

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
