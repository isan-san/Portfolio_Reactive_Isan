package ec.com.portfolio.sofkaU.api.domain.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    @Id
    private String projectID;

    private String name;

    private String subject;

    private Boolean isPublished = false;
}
