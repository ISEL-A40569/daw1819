package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project getProject(long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project does not exits."));
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project postProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(long id, Project project) {
        return projectRepository.findById(id)
                .map(p -> {
                    p.setName(project.getName());
                    p.setDescription(project.getDescription());
                    return projectRepository.save(p);
                }).orElseThrow(() -> new ResourceNotFoundException("Project does not exits."));
    }

    public void deleteProject(long id) {
        Project project = projectRepository.findById(id).get();
        projectRepository.delete(project);
    }


}
