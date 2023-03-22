package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class DeleteUsecase implements Function<String, Mono<String>> {

    private final IPortfolioRepository iPortfolioRepository;

    @Override
    public Mono<String> apply(String id) {
        return this.iPortfolioRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Portfolio not found")))
                .flatMap(portfolio -> iPortfolioRepository.delete(portfolio).thenReturn(id))
                .onErrorResume(Mono::error);
    }

}
