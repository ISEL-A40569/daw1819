package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trl_projectissuelabel")
public class ProjectIssueLabel {

    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectId;

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
}
