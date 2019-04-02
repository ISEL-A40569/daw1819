package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tid_issuelabel")
public class IssueLabel {

    @Id
    @Column(name = "issuelabelid")
    private long issuelabelid;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    public long getIssuelabelid() {
        return issuelabelid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIssuelabelid(long issuelabelid) {
        this.issuelabelid = issuelabelid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
