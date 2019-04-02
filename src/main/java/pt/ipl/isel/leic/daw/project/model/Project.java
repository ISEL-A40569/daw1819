package pt.ipl.isel.leic.daw.project.model;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "project")
@Siren4JEntity(name = "project", uri = "/api/project/{projectId}"
)
public class Project extends BaseResource {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "projectid")
    private Long projectid;

    @NotNull
    @Column(columnDefinition = "name")
    private String name;

    @NotNull
    @Column(columnDefinition = "description")
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return this.projectid;
    }
}
