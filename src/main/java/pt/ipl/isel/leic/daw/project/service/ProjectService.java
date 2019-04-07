package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.model.ProjectIssueLabel;
import pt.ipl.isel.leic.daw.project.model.ProjectIssueState;
import pt.ipl.isel.leic.daw.project.model.ProjectIssueStateTransition;
import pt.ipl.isel.leic.daw.project.repository.ProjectIssueLabelRepository;
import pt.ipl.isel.leic.daw.project.repository.ProjectIssueStateRepository;
import pt.ipl.isel.leic.daw.project.repository.ProjectIssueStateTransitionRepository;
import pt.ipl.isel.leic.daw.project.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectIssueStateRepository projectIssueStateRepository;
    private final ProjectIssueLabelRepository projectIssueLabelRepository;
    private final ProjectIssueStateTransitionRepository projectIssueStateTransitionRepository;
    private final IssueService issueService;

    public ProjectService(ProjectRepository projectRepository, ProjectIssueStateRepository projectIssueStateRepository, ProjectIssueLabelRepository projectIssueLabelRepository, ProjectIssueStateTransitionRepository projectIssueStateTransitionRepository, IssueService issueService) {
        this.projectRepository = projectRepository;
        this.projectIssueStateRepository = projectIssueStateRepository;
        this.projectIssueLabelRepository = projectIssueLabelRepository;
        this.projectIssueStateTransitionRepository = projectIssueStateTransitionRepository;
        this.issueService = issueService;
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
        removeProjectIssueLabel(id);
        removeProjectIssueState(id);
        removeProjectIssueStateTransition(id);

        issueService.getProjectIssues(id)
                .forEach( issue -> issueService.deleteIssue(issue.getIssueId()));

        projectRepository.delete(project);
    }

    private void removeProjectIssueStateTransition(long id) {
        getProjectIssueStateTransitions(id).forEach(pist -> removeProjectIssueStateTransition(pist));
    }

    private void removeProjectIssueState(long id) {
        getProjectIssueStates(id).forEach(pis -> removeProjectIssueState(pis));
    }

    private void removeProjectIssueLabel(long id) {
        getProjectIssueLabels(id).forEach(pil -> removeProjectIssueLabel(pil));
    }

    public ProjectIssueState setProjectIssueState(ProjectIssueState projectIssueState) {
        return projectIssueStateRepository.save(projectIssueState);
    }

    public List<ProjectIssueState> getProjectIssueStates(long projectId) {
        return projectIssueStateRepository
                .findAll()
                .stream()
                .filter( p -> p.getProjectid() == projectId)
                .collect(Collectors.toList());
    }

    public void removeProjectIssueState(ProjectIssueState projectIssueState) {
        projectIssueStateRepository.delete(projectIssueState);
    }

    public ProjectIssueLabel setProjectIssueLabel(ProjectIssueLabel projectIssueLabel) {
        return projectIssueLabelRepository.save(projectIssueLabel);
    }

    public List<ProjectIssueLabel> getProjectIssueLabels(long projectId) {
        return projectIssueLabelRepository
                .findAll()
                .stream()
                .filter(p -> p.getProjectid() == projectId)
                .collect(Collectors.toList());
    }

    public void removeProjectIssueLabel(ProjectIssueLabel projectIssueLabel) {
        projectIssueLabelRepository.delete(projectIssueLabel);
    }

    public ProjectIssueStateTransition setProjectIssueStateTransition(ProjectIssueStateTransition projectIssueStateTransition) {
        return projectIssueStateTransitionRepository.save(projectIssueStateTransition);
    }

    public List<ProjectIssueStateTransition> getProjectIssueStateTransitions(long projectId) {
        return projectIssueStateTransitionRepository
                .findAll()
                .stream()
                .filter(p -> p.getProjectid() == projectId)
                .collect(Collectors.toList());
    }

    public void removeProjectIssueStateTransition(ProjectIssueStateTransition projectIssueStateTransition) {
        projectIssueStateTransitionRepository.delete(projectIssueStateTransition);
    }
}
