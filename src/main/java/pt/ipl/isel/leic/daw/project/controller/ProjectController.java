package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.leic.daw.project.model.*;
import pt.ipl.isel.leic.daw.project.model.output.ProjectCollectionOutputModel;
import pt.ipl.isel.leic.daw.project.model.output.ProjectOutputModel;
import pt.ipl.isel.leic.daw.project.service.ProjectService;
import pt.ipl.isel.leic.daw.project.service.SirenConverterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project/")
public class ProjectController {
    private final ProjectService projectService;
    private final SirenConverterService<ProjectOutputModel> sirenConverterServiceProjectOutputModel;
//    private final SirenConverterService<ProjectCollectionOutputModel> sirenConverterServiceProjectCollectionOutputModel;

    public ProjectController(ProjectService projectService, SirenConverterService<ProjectOutputModel> sirenConverterServiceProjectOutputModel, SirenConverterService<ProjectCollectionOutputModel> sirenConverterServiceProjectCollectionOutputModel) {
        this.projectService = projectService;
        this.sirenConverterServiceProjectOutputModel = sirenConverterServiceProjectOutputModel;
//        this.sirenConverterServiceProjectCollectionOutputModel = sirenConverterServiceProjectCollectionOutputModel;
    }

    @GetMapping(value = "{projectId}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getProject(@PathVariable long projectId) {
        return ResponseEntity.ok( sirenConverterServiceProjectOutputModel.convert(new ProjectOutputModel(projectService.getProject(projectId))) );
    }

    @GetMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getProjects() {
        return ResponseEntity.ok(
//                sirenConverterServiceProjectCollectionOutputModel.convert(
                        new ProjectCollectionOutputModel(
                                new ProjectCollection(projectService.getProjects())))
//        )
                ;
    }

    @PostMapping(headers = {"Content-Type=application/json", "Accept=application/vnd.siren+json"})
    public ResponseEntity<?> postProject(@Valid @RequestBody Project project) {
        ProjectOutputModel projectOutputModel = new ProjectOutputModel(projectService.postProject(project));

        return ResponseEntity.status(201)
                .header("Location", "/api/project/" + projectOutputModel.getId())
                .body(sirenConverterServiceProjectOutputModel.convert(projectOutputModel));
    }

    @PutMapping(value = "{projectId}", headers = {"Content-Type=application/json", "Accept=application/vnd.siren+json"})
    public ResponseEntity<?> putProject(@PathVariable long projectId, @Valid @RequestBody Project project) {
        return ResponseEntity.ok(
                sirenConverterServiceProjectOutputModel.convert(new ProjectOutputModel(projectService.updateProject(projectId, project))));
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{projectId}/issueState")
    public ResponseEntity<?> postProjectIssueState(@PathVariable long projectId, @Valid @RequestBody ProjectIssueState projectIssueState) {
        projectIssueState.setProjectid(projectId);
        return ResponseEntity.status(201).body(projectService.setProjectIssueState(projectIssueState));
    }

    @PostMapping("{projectId}/issueStateTransition")
    public ResponseEntity<?> postProjectIssueStateTransition(@PathVariable long projectId, @Valid @RequestBody ProjectIssueStateTransition projectIssueStateTransition) {
        projectIssueStateTransition.setProjectid(projectId);
        return ResponseEntity.status(201).body(projectService.setProjectIssueStateTransition(projectIssueStateTransition));
    }

    @PostMapping("{projectId}/issueLabel")
    public ResponseEntity<?> postProjectIssueLabel(@PathVariable long projectId, @Valid @RequestBody ProjectIssueLabel projectIssueLabel) {
        projectIssueLabel.setProjectid(projectId);
        return ResponseEntity.status(201).body(projectService.setProjectIssueLabel(projectIssueLabel));
    }

    @GetMapping("{projectId}/issueState")
    public ResponseEntity<?> getProjectIssueStates(@PathVariable long projectId) {
        return ResponseEntity.ok(projectService.getProjectIssueStates(projectId));
    }

    @GetMapping("{projectId}/issueStateTransition")
    public ResponseEntity<?> getProjectIssueStateTransitions(@PathVariable long projectId) {
        return ResponseEntity.ok(projectService.getProjectIssueStateTransitions(projectId));
    }

    @GetMapping("{projectId}/issueLabel")
    public ResponseEntity<?> getProjectIssueStateLabel(@PathVariable long projectId) {
        return ResponseEntity.ok(projectService.getProjectIssueLabels(projectId));
    }

    @DeleteMapping("{projectId}/issueState")
    public ResponseEntity<?> removeProjectIssueState(@PathVariable long projectId, @Valid @RequestBody ProjectIssueState projectIssueState) {
        projectIssueState.setProjectid(projectId);
        projectService.removeProjectIssueState(projectIssueState);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{projectId}/issueStateTransition")
    public ResponseEntity<?> removeProjectIssueStateTransition(@PathVariable long projectId, @Valid @RequestBody ProjectIssueStateTransition projectIssueStateTransition) {
        projectIssueStateTransition.setProjectid(projectId);
        projectService.removeProjectIssueStateTransition(projectIssueStateTransition);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{projectId}/issueLabel")
    public ResponseEntity<?> removeProjectIssueLabel(@PathVariable long projectId, @Valid @RequestBody ProjectIssueLabel projectIssueLabel) {
        projectIssueLabel.setProjectid(projectId);
        projectService.removeProjectIssueLabel(projectIssueLabel);
        return ResponseEntity.ok().build();
    }
}
