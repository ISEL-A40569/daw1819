package pt.ipl.isel.leic.daw.project.model.output;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.component.builder.ActionBuilder;
import com.google.code.siren4j.component.builder.FieldBuilder;
import com.google.code.siren4j.component.builder.LinkBuilder;
import com.google.code.siren4j.component.impl.ActionImpl;
import com.google.code.siren4j.resource.BaseResource;
import pt.ipl.isel.leic.daw.project.model.Issue;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Siren4JEntity(name = "issue", uri = "/api/project/{projectId}/issue/{issueId}")
public class IssueOutputModel extends BaseResource {

    private final long id;
    private final long projectId;
    private final String description;
    private final LocalDateTime creationDate;
    private final LocalDateTime closeDate;
    private final int labelId;
    private final int stateId;
    private final int ownerId;

    public IssueOutputModel(Issue issue){

        id = issue.getId();
        projectId = issue.getProjectid();
        description = issue.getDescription();
        creationDate = issue.getCreationdate();
        closeDate = issue.getClosedate();
        labelId = issue.getLabelid();
        stateId = issue.getStateid();
        ownerId = issue.getOwnerid();


        Collection<Link> links = new ArrayList<Link>();
        links.add(LinkBuilder
                .newInstance()
                .setRelationship("comment")
                .setHref("/api/issue/{id}/comment/")
                .build());

        this.setEntityLinks(links);

        Collection<Action> actions = new ArrayList<Action>();

        Field commentId = FieldBuilder.newInstance()
                .setName("commentId")
                .setRequired(true)
                .build();

        Field issueId = FieldBuilder.newInstance()
                .setName("issueId")
                .setRequired(true)
                .build();

        Field userId = FieldBuilder.newInstance()
                .setName("userId")
                .setRequired(true)
                .build();

        Field date = FieldBuilder.newInstance()
                .setName("date")
                .setRequired(true)
                .build();

        Field body = FieldBuilder.newInstance()
                .setName("body")
                .setRequired(true)
                .build();


        //Now the action
        Action addcommentAction = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.POST)
                .setName("AddComment")
                .setHref("/api/project/{projectId}/issue/{issueId}/comment")
                .addField(commentId)
                .addField(issueId)
                .addField(userId)
                .addField(date)
                .addField(body)
                .build();

        Action updateCommentAction = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.PUT)
                .setName("UpdateComment")
                .setHref("/api/project/{projectId}/issue/{issueId}/comment/{commentId}")
                .addField(commentId)
                .addField(issueId)
                .addField(userId)
                .addField(date)
                .addField(body)
                .build();


        Action deleteCommentAction = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.DELETE)
                .setName("DeleteComment")
                .setHref("/api/project/{projectId}/issue/{issueId}/comment/{commentId}")
                .addField(commentId)
                .build();

        actions.add(addcommentAction);
        actions.add(updateCommentAction);
        actions.add(deleteCommentAction);
        this.setEntityActions(actions);

    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public int getLabelId() {
        return labelId;
    }

    public int getStateId() {
        return stateId;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
