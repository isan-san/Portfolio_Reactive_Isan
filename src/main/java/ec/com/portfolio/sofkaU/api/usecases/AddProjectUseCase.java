package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.config.RabbitConfig;
import ec.com.portfolio.sofkaU.api.domain.collection.Project;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import ec.com.portfolio.sofkaU.api.publisher.PortfolioEvent;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import ec.com.portfolio.sofkaU.api.usecases.interfaces.IAddProject;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AddProjectUseCase implements IAddProject {

    private final IPortfolioRepository iPortfolioRepository;
    private final ModelMapper mapper;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public Mono<PortfolioDTO> add(String portfolioId, Project project) {
        return this.iPortfolioRepository.findById(portfolioId).switchIfEmpty(Mono.empty()).flatMap(portfolio -> {
            if (project.getIsPublished()) {
                return Mono.empty();
            } else {
                project.setIsPublished(true);
                rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, new PortfolioEvent(project));
                return iPortfolioRepository.save(portfolio.addProject(project)).map(updatedPortfolio -> mapper.map(updatedPortfolio, PortfolioDTO.class));
            }
        }).onErrorResume(Mono::error);
    }

}
