package pt.ipl.isel.leic.daw.project.model.output;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.Field;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.builder.ActionBuilder;
import com.google.code.siren4j.component.builder.FieldBuilder;
import com.google.code.siren4j.component.builder.LinkBuilder;
import com.google.code.siren4j.component.impl.ActionImpl;
import com.google.code.siren4j.resource.BaseResource;
import pt.ipl.isel.leic.daw.project.model.Project;

import java.util.ArrayList;
import java.util.Collection;

@Siren4JEntity(name = "project", uri = "/api/project/{id}/"
)
public class ProjectOutputModel extends BaseResource {
    final private Long id;

    final private String name;

    final private String description;

    public ProjectOutputModel(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();

        Collection<Link> links = new ArrayList<Link>();
        links.add(LinkBuilder.newInstance().setRelationship("issues").setHref("/api/project/{id}/issue/").build());
        this.setEntityLinks(links);

        Collection<Action> actions = new ArrayList<Action>();

        Field id = FieldBuilder.newInstance()
                .setName("id")
                .setRequired(true)
                .build();

        Field projectId = FieldBuilder.newInstance()
                .setName("id")
                .setRequired(true)
                .build();

        Field issueDescription = FieldBuilder.newInstance()
                .setName("issueDescription")
                .setRequired(true)
                .build();

        Field creationDate = FieldBuilder.newInstance()
                .setName("creationDate")
                .setRequired(true)
                .build();

        Field labelId = FieldBuilder.newInstance()
                .setName("labelId")
                .setRequired(true)
                .build();

        Field ownerId = FieldBuilder.newInstance()
                .setName("creationDate")
                .setRequired(true)
                .build();

        Field stateId = FieldBuilder.newInstance()
                .setName("creationDate")
                .setRequired(true)
                .build();

        //Now the action
        Action addIssueAction = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.POST)
                .setName("AddIssue")
                .setHref("/api/project/{id}/issue/")
                .addField(id)
                .addField(projectId)
                .addField(issueDescription)
                .addField(creationDate)
                .addField(labelId)
                .addField(ownerId)
                .addField(stateId)
                .build();

        Action updateIssueAction = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.PUT)
                .setName("UpdateIssue")
                .setHref("/api/project/{id}/issue/{issueid}/")
                .addField(id)
                .addField(projectId)
                .addField(issueDescription)
                .addField(creationDate)
                .addField(labelId)
                .addField(ownerId)
                .addField(stateId)
                .build();


        Action deleteIssueAction = ActionBuilder.newInstance()
                .setMethod(ActionImpl.Method.DELETE)
                .setName("DeleteIssue")
                .setHref("/api/project/{id}/issue/{issueid}/")
                .addField(id)
                .addField(projectId)
                .build();

        actions.add(addIssueAction);
        actions.add(updateIssueAction);
        actions.add(deleteIssueAction);
        this.setEntityActions(actions);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

}
