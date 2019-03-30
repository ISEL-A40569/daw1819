package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "trl_projectissuestatetransition")
@IdClass(ProjectIssueStateTransition.ProjectIssueStateTransitionIdClass.class)
public class ProjectIssueStateTransition {
    @Id
    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectId;

    @Id
    @NotNull
    @Column(columnDefinition = "statetransitionid")
    private long stateTransitionId;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getStateTransitionId() {
        return stateTransitionId;
    }

    public void setStateTransitionId(long stateTransitionId) {
        this.stateTransitionId = stateTransitionId;
    }

    class ProjectIssueStateTransitionIdClass implements Serializable {
        private long projectId;
        private long stateTransitionId;
    }
}
