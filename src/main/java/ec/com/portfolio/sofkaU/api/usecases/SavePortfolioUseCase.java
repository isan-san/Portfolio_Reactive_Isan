package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import ec.com.portfolio.sofkaU.api.usecases.interfaces.SavePortfolio;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SavePortfolioUseCase implements SavePortfolio {

    private final IPortfolioRepository iPortfolioRepository;

    private final ModelMapper mapper;
    @Override
    public Mono<PortfolioDTO> save(PortfolioDTO portfolioDTO) {
        return this.iPortfolioRepository.save(mapper.map(portfolioDTO, Portfolio.class))
                .switchIfEmpty(Mono.empty())
                .map(portfolio -> mapper.map(portfolio, PortfolioDTO.class));
    }

}
