package org.orbitshakers.tra.transformer;

public interface Transformer<Entity, Resource> {

    Resource transform(Entity entity);

    Entity extract(Resource resource);

}
