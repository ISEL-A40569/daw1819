package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.IssueState;
import pt.ipl.isel.leic.daw.project.repository.IssueStateRepository;

@RestController
@RequestMapping("/api/issuestate/")
public class IssueStateController {

    private final IssueStateRepository issueStateRepository;

    public IssueStateController(IssueStateRepository issueStateRepository) {
        this.issueStateRepository = issueStateRepository;
    }

    @GetMapping("{id}")
    public IssueState getIssueState(@PathVariable long id) {
        return issueStateRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("State does not exist."));
    }

    @GetMapping
    public Page<IssueState> getAllIssueStates(Pageable pageable) {
        return issueStateRepository.findAll(pageable);
    }

}
