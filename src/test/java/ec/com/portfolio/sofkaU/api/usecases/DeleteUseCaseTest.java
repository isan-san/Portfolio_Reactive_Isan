package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class DeleteUseCaseTest {

    @Mock
    IPortfolioRepository repository;
    DeleteUsecase deleteUsecase;

    @BeforeEach
    void init() {
        deleteUsecase = new DeleteUsecase(repository);
    }

    @Test
    @DisplayName("delete_Success")
    void getAllPortfolio() {

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioID("Test id");
        portfolio.setName("Test name");
        portfolio.setTheme("Test last name");
        portfolio.setPortfolioID("Test portfolio");

        Mockito.when(repository.findById("Test portfolio")).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(portfolio);
                });
        Mockito.when(repository.delete(portfolio)).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(Void.TYPE);
                });

        Mono<String> response = deleteUsecase.apply("Test portfolio");

        StepVerifier.create(response)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).delete(portfolio);
        Mockito.verify(repository).findById("Test portfolio");
    }

}