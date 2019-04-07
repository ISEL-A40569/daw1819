package pt.ipl.isel.leic.daw.project.service;

import org.springframework.stereotype.Service;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.Issue;
import pt.ipl.isel.leic.daw.project.repository.IssueRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {
    private final IssueRepository issueRepository;
    private final CommentService commentService;

    public IssueService(IssueRepository issueRepository, CommentService commentService) {
        this.issueRepository = issueRepository;
        this.commentService = commentService;
    }

    public Issue getIssue(long issueId) {
        return issueRepository.findById(issueId).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public List<Issue> getProjectIssues(long projectId) {
        return issueRepository
                .findAll()
                .stream()
                .filter(issue -> issue.getProjectid() == projectId)
                .collect(Collectors.toList());
    }

    public Issue postIssue(Issue issue, long projectId) {
        issue.setProjectid(projectId);
        return issueRepository.save(issue);
    }

    public Issue updateIssue(long issueId, Issue issue) {
        return issueRepository.findById(issueId)
                .map(newIssue -> {
                    newIssue.setDescription(issue.getDescription());
                    newIssue.setLabelid(issue.getLabelid());
                    newIssue.setOwnerid(issue.getOwnerid());
                    newIssue.setClosedate(issue.getClosedate());
                    newIssue.setStateid(issue.getStateid());
                    return issueRepository.save(newIssue);
                }).orElseThrow(() -> new ResourceNotFoundException("Issue does not exits."));
    }

    public void deleteIssue(long id) {
        Issue issue = issueRepository.findById(id).get();
        commentService.getIssueComments(id).forEach(comment -> commentService.deleteComment(comment.getCommentId()));
        issueRepository.delete(issue);
    }

}
