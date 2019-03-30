package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

    final private CommentService commentService;

    public CommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}
