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

    public Issue updateIssue(long issueId, Issue issue) {
        return issueRepository.findById(issueId)
                .map(newIssue -> {
                    newIssue.setDescription(issue.getDescription());
                    newIssue.setLabelid(issue.getLabelid());
                    newIssue.setOwnerid(issue.getOwnerid());
                    //newIssue.setProjectid(issue.getProjectid());
                    newIssue.setClosedate(issue.getClosedate());
                    newIssue.setStateid(issue.getStateid());
                    return issueRepository.save(newIssue);
                }).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public void deleteIssue(long id) {
        Issue issue = issueRepository.findById(id).get();
        issueRepository.delete(issue);
    }


}
