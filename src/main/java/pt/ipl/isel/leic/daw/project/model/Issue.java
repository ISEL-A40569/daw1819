package pt.ipl.isel.leic.daw.project.model;

import com.google.code.siren4j.annotations.Siren4JEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
@Siren4JEntity(name = "issue", uri = "/api/project/{projectid}/issue/{issueid}")
public class Issue {
    @Id
    @GeneratedValue(generator = "issue_generator")
    @SequenceGenerator(
            name = "issue_generator",
            sequenceName = "issue_generator",
            initialValue = 1000
    )
    private long id;

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
//
//    public Issue(long id, long projectid, String description, LocalDateTime creationdate, int labelid, int ownerid) {
//        this.id = id;
//        this.projectid = projectid;
//        this.description = description;
//        this.creationdate = creationdate;
//        this.labelid = labelid;
//        this.ownerid = ownerid;
//        this.stateid = 1;
//    }

    public void setClosedate(LocalDateTime closedate) {
        this.closedate = closedate;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public long getId() {
        return id;
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
}
