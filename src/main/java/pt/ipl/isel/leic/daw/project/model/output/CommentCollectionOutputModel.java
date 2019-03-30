package pt.ipl.isel.leic.daw.project.model.output;

import com.google.code.siren4j.annotations.Siren4JEntity;
import pt.ipl.isel.leic.daw.project.model.Comment;
import pt.ipl.isel.leic.daw.project.model.CommentCollection;

import java.util.List;



@Siren4JEntity(name="commentCollection", uri="/api/project/{projectId}/issue/{issueId}/comment")
public class CommentCollectionOutputModel {
    private final List<Comment> comments;

    public CommentCollectionOutputModel(CommentCollection commentCollection){
        this.comments = commentCollection.getComments();
    }

    public List<Comment> getComments() {
        return comments;
    }
}
