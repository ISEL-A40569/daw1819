package pt.ipl.isel.leic.daw.project.model;

import com.google.code.siren4j.annotations.Siren4JEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
@Siren4JEntity(name = "issue", uri = "/api/project/{projectId}/issue/{issueId}")
public class Issue {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "issueid")
    long issueid;

    @NotNull
    @Column(columnDefinition = "projectid")
    private long projectid;

    @NotNull
    @Column(columnDefinition = "description")
    private String description;

    @NotNull
    @Column(columnDefinition = "creationdate")
    private LocalDateTime creationdate;

    @Column(columnDefinition = "closedate")
    private LocalDateTime closedate;

    @NotNull
    @Column(columnDefinition = "labelid")
    private int labelid;

    @NotNull
    @Column(columnDefinition = "stateid")
    private int stateid;

    @NotNull
    @Column(columnDefinition = "ownerid")
    private int ownerid;

    public void setClosedate(LocalDateTime closedate) {
        this.closedate = closedate;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public long getIssueId() {
        return issueid;
    }

    public long getProjectid() {
        return projectid;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationdate() {
        return creationdate;
    }

    public LocalDateTime getClosedate() {
        return closedate;
    }

    public int getLabelid() {
        return labelid;
    }

    public int getStateid() {
        return stateid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }
}
