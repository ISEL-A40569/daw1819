package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Issue;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.repository.IssueRepository;

import java.util.List;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {

        this.issueRepository = issueRepository;
    }

    public Issue getProject(long id) {
        return issueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public List<Issue> getProjects() {
        return issueRepository.findAll();
    }

    public Issue postIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public Issue updateIssue(long id, Issue issue) {
        return issueRepository.findById(id)
                .map(p -> {
                    p.setCloseDate(issue.getCloseDate());
                    p.setStateId(issue.getStateId());
                    return issueRepository.save(p);
                }).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public void deleteIssue(long id) {
        Issue issue = issueRepository.findById(id).get();
        issueRepository.delete(issue);
    }


}
