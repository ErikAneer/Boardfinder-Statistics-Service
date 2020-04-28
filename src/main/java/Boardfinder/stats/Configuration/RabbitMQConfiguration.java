package Boardfinder.stats.Configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/** 
 * Configuration class for Rabbit MQ. Needed to listen to the RabbitMQ Message Broker queues to receive messeges from it.
 * @author Erik
 */
@EnableRabbit
@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {
    
    /** 
     * Creates the Topic Exchange for the BoardSearched Event Exchange.
     * @param exchangeName
     * @return a TopicExchange used for the boardSearched queue
     */
    @Bean
    public TopicExchange boardSearchedEventExchange(@Value ("${boardsearched.exchange}") final String exchangeName) {
            return new TopicExchange(exchangeName);
    }
    
    /** 
     * Creates the Topic Exchange for the BoardDispalyed Event Exchange.
     * @param exchangeName
     * @return a TopicExchange used for the boardDisplayed queue
     */
    @Bean
    public TopicExchange boardDisplayedEventExchange(@Value ("${boarddisplayed.exchange}") final String exchangeName) {
            return new TopicExchange(exchangeName);
    }
    
    /** 
     * Creates the boardSearched queue
     * @param queueName
     * @return the boardSearched queue
     */
    @Bean
    public Queue boardSearchedQueue (@Value("${boardsearched.queue}") final String queueName) {
            return new Queue(queueName, true);
    }
    
    /** 
     * Creates the boardDisplayeded queue
     * @param queueName
     * @return the boardDisplayeded queue
     */
    @Bean
    public Queue boardDisplayedQueue (@Value("${boarddisplayed.queue}") final String queueName) {
            return new Queue(queueName, true);
    }
    
    /** 
     * Binds the boardSearchedQueue, boardSearchedEventExchange and routing key together to connect to the BoardSearchedQueue.
     * @param boardSearchedQueue
     * @param boardSearchedEventExchange
     * @param routingkey
     * @return the binding needed to connect to the boardSearchedQueue
     */
        @Bean
        Binding bindingBoardSearched(final Queue boardSearchedQueue, final TopicExchange boardSearchedEventExchange,
            @Value("${boardsearched.routing-key}") final String routingkey) {
        return BindingBuilder.bind(boardSearchedQueue).to(boardSearchedEventExchange).with(routingkey);
    }
     
        /** 
         *  Binds the boardDisplayedQueue, boardDisplayedEventExchange and routing key together to connect to the BoardDisplayedQueue
         * @param boardDisplayedQueue
         * @param boardDisplayedEventExchange
         * @param routingkey
         * @return the binding needed to connect to the boardDisplayedQueue
         */
        @Bean
        Binding bindingBoardDisplayed(final Queue boardDisplayedQueue, final TopicExchange boardDisplayedEventExchange,
            @Value("${boarddisplayed.routing-key}") final String routingkey) {
        return BindingBuilder.bind(boardDisplayedQueue).to(boardDisplayedEventExchange).with(routingkey);
    }
    
    
    /** 
     * Creates a MappingJackson2MessageConverter for deserializing received JSON messages.
     * @return MappingJackson2MessageConverter
     */
    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
                return new MappingJackson2MessageConverter();
    }
    
    /** 
     * Creates a DefaultMessageHandlerMethodFactory and sets the MappingJackson2MessageConverter to if for JSON deserializing.
     * @return a DefaultMessageHandlerMethodFactory
     */
    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
                DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
                factory.setMessageConverter(consumerJackson2MessageConverter());
                return factory;
        }
    
    /** 
     * Configures the Rabbit listener by setting the DefaultMessageHandlerMethodFactory with the MappingJackson2MessageConverter to it. 
     * @param registrar 
     */
    @Override
    public void configureRabbitListeners( final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}
