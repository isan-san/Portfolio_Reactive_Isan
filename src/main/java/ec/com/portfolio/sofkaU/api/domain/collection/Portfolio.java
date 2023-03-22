package ec.com.portfolio.sofkaU.api.domain.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PortfolioDB")
public class Portfolio {

    @Id
    private String portfolioID = UUID.randomUUID().toString().substring(0, 10);

    private String name;

    private String theme;

    private Boolean published = false;

    private List<Project> projects = new ArrayList<>();

    public Portfolio addProject(Project project){
        this.projects.add(project);
        return this;
    }
}
