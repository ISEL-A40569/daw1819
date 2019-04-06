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
    private long projectid;

    @Id
    @NotNull
    @Column(columnDefinition = "stateid")
    private long stateid;

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public long getStateid() {
        return stateid;
    }

    public void setStateid(long stateid) {
        this.stateid = stateid;
    }

    public static class ProjectIssueStateIdClass implements Serializable {
        private long projectid;
        private long stateid;
    }
}
