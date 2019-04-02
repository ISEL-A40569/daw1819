package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.repository.ProjectIssueLabelRepository;
import pt.ipl.isel.leic.daw.project.repository.ProjectIssueStateRepository;
import pt.ipl.isel.leic.daw.project.repository.ProjectIssueStateTransitionRepository;
import pt.ipl.isel.leic.daw.project.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectIssueStateRepository projectIssueStateRepository;
    private final ProjectIssueLabelRepository projectIssueLabelRepository;
    private final ProjectIssueStateTransitionRepository projectIssueStateTransitionRepository;

    public ProjectService(ProjectRepository projectRepository, ProjectIssueStateRepository projectIssueStateRepository, ProjectIssueLabelRepository projectIssueLabelRepository, ProjectIssueStateTransitionRepository projectIssueStateTransitionRepository) {
        this.projectRepository = projectRepository;
        this.projectIssueStateRepository = projectIssueStateRepository;
        this.projectIssueLabelRepository = projectIssueLabelRepository;
        this.projectIssueStateTransitionRepository = projectIssueStateTransitionRepository;
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

    public void setProjectIssueState(long projectId, int issueStateId) {
        //TODO
    }

    public void getProjectIssueStates(long projectId) {
        //TODO
    }

    public void removeProjectIssueState(long projectId, int issueStateId) {
        //TODO
    }

    public void setProjectIssueLabel(long projectId, int issueLabelId) {
        //TODO
    }

    public void getProjectIssueLabels(long projectId) {
        //TODO
    }

    public void removeProjectIssueLabel(long projectId, int issueLabelId) {
        //TODO
    }

    public void setProjectIssueStateTransition(long projectId, int issueStateTransitionId) {
        //TODO
    }

    public void getProjectIssueStateTransitions(long projectId) {
        //TODO
    }

    public void removeProjectIssueStateTransition(long projectId, int issueStateTransitionId) {
        //TODO
    }
}
