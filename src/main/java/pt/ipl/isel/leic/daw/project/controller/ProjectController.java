package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.model.ProjectCollection;
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
    private final SirenConverterService<ProjectCollectionOutputModel> sirenConverterServiceProjectCollectionOutputModel;

    public ProjectController(ProjectService projectService, SirenConverterService<ProjectOutputModel> sirenConverterServiceProjectOutputModel, SirenConverterService<ProjectCollectionOutputModel> sirenConverterServiceProjectCollectionOutputModel) {
        this.projectService = projectService;
        this.sirenConverterServiceProjectOutputModel = sirenConverterServiceProjectOutputModel;
        this.sirenConverterServiceProjectCollectionOutputModel = sirenConverterServiceProjectCollectionOutputModel;
    }

    @GetMapping(value = "{id}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getProject(@PathVariable long id) {
        return ResponseEntity.ok( sirenConverterServiceProjectOutputModel.convert(new ProjectOutputModel(projectService.getProject(id))) );
    }

    @GetMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getProjects() {
        return ResponseEntity.ok(
                sirenConverterServiceProjectCollectionOutputModel.convert(
                        new ProjectCollectionOutputModel(
                                new ProjectCollection(projectService.getProjects()))));
    }

    @PostMapping(headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> postProject(@Valid @RequestBody Project project) {
        ProjectOutputModel projectOutputModel = new ProjectOutputModel(projectService.postProject(project));

        return ResponseEntity.status(201)
                .header("Location", "/api/project/" + projectOutputModel.getId())
                .body(sirenConverterServiceProjectOutputModel.convert(projectOutputModel));
    }

    @PutMapping(value = "{id}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> putProject(@PathVariable long id, @Valid @RequestBody Project project) {
        return ResponseEntity.ok(
                sirenConverterServiceProjectOutputModel.convert(new ProjectOutputModel(projectService.updateProject(id, project))));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();

    }
}
