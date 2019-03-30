package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "trl_projectissuestate")
@IdClass(ProjectIssueState.ProjectIssueStateIdClass.class)
public class ProjectIssueState {

    @Id
    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectId;

    @Id
    @NotNull
    @Column(columnDefinition = "stateid")
    private long stateId;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    class ProjectIssueStateIdClass implements Serializable {
        private long projectId;
        private long stateId;
    }
}
