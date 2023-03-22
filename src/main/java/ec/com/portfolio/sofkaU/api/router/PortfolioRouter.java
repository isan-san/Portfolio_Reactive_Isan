package ec.com.portfolio.sofkaU.api.router;

import ec.com.portfolio.sofkaU.api.domain.collection.ProjectDTO;
import ec.com.portfolio.sofkaU.api.usecases.*;
import ec.com.portfolio.sofkaU.api.domain.dto.PortfolioDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PortfolioRouter {

    private final WebClient projectAPI;

    public PortfolioRouter() {
        this.projectAPI = WebClient.create("http://localhost:8080/project");
    }


    @Bean
    public RouterFunction<ServerResponse> getAllPortfolios(GetAllPortfoliosUseCase getAllPortfoliosUsecase) {
        return route(GET("/portfolio"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllPortfoliosUsecase.get(), PortfolioDTO.class))
                        .onErrorResume(throwable -> ServerResponse.noContent().build()));
    }

    @Bean
    public RouterFunction<ServerResponse> getPortfolioById(GetPortfolioByIdUseCase getPortfolioByIdUsecase) {
        return route(GET("/portfolio/{id}"),
                request -> getPortfolioByIdUsecase.apply(request.pathVariable("id"))
                        .flatMap(portfolioDTO -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(portfolioDTO))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }

    @Bean
    public RouterFunction<ServerResponse> savePortfolio(SavePortfolioUseCase savePortfolioUsecase) {
        return route(POST("/portfolio").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PortfolioDTO.class)
                        .flatMap(portfolioDTO -> savePortfolioUsecase.save(portfolioDTO)
                                .flatMap(result -> ServerResponse.status(201)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))

                                .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_ACCEPTABLE).build())));
    }

    @Bean
    public RouterFunction<ServerResponse> patchPortfolio(UpdatePortfolioUseCase updatePortfolioUsecase) {
        return route(PUT("/portfolio/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PortfolioDTO.class)
                        .flatMap(portfolioDTO -> updatePortfolioUsecase.update(request.pathVariable("id"), portfolioDTO)
                                .flatMap(result -> ServerResponse.status(200)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                                .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_ACCEPTABLE).build())));
    }

    @Bean
    public RouterFunction<ServerResponse> deletePortfolio(DeleteUsecase deleteUsecase) {
        return route(DELETE("/portfolio/{id}"),
                request -> deleteUsecase.apply(request.pathVariable("id"))
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue("Deleted Successfully"))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }

    @Bean
    public RouterFunction<ServerResponse> addProject(AddProjectUseCase addProjectUseCase) {
        return route(PATCH("/portfolio/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        request.bodyToMono(ProjectDTO.class)
                                .flatMap(projectDTO -> projectAPI.get().uri("/" + projectDTO.getProjectID())
                                .retrieve()
                                .bodyToMono(ProjectDTO.class)
                                .flatMap(project ->
                                        addProjectUseCase.add(request.pathVariable("id"), project)
                                                .flatMap(result -> ServerResponse.status(200)
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .bodyValue(result))
                                                .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_ACCEPTABLE).build()))));
    }
}
