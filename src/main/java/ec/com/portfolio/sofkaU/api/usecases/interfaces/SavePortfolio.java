package ec.com.portfolio.sofkaU.api.usecases.interfaces;

import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SavePortfolio {
    Mono<PortfolioDTO> save(PortfolioDTO studentDTO);
}
