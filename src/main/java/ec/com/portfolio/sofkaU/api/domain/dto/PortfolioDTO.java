package ec.com.portfolio.sofkaU.api.domain.dto;

import ec.com.portfolio.sofkaU.api.domain.collection.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDTO {

    @Id
    private String portfolioID;

    private String name;

    private String theme;

    private Boolean published = false;

    private List<Project> projects  = new ArrayList<>();

}
