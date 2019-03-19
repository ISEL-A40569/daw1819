package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.repository.ProjectRepository;

import javax.validation.Valid;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/api/project/{id}")
    public Project getProject(@PathVariable long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project does not exist!")); // TODO: build error messages
    }

    @GetMapping("/api/projects")
    public Page<Project> getProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @PostMapping("/api/project")
    public ResponseEntity<Project> postProject(@Valid @RequestBody Project project) {
        return ResponseEntity.status(201)
                .body(projectRepository.save(project));     //  TODO: build response messages properly (with siren)
    }

    @PutMapping("/api/project/{id}")
    public Project patchProject(@PathVariable long id, @Valid @RequestBody Project project) {
        return projectRepository.findById(id)
                .map(p -> {
                    p.setName(project.getName());
                    p.setDescription(project.getDescription());
                    return projectRepository.save(p);
                }).orElseThrow(() -> new ResourceNotFoundException("Project does not exist!"));
    }

    @DeleteMapping("/api/project/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        return projectRepository.findById(id)
                .map(p -> {
                    projectRepository.delete(p);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Project does not exist!"));
    }
}
