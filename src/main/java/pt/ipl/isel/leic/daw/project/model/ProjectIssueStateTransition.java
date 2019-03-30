package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trl_projectissuestatetransition")
public class ProjectIssueStateTransition {
    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectId;

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
}
