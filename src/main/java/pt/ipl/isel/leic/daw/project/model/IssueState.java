package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tid_issuestate")
public class IssueState {

    @Id
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "statename")
    private String stateName;

    @NotNull
    @Column(name = "description")
    private String stateDescription;

    public long getId() {
        return id;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }
}
