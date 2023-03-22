package ec.com.portfolio.sofkaU.api.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PortfolioEvent {
    private String projectID;
    private final String eventType = "Append.Project";
}
