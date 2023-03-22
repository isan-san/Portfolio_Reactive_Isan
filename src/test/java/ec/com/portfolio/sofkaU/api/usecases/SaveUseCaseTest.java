package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class SaveUseCaseTest {

    @Mock
    IPortfolioRepository repository;
    ModelMapper modelMapper;
    SavePortfolioUseCase savePortfolioUseCase;

    @BeforeEach
    void init() {
        modelMapper = new ModelMapper();
        savePortfolioUseCase = new SavePortfolioUseCase(repository, modelMapper);
    }

    @Test
    @DisplayName("save_Success")
    void getAllBooks() {

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioID("Test id");
        portfolio.setName("Test name");
        portfolio.setTheme("Test last name");

        Mockito.when(repository.save(portfolio)).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(portfolio);
                });

        Mono<PortfolioDTO> response = savePortfolioUseCase.save(modelMapper.map(portfolio, PortfolioDTO.class));

        StepVerifier.create(response)
                .expectNext(modelMapper.map(portfolio, PortfolioDTO.class))
                .expectNextCount(0)
                .verifyComplete();
        Mockito.verify(repository).save(portfolio);
    }


}