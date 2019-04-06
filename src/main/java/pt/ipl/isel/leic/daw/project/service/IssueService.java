package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Issue;
import pt.ipl.isel.leic.daw.project.repository.IssueRepository;

import java.util.List;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {

        this.issueRepository = issueRepository;
    }

    public Issue getIssue(long id) {
        return issueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public List<Issue> getIssue() {
        return issueRepository.findAll();
    }

    public Issue postIssue(Issue issue, long projectId) {
        issue.setProjectid(projectId); //uglyShit #AM
        return issueRepository.save(issue);
    }

    public Issue updateIssue(long id, Issue issue) {
        return issueRepository.findById(id)
                .map(p -> {
                    p.setClosedate(issue.getClosedate());
                    p.setStateid(issue.getStateid());
                    return issueRepository.save(p);
                }).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public void deleteIssue(long id) {
        Issue issue = issueRepository.findById(id).get();
        issueRepository.delete(issue);
    }


}
