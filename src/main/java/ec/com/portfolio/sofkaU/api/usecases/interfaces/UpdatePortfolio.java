package ec.com.portfolio.sofkaU.api.usecases.interfaces;

import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdatePortfolio {
    Mono<PortfolioDTO> update(String portfolioID, PortfolioDTO studentDTO);
}
