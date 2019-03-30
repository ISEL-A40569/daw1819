package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trl_projectissuestate")
public class ProjectIssueState {

    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectId;

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
}
