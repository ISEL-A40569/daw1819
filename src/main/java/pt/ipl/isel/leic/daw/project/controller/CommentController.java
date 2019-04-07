package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.leic.daw.project.model.Comment;
import pt.ipl.isel.leic.daw.project.model.CommentCollection;
import pt.ipl.isel.leic.daw.project.model.output.CommentCollectionOutputModel;
import pt.ipl.isel.leic.daw.project.model.output.CommentOutputModel;
import pt.ipl.isel.leic.daw.project.service.CommentService;
import pt.ipl.isel.leic.daw.project.service.SirenConverterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project/{projectId}/issue/{issueId}/comment/")
public class CommentController {

    private final CommentService commentService;
    private final SirenConverterService<CommentOutputModel> commentOutputModelSirenConverterService;
//    private final SirenConverterService<CommentCollectionOutputModel> commentCollectionOutputModelSirenConverterService;

    public CommentController(CommentService commentService, SirenConverterService<CommentOutputModel> commentOutputModelSirenConverterService, SirenConverterService<CommentCollectionOutputModel> commentCollectionOutputModelSirenConverterService) {
        this.commentService = commentService;
        this.commentOutputModelSirenConverterService = commentOutputModelSirenConverterService;
//        this.commentCollectionOutputModelSirenConverterService = commentCollectionOutputModelSirenConverterService;
    }

    @GetMapping(value ="{commentId}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getCommentById(@PathVariable long commentId){ //são necessarias as variaveis projectId e issueId aqui?
        return ResponseEntity.ok(
                commentOutputModelSirenConverterService.convert( new CommentOutputModel(commentService.getCommentById(commentId)))
        );
    }

    @GetMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getComments(@PathVariable long issueId) {
        return ResponseEntity.ok(
//                commentCollectionOutputModelSirenConverterService.convert(
                        new CommentCollectionOutputModel(
                                new CommentCollection(commentService.getIssueComments(issueId))))
//        )
        ;
    }

    @PostMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> postComment(@PathVariable long projectId, @PathVariable long issueId, @Valid @RequestBody Comment comment){
        comment.setIssueId(issueId);
        CommentOutputModel commentOutputModel = new CommentOutputModel(commentService.postComment(comment));

        return ResponseEntity.status(201)
                .header("Location", "/api/comment/api/project/"+projectId+"/issue/"+issueId+"/comment/"+ commentOutputModel.getCommentId())
                .body(commentOutputModelSirenConverterService.convert(commentOutputModel));
    }

    @PutMapping(value ="{commentId}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> putComment(@PathVariable long commentId, @Valid @RequestBody Comment comment){
        return ResponseEntity.ok(
                commentOutputModelSirenConverterService.convert(new CommentOutputModel(commentService.updateComment(comment, commentId))));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable long commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

}
