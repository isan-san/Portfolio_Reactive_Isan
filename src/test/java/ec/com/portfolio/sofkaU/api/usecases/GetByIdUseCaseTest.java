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
class GetByIdUseCaseTest {
/*
    @Mock
    IPortfolioRepository repository;
    ModelMapper modelMapper;
    GetPortfolioByIdUseCase getStudentByIdUsecase;

    @BeforeEach
    void init() {
        modelMapper = new ModelMapper();
        getStudentByIdUsecase = new GetPortfolioByIdUseCase(repository, modelMapper);
    }

    @Test
    @DisplayName("getAllBooks_Success")
    void getAllBooks() {

        Portfolio student = new Portfolio();
        student.setIdNumber("Test id");
        student.setName("Test name");
        student.setTheme("Test last name");

        Mockito.when(repository.findById("1")).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(student);
                });

        Mono<PortfolioDTO> response = getStudentByIdUsecase.apply("1");

        StepVerifier.create(response)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).findById("1");
    }
*/
}