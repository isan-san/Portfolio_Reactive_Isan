package ec.com.portfolio.sofkaU.api.usecases.interfaces;

import ec.com.portfolio.sofkaU.api.domain.collection.Project;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IAddProject {
    Mono<PortfolioDTO> add(String portfolioID, Project project);
}
