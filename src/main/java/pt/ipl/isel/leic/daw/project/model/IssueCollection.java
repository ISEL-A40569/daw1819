package pt.ipl.isel.leic.daw.project.model;

import java.util.List;

public class IssueCollection {
    private final List<Issue> issues;

    public IssueCollection(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Issue> getIssues() {
        return issues;
    }
}
