package pt.ipl.isel.leic.daw.project.model.output;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import pt.ipl.isel.leic.daw.project.model.Project;
import pt.ipl.isel.leic.daw.project.model.ProjectCollection;

import java.util.List;

@Siren4JEntity(name = "projectCollection", uri = "/api/project/")
public class ProjectCollectionOutputModel extends BaseResource {
    private final List<Project> projects;

    public ProjectCollectionOutputModel(ProjectCollection projectCollection) {
        this.projects = projectCollection.getProjects();
    }

    public List<Project> getProjects() {
        return projects;
    }
}
