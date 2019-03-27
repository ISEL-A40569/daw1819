package pt.ipl.isel.leic.daw.project.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.leic.daw.project.exception.ResourceNotFoundException;
import pt.ipl.isel.leic.daw.project.model.IssueLabel;
import pt.ipl.isel.leic.daw.project.repository.IssueLabelRepository;

@RestController
@RequestMapping("/api/issuelabel/")
public class IssueLabelController {

    private final IssueLabelRepository issueLabelRepository;

    public IssueLabelController(IssueLabelRepository issueLabelRepository) {
        this.issueLabelRepository = issueLabelRepository;
    }

    @GetMapping("{id}")
    public IssueLabel getIssueLabel(@PathVariable long id) {
        return issueLabelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Label does not exist."));
    }

    @GetMapping
    public Page getAllLabels(Pageable pageable) {
        return issueLabelRepository.findAll(pageable);
    }

}
