package ec.com.portfolio.sofkaU.api.publisher;

import ec.com.portfolio.sofkaU.api.domain.collection.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PortfolioEvent {
    private ProjectDTO projectDTO;
    private final String eventType = "Append.Project";
}
