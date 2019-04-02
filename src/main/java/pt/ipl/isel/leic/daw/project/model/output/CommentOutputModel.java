package pt.ipl.isel.leic.daw.project.model.output;

/*
    Comment:

    Get a Comment By commentId - GET /api/project/{projectId}/issue/{issueId}/comment/{commentId}

    Get all Comments - GET /api/project/{projectId}/issue/{issueId}/comment


    */

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.Field;
import com.google.code.siren4j.component.builder.ActionBuilder;
import com.google.code.siren4j.component.builder.FieldBuilder;
import com.google.code.siren4j.component.impl.ActionImpl;
import com.google.code.siren4j.meta.FieldType;
import com.google.code.siren4j.resource.BaseResource;
import pt.ipl.isel.leic.daw.project.model.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Siren4JEntity(name="comment", uri="/api/project/{projectId}/issue/{issueId}/comment/{commentId}")
public class CommentOutputModel extends BaseResource {

    final private Long id;

    final private long owner;

    final private LocalDateTime date;

    private final String body;

    public CommentOutputModel(Comment comment) {
        this.id = comment.getCommentid();
        this.owner = comment.getUserId();
        this.date = comment.getDate();
        this.body = comment.getBody();

       /* Collection<Link> links = new ArrayList<Link>();
        links.add(LinkBuilder.newInstance()
                .setRelationship("comments")
                .setHref("/api/project/{projectId}/issue/{issueId}/comment/")
                .build()
        );


        this.setEntityLinks(links);
        */

        Collection<Action> actions = new ArrayList<Action>();


        Field projectId = FieldBuilder.newInstance()
                .setName("projectId")
                .setType(FieldType.NUMBER)
                .setRequired(true)  //what is this
                .build();

        Field issueId = FieldBuilder.newInstance()
                .setName("issueId")
                .setType(FieldType.NUMBER)
                .setRequired(true)
                .build();

        Field ownerId = FieldBuilder.newInstance()
                .setName("ownerId")
                .setType(FieldType.NUMBER)
                .setRequired(true)
                .build();

        Field creationDate = FieldBuilder.newInstance()
                .setName("creationDate")
                .setType(FieldType.DATETIMELOCAL)
                .setRequired(true)
                .build();


        Field commentId = FieldBuilder.newInstance()
                .setName("commentId")
                .setType(FieldType.NUMBER)
                .setRequired(true)  //what is this
                .build();

        Field body = FieldBuilder.newInstance()
                .setName("body")
                .setType(FieldType.TEXT)
                .setRequired(true)  //what is this
                .build();

        //Create a Comment - POST /api/comment/api/project/{projectId}/issue/{issueId}/comment
        Action addComment = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.POST)
                .setName("AddComment")
                .setHref("/api/comment/api/project/{projectId}/issue/{issueId}/comment")
                .addField(projectId)
                .addField(issueId)
                .addField(creationDate)
                .addField(ownerId)
                .addField(body)
                .build();
        actions.add(addComment);

        //Update a Comment - PUT /api/project/{projectId}/issue/{issueId}/comment/{commentId}
        Action updateComment = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.PUT)
                .setName("UpdateComment")
                .setHref("/api/project/{projectId}/issue/{issueId}/comment/{commentId}")
                .addField(projectId)
                .addField(issueId)
                .addField(creationDate)
                .addField(ownerId)
                .addField(commentId)
                .addField(body)
                .build();
        actions.add(updateComment);


       // Remove a Comment - DELETE /api/project/{projectId}/issue/{issueId}/comment/{commentId}
        Action deleteComment = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.PUT)
                .setName("DeleteComment")
                .setHref("/api/project/{projectId}/issue/{issueId}/comment/{commentId}")
                .addField(projectId)
                .addField(issueId)
                .addField(commentId)
                .build();

        actions.add(deleteComment);

        this.setEntityActions(actions);
    }

    public Long getId() {
        return id;
    }

    public long getOwner(){
        return owner;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }
}
