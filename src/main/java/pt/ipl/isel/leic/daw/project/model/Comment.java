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
    private final long commentid;

    @NotNull
    @Column(columnDefinition = "issueid")
    private final long issueId;

    @NotNull
    @Column(columnDefinition = "user")
    private final int userId;

    @NotNull
    @Column(columnDefinition = "date")
    private final LocalDateTime date;

    @NotNull
    @Column(columnDefinition = "body")
    private String body;

    public Comment(long id, long issueId, int userId, LocalDateTime date, String body) {
        this.commentid = id;
        this.issueId = issueId;
        this.userId = userId;
        this.date = date;
        this.body = body;
    }

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
        return userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }
}
