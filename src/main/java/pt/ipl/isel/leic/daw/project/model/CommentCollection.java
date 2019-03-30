package pt.ipl.isel.leic.daw.project.model;

import java.util.List;

public class CommentCollection {

    private final List<Comment> comments;

    public CommentCollection(List<Comment> comments){ this.comments = comments; }

    public List<Comment> getComments() {return comments;}

}
