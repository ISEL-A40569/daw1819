package pt.ipl.isel.leic.daw.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.ipl.isel.leic.daw.project.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
