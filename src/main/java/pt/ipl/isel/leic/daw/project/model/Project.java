package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(generator = "project_generator")
    @SequenceGenerator(
            name = "project_generator",
            sequenceName = "project_generator",
            initialValue = 1000
    )
    private Long id;

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
        return id;
    }
}
