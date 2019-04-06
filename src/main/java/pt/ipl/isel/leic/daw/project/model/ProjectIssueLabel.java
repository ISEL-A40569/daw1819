package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "trl_projectissuelabel")
@IdClass(ProjectIssueLabel.ProjectIssueLabelIdClass.class)
public class ProjectIssueLabel {

    @Id
    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectid;

    @Id
    @NotNull
    @Column(columnDefinition = "labelid")
    private long labelid;

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public long getLabelid() {
        return labelid;
    }

    public void setLabelid(long labelid) {
        this.labelid = labelid;
    }

    public static class ProjectIssueLabelIdClass implements Serializable {
        private long projectid;
        private long labelid;

    }

}
