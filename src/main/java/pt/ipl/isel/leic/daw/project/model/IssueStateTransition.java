package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tid_issuestatetransition")
public class IssueStateTransition {
    @Id
    @Column(name = "issuestatetransitionid")
    private long issuestatetransitionid;

    @NotNull
    @Column(name = "current")
    private String current;

    @NotNull
    @Column(name = "next")
    private String next;

    public long getIssuestatetransitionid() {
        return issuestatetransitionid;
    }

    public void setIssuestatetransitionid(long issuestatetransitionid) {
        this.issuestatetransitionid = issuestatetransitionid;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
