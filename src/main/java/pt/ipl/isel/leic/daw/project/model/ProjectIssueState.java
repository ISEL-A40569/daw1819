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
    @Column(columnDefinition = "issuestateid")
    private long issuestateid;

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public long getIssuestateid() {
        return issuestateid;
    }

    public void setIssuestateid(long issuestateid) {
        this.issuestateid = issuestateid;
    }

    public static class ProjectIssueStateIdClass implements Serializable {
        private long projectid;
        private long issuestateid;
    }
}
