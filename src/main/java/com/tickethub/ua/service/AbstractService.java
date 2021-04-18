package com.tickethub.ua.service;

import java.util.List;

public interface AbstractService<Entity> {

    Entity findById(Long id);

    List<Entity> findAll();

    Entity create(Entity entity);

    Entity update(Entity entity);

    void deleteById(Long id);
}
