package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.model.output.ProjectOutputModel;
import pt.ipl.isel.leic.daw.project.service.ProjectService;
import pt.ipl.isel.leic.daw.project.service.SirenConverterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project/")
public class ProjectController {

    private final ProjectService projectService;
    private final SirenConverterService<ProjectOutputModel> sirenConverterService;

    public ProjectController(ProjectService projectService, SirenConverterService<ProjectOutputModel> sirenConverterService) {
        this.projectService = projectService;
        this.sirenConverterService = sirenConverterService;
    }

    @GetMapping(value = "{id}", headers = {"Accept=application/vnd.siren+json"})
    public ResponseEntity<?> getProject(@PathVariable long id) {
        return ResponseEntity.ok( sirenConverterService.convert(new ProjectOutputModel(projectService.getProject(id))) ); // TODO: build error messages
    }

    @GetMapping
    public ResponseEntity<?> getProjects(Pageable pageable) {
        return ResponseEntity.ok(
                projectService.getProjects(pageable));
    }

    @PostMapping
    public ResponseEntity<?> postProject(@Valid @RequestBody Project project) {
        return ResponseEntity.status(201)
                .body(projectService.postProject(project));     //  TODO: build response messages properly (with siren)
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putProject(@PathVariable long id, @Valid @RequestBody Project project) {
        return ResponseEntity.ok(
                projectService.updateProject(id, project).get());


//                projectRepository.findById(id)
//                .map(p -> {
//                    p.setName(project.getName());
//                    p.setDescription(project.getDescription());
//                    return projectRepository.save(p);
//                }).orElseThrow(() -> new ResourceNotFoundException("Project does not exist!"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();

//        return projectRepository.findById(id)
//                .map(p -> {
//                    projectRepository.delete(p);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Project does not exist!"));
    }
}
