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
/*
    @Mock
    IPortfolioRepository repository;
    DeleteUsecase deleteUsecase;

    @BeforeEach
    void init() {
        deleteUsecase = new DeleteUsecase(repository);
    }

    @Test
    @DisplayName("getAllStudents_Success")
    void getAllStudents() {

        Portfolio student = new Portfolio();
        student.setIdNumber("Test id");
        student.setName("Test name");
        student.setTheme("Test last name");
        student.setPortfolioID("Test student");

        Mockito.when(repository.findById("Test student")).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(student);
                });
        Mockito.when(repository.delete(student)).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(Void.TYPE);
                });

        Mono<String> response = deleteUsecase.apply("Test student");

        StepVerifier.create(response)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).delete(student);
        Mockito.verify(repository).findById("Test student");
    }
*/
}