package ec.com.portfolio.sofkaU.api.domain.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    private String projectID;

    private String name;

    private String subject;

    private Boolean isPublished = false;
}
