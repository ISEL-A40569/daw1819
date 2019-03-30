package pt.ipl.isel.leic.daw.project.model;

import java.util.List;

public class ProjectCollection {
    private final List<Project> projects;

    public ProjectCollection(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
