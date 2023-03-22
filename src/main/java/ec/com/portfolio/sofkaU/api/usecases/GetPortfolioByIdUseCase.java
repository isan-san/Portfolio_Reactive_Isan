package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class GetPortfolioByIdUseCase implements Function<String, Mono<PortfolioDTO>> {
    private final IPortfolioRepository iPortfolioRepository;

    private final ModelMapper mapper;
    @Override
    public Mono<PortfolioDTO> apply(String id) {
        return this.iPortfolioRepository
                .findById(id)
                .switchIfEmpty(Mono.empty())
                .map(Portfolio-> mapper.map(Portfolio, PortfolioDTO.class));
    }
}
