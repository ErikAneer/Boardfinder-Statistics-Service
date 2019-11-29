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
 *
 * @author Erik
 */

@EnableRabbit
@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {
    
    
    @Bean
    public TopicExchange boardSearchedEventExchange(@Value ("${boardsearched.exchange}") final String exchangeName) {
            return new TopicExchange(exchangeName);
    }
    
        @Bean
    public TopicExchange boardDisplayedEventExchange(@Value ("${boarddisplayed.exchange}") final String exchangeName) {
            return new TopicExchange(exchangeName);
    }
    
    @Bean
    public Queue boardSearchedQueue (@Value("${boardsearched.queue}") final String queueName) {
            return new Queue(queueName, true);
    }
    
        @Bean
    public Queue boardDisplayedQueue (@Value("${boarddisplayed.queue}") final String queueName) {
            return new Queue(queueName, true);
    }
    
        @Bean
        Binding bindingBoardSearched(final Queue boardSearchedQueue, final TopicExchange boardSearchedEventExchange,
            @Value("${boardsearched.routing-key}") final String routingkey) {
        return BindingBuilder.bind(boardSearchedQueue).to(boardSearchedEventExchange).with(routingkey);
    }
        
                @Bean
        Binding bindingBoardDisplayed(final Queue boardDisplayedQueue, final TopicExchange boardDisplayedEventExchange,
            @Value("${boarddisplayed.routing-key}") final String routingkey) {
        return BindingBuilder.bind(boardDisplayedQueue).to(boardDisplayedEventExchange).with(routingkey);
    }
    
    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
                return new MappingJackson2MessageConverter();
    }
    
    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
                DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
                factory.setMessageConverter(consumerJackson2MessageConverter());
                return factory;
            }
    @Override
    public void configureRabbitListeners( final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}
