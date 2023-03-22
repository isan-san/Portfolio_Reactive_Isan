package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import ec.com.portfolio.sofkaU.api.usecases.interfaces.UpdatePortfolio;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UpdatePortfolioUseCase implements UpdatePortfolio {

    private final IPortfolioRepository iPortfolioRepository;
    private final ModelMapper mapper;

    @Override
    public Mono<PortfolioDTO> update(String portfolioId, PortfolioDTO portfolioDTO) {
        return this.iPortfolioRepository.findById(portfolioId)
                .switchIfEmpty(Mono.empty())
                .flatMap(portfolio -> {
                    portfolioDTO.setPortfolioID(portfolio.getPortfolioID());
                    return iPortfolioRepository.save(mapper.map(portfolioDTO, Portfolio.class));
                })
                .switchIfEmpty(Mono.empty())
                .map(book -> mapper.map(book, PortfolioDTO.class))
                .map(savedBook -> mapper.map(savedBook, PortfolioDTO.class))
                .onErrorResume(Mono::error);
    }

}
