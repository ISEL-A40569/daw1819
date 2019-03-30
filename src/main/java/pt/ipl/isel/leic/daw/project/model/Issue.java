package pt.ipl.isel.leic.daw.project.model;

import com.google.code.siren4j.annotations.Siren4JEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
@Siren4JEntity(name = "issue", uri = "/api/issue/{id}")
public class Issue {
    @Id
    @GeneratedValue(generator = "issue_generator")
    @SequenceGenerator(
            name = "issue_generator",
            sequenceName = "issue_generator",
            initialValue = 1000
    )
    private final long id;

    @NotNull
    @Column(columnDefinition = "projectId")
    private final long projectId;

    @NotNull
    @Column(columnDefinition = "description")
    private final String description;

    @NotNull
    @Column(columnDefinition = "creationdate")
    private final LocalDateTime creationDate;

    @Column(columnDefinition = "closedate")
    private LocalDateTime closeDate;

    @NotNull
    @Column(columnDefinition = "labelid")
    private final int labelId;

    @NotNull
    @Column(columnDefinition = "stateid")
    private int stateId;

    @NotNull
    @Column(columnDefinition = "ownerid")
    private final int ownerId;

    public Issue(long id, long projectId, String description, LocalDateTime creationDate, int labelId, int ownerId) {
        this.id = id;
        this.projectId = projectId;
        this.description = description;
        this.creationDate = creationDate;
        this.labelId = labelId;
        this.ownerId = ownerId;
        this.stateId = 1;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public int getLabelId() {
        return labelId;
    }

    public int getStateId() {
        return stateId;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
