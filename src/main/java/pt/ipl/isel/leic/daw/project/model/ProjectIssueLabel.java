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
    private long projectId;

    @Id
    @NotNull
    @Column(columnDefinition = "labelid")
    private long labelId;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    class ProjectIssueLabelIdClass implements Serializable{
        private long projectId;
        private long labelId;
    }

}
