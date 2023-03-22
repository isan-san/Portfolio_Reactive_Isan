package ec.com.portfolio.sofkaU.api.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PortfolioPublisher {
    private final RabbitTemplate rabbitTemplate;
    //private final DirectExchange exchange;
    private final ObjectMapper objectMapper;


    public PortfolioPublisher(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
        //this.exchange = exchange;
    }

    public void publish(PortfolioDTO bookDTO, String id) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(new PortfolioEvent(id));
        rabbitTemplate.convertAndSend("books-exchange-events", "events.book.routing.key", message);

    }


    public void publishError(Throwable errorEvent){
    }
}
