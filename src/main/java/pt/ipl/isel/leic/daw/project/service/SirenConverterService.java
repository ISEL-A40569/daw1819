package pt.ipl.isel.leic.daw.project.service;

import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.converter.ReflectingConverter;
import com.google.code.siren4j.converter.ResourceConverter;
import com.google.code.siren4j.error.Siren4JException;
import org.springframework.stereotype.Service;

@Service
public class SirenConverterService<T> {

    ResourceConverter converter;

    public SirenConverterService() {
        try {
            converter = ReflectingConverter.newInstance();
        } catch (Siren4JException e) {
            e.printStackTrace();
        }
    }

    public Entity convert(T t){
        Entity entity = converter.toEntity(t);

        return entity;
    }
}
