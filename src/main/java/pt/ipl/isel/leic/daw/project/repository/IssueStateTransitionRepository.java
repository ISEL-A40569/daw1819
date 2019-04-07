package pt.ipl.isel.leic.daw.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.ipl.isel.leic.daw.project.model.IssueStateTransition;

@Repository
public interface IssueStateTransitionRepository extends JpaRepository<IssueStateTransition, Long> {
}
