package pt.ipl.isel.leic.daw.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tid_issuestatetransition")
public class StateTransition {

    @Id
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "current")
    private int current;

    @Id
    @Column(name = "next")
    private int next;

    public StateTransition(int id, int current, int next) {
        this.id = id;
        this.current = current;
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
