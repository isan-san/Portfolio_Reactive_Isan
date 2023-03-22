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
    /*
    @Mock
    IPortfolioRepository repository;
    ModelMapper modelMapper;
    SavePortfolioUseCase saveBookUsecase;

    @BeforeEach
    void init() {
        modelMapper = new ModelMapper();
        saveBookUsecase = new SavePortfolioUseCase(repository, modelMapper);
    }

    @Test
    @DisplayName("getAllBooks_Success")
    void getAllBooks() {

        Portfolio student = new Portfolio();
        student.setIdNumber("Test id");
        student.setName("Test name");
        student.setTheme("Test last name");

        Mockito.when(repository.save(student)).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(student);
                });

        Mono<PortfolioDTO> response = saveBookUsecase.save(modelMapper.map(student, PortfolioDTO.class));

        StepVerifier.create(response)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).save(student);
    }
*/

}