package ec.com.portfolio.sofkaU.api.usecases;

import ec.com.portfolio.sofkaU.api.config.RabbitConfig;
import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import ec.com.portfolio.sofkaU.api.domain.collection.Project;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import ec.com.portfolio.sofkaU.api.publisher.PortfolioEvent;
import ec.com.portfolio.sofkaU.api.repository.IPortfolioRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class AddProjectUseCaseTest {
    @Mock
    IPortfolioRepository repository;
    ModelMapper modelMapper;
    AddProjectUseCase addProjectUseCase;
    RabbitTemplate rabbitTemplate;

    @BeforeEach
    void init() {
        modelMapper = new ModelMapper();
        rabbitTemplate = new RabbitTemplate();
        addProjectUseCase = new AddProjectUseCase(repository, modelMapper, rabbitTemplate);
    }

    @Test
    @DisplayName("addProject_Success")
    void getAllBooks() {

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioID("Test id");
        portfolio.setName("Test name");
        portfolio.setTheme("Test last name");
        portfolio.setPortfolioID("Test portfolio");

        Project project = new Project();
        project.setProjectID("projectID");
        project.setName("Test project");
        project.setSubject("Test subject");

        Mockito.when(repository.findById("Test id")).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(portfolio);
                });
        Mockito.when(repository.save(any(Portfolio.class))).
                thenAnswer(InvocationOnMock -> {
                    return Mono.just(InvocationOnMock.getArgument(0));
                });

        doNothing().when(rabbitTemplate).convertAndSend(anyString(),anyString(),any(Object.class));

        Mono<PortfolioDTO> response = addProjectUseCase.add("Test id", project);


        StepVerifier.create(response)
                .expectNext(modelMapper.map(portfolio.addProject(project), PortfolioDTO.class))
                .expectNextCount(0)
                .verifyComplete();

        Mockito.verify(repository).save(portfolio);
        Mockito.verify(repository).findById("Test id");
    }
}