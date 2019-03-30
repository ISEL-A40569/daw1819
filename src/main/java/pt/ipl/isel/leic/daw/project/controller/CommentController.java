package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.leic.daw.project.model.output.CommentCollectionOutputModel;
import pt.ipl.isel.leic.daw.project.model.output.CommentOutputModel;
import pt.ipl.isel.leic.daw.project.service.CommentService;
import pt.ipl.isel.leic.daw.project.service.SirenConverterService;

@RestController
@RequestMapping("/api/project/{projectId}/issue/{issueId}/comment/")
public class CommentController {

    private final CommentService commentService;
    private final SirenConverterService<CommentOutputModel> commentOutputModelSirenConverterService;
    private final SirenConverterService<CommentCollectionOutputModel> commentCollectionOutputModelSirenConverterService;

    public CommentController(CommentService commentService, SirenConverterService<CommentOutputModel> commentOutputModelSirenConverterService, SirenConverterService<CommentCollectionOutputModel> commentCollectionOutputModelSirenConverterService) {
        this.commentService = commentService;
        this.commentOutputModelSirenConverterService = commentOutputModelSirenConverterService;
        this.commentCollectionOutputModelSirenConverterService = commentCollectionOutputModelSirenConverterService;
    }


}
