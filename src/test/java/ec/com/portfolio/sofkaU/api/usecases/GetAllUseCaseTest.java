package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@ExtendWith(MockitoExtension.class)
class GetAllUseCaseTest {

    @Mock
    IPortfolioRepository repository;
    ModelMapper modelMapper;
    GetAllPortfoliosUseCase getAllPortfoliosUseCase;

    @BeforeEach
    void init() {
        modelMapper = new ModelMapper();
        getAllPortfoliosUseCase = new GetAllPortfoliosUseCase(repository, modelMapper);
    }

    @Test
    @DisplayName("getAll_Success")
    void getAllPortfolios() {

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioID("Test id");
        portfolio.setName("Test name");
        portfolio.setTheme("Test last name");

        Portfolio portfolio1 = new Portfolio();
        portfolio.setPortfolioID("Test id2");
        portfolio.setName("Test name2");
        portfolio.setTheme("Test last name2");

        Mockito.when(repository.findAll()).
                thenAnswer(InvocationOnMock -> {
                    return Flux.just(portfolio, portfolio1);
                });

        Flux<PortfolioDTO> response = getAllPortfoliosUseCase.get();

        StepVerifier.create(response)
                .expectNextCount(1)
                .expectNext(modelMapper.map(portfolio1, PortfolioDTO.class))
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }

}