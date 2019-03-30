package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Comment;
import pt.ipl.isel.leic.daw.project.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    /*
    Comment:

    Get a Comment By commentId - GET /api/project/{projectId}/issue/{issueId}/comment/{commentId}

    Get all Comments - GET /api/project/{projectId}/issue/{issueId}/comment

    Create a Comment - POST /api/comment/api/project/{projectId}/issue/{issueId}/comment

    Update a Comment - PUT /api/project/{projectId}/issue/{issueId}/comment/{commentId}

    Remove a Comment - DELETE /api/project/{projectId}/issue/{issueId}/comment/{commentId}
    */

    final private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentById(long id){
        return commentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comment doesn't exist."));
    }

    public List<Comment> getComments(){ return commentRepository.findAll();}

    public Comment postComment(Comment comment) { return commentRepository.save(comment);}

    public Comment updateComment(Comment comment, long id){
        return commentRepository.findById(id)
        .map(c -> {
            c.setBody(comment.getBody());
            //EditeDate?
            return commentRepository.save(c);
        }).orElseThrow(() -> new ResourceNotFoundException("Comment doesn't exist"));
    }

    public void deleteComment(long id){
        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);

    }

}
