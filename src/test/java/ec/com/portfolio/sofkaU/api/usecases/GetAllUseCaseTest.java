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
    /*
    @Mock
    IPortfolioRepository repository;
    ModelMapper modelMapper;
    GetAllPortfoliosUseCase getAllStudentsUsecase;

    @BeforeEach
    void init() {
        modelMapper = new ModelMapper();
        getAllStudentsUsecase = new GetAllPortfoliosUseCase(repository, modelMapper);
    }

    @Test
    @DisplayName("getAllstudents_Success")
    void getAllstudents() {

        Portfolio student = new Portfolio();
        student.setIdNumber("Test id");
        student.setName("Test name");
        student.setTheme("Test last name");

        Portfolio student2 = new Portfolio();
        student.setIdNumber("Test id2");
        student.setName("Test name2");
        student.setTheme("Test last name2");

        Mockito.when(repository.findAll()).
                thenAnswer(InvocationOnMock -> {
                    return Flux.just(student, student2);
                });

        Flux<PortfolioDTO> response = getAllStudentsUsecase.get();

        StepVerifier.create(response)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(repository).findAll();
    }
*/
}