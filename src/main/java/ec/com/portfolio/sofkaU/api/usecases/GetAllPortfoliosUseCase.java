package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class GetAllPortfoliosUseCase implements Supplier<Flux<PortfolioDTO>> {

    private final IPortfolioRepository iPortfolioRepository;

    private final ModelMapper mapper;

    @Override
    public Flux<PortfolioDTO> get() {
        return this.iPortfolioRepository
                .findAll()
                .switchIfEmpty(Flux.empty())
                .map(Portfolio -> mapper.map(Portfolio, PortfolioDTO.class));
    }
}
