package pt.ipl.isel.leic.daw.project.model.output;

import com.google.code.siren4j.annotations.Siren4JEntity;
import pt.ipl.isel.leic.daw.project.model.Issue;
import pt.ipl.isel.leic.daw.project.model.IssueCollection;

import java.util.List;

@Siren4JEntity(name = "issueCollection", uri = "/api/project/{projectId}/issue")
public class IssueCollectionOutputModel {

    private final List<Issue> issues;

    public IssueCollectionOutputModel(IssueCollection issueCollection) {
        this.issues = issueCollection.getIssues();
    }

    public List<Issue> getIssues() {
        return issues;
    }
}
