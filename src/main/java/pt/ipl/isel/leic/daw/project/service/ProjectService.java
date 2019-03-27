package pt.ipl.isel.leic.daw.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.repository.ProjectRepository;

import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Project> getProject(long id) {
        return projectRepository.findById(id);
    }

    public Page<Project> getProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public Project postProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> updateProject(long id, Project project) {
        return projectRepository.findById(id)
                .map(p -> {
                    p.setName(project.getName());
                    p.setDescription(project.getDescription());
                    return projectRepository.save(p);
                });
    }

    public void deleteProject(long id) {
        Project project = projectRepository.findById(id).get();
        projectRepository.delete(project);
    }
}
