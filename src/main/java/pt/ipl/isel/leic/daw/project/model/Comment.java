package pt.ipl.isel.leic.daw.project.model;

import com.google.code.siren4j.annotations.Siren4JEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Siren4JEntity(name = "comment", uri = "/api/project/{projectId}/issue/{issueId}/comment/{commentId}")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "commentid")
    private  long commentid;

    @NotNull
    @Column(columnDefinition = "issueId")
    private  long issueId;

    @NotNull
    @Column(columnDefinition = "_user")
    private  int _user;

    @NotNull
    @Column(columnDefinition = "_date")
    private  LocalDateTime _date;

    @NotNull
    @Column(columnDefinition = "body")
    private String body;

    @NotNull
    @Column(columnDefinition = "projectId")
    private long projectId;


    public void setBody(String body) {
        this.body = body;
    }

    public long getCommentid() {
        return commentid;
    }

    public long getIssueId() {
        return issueId;
    }

    public int getUserId() {
        return _user;
    }

    public LocalDateTime getDate() {
        return _date;
    }

    public String getBody() {
        return body;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
