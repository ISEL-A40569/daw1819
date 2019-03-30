package pt.ipl.isel.leic.daw.project.model.output;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.Field;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.builder.ActionBuilder;
import com.google.code.siren4j.component.builder.FieldBuilder;
import com.google.code.siren4j.component.builder.LinkBuilder;
import com.google.code.siren4j.resource.BaseResource;
import pt.ipl.isel.leic.daw.project.model.Project;

import java.util.ArrayList;
import java.util.Collection;

    @Siren4JEntity(name = "project", uri = "/project/{id}"
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
        links.add(LinkBuilder.newInstance().setRelationship("next").setHref("/project/{id}/next").build());
        this.setEntityLinks(links);

        Collection<Action> actions = new ArrayList<Action>();

        //Create the field first
        Field videonameField = FieldBuilder.newInstance()
                .setName("projectname")
                .setRequired(true)
                .build();
        //Now the action
        Action someAction = ActionBuilder.newInstance()
                .setName("someaction")
                .setHref("/project/{id}/dosomething")
                .addField(videonameField)
                .build();

        actions.add(someAction);
        this.setEntityActions(actions);
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }

        public Long getId() {
            return id;
        }

//        public void setId(Long id) {
//            this.id = id;
//        }


}
