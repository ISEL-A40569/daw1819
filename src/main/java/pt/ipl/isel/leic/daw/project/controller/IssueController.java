package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.leic.daw.project.model.Issue;
import pt.ipl.isel.leic.daw.project.model.IssueCollection;
import pt.ipl.isel.leic.daw.project.model.output.IssueCollectionOutputModel;
import pt.ipl.isel.leic.daw.project.model.output.IssueOutputModel;
import pt.ipl.isel.leic.daw.project.service.IssueService;
import pt.ipl.isel.leic.daw.project.service.SirenConverterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project/{projectid}/issue/")
public class IssueController {

    private final IssueService issueService;
    private final SirenConverterService<IssueOutputModel> sirenConverterServiceIssueOutputModel;
    private final SirenConverterService<IssueCollectionOutputModel> sirenConverterServiceIssueCollectionOutputModel;

    public IssueController(IssueService issueService, SirenConverterService<IssueOutputModel> sirenConverterServiceIssueOutputModel, SirenConverterService<IssueCollectionOutputModel> sirenConverterServiceIssueCollectionOutputModel) {
        this.issueService = issueService;
        this.sirenConverterServiceIssueOutputModel = sirenConverterServiceIssueOutputModel;
        this.sirenConverterServiceIssueCollectionOutputModel = sirenConverterServiceIssueCollectionOutputModel;
    }

    @GetMapping(value = "{issueId}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getIssue(@PathVariable long issueId) {
        return ResponseEntity.ok( sirenConverterServiceIssueOutputModel.convert(new IssueOutputModel(issueService.getIssue(issueId))) );
    }

    @GetMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getIssues() {
        return ResponseEntity.ok(
                sirenConverterServiceIssueCollectionOutputModel.convert(
                        new IssueCollectionOutputModel(
                                new IssueCollection(issueService.getIssue()))));
    }

    @PostMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> postIssue(@Valid @RequestBody Issue issue, @PathVariable long projectid) {
        IssueOutputModel issueOutputModel = new IssueOutputModel(issueService.postIssue(issue, projectid));

        return ResponseEntity.status(201)
                .header("Location", "/api/project/" + issueOutputModel.getProjectId() + "/issue/" + issueOutputModel.getIssueId())
                .body(sirenConverterServiceIssueOutputModel.convert(issueOutputModel));
    }


    @PutMapping(value = "{issueId}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> putIssue(@PathVariable long issueId, @Valid @RequestBody Issue issue) {
        return ResponseEntity.ok(
                sirenConverterServiceIssueOutputModel.convert(new IssueOutputModel(issueService.updateIssue(issueId, issue))));

    }

    @DeleteMapping("{issueId}")
    public ResponseEntity<?> deleteIssue(@PathVariable long id) {
        issueService.deleteIssue(id);
        return ResponseEntity.ok().build();

    }

}
