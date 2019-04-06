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
    private long projectid;

    @Id
    @NotNull
    @Column(columnDefinition = "statetransitionid")
    private long statetransitionid;

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public long getStatetransitionid() {
        return statetransitionid;
    }

    public void setStatetransitionid(long statetransitionid) {
        this.statetransitionid = statetransitionid;
    }

    public static class ProjectIssueStateTransitionIdClass implements Serializable {
        private long projectid;
        private long statetransitionid;
    }
}
