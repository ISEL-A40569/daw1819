package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.IssueStateTransition;
import pt.ipl.isel.leic.daw.project.repository.IssueStateTransitionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/issueStateTransition/")
public class IssueStateTransitionController {

    private final IssueStateTransitionRepository issueStateTransitionRepository;

    public IssueStateTransitionController(IssueStateTransitionRepository issueStateTransitionRepository) {
        this.issueStateTransitionRepository = issueStateTransitionRepository;
    }

    @GetMapping("{issueStateTransitionId}")
    public IssueStateTransition getIssueStateTransition(@PathVariable long issueStateTransitionId) {
        return issueStateTransitionRepository.findById(issueStateTransitionId).orElseThrow( () -> new ResourceNotFoundException("State Transition does not exist."));
    }

    @GetMapping
    public List<IssueStateTransition> getIssueStateTransitions() {
        return issueStateTransitionRepository.findAll();
    }
}
