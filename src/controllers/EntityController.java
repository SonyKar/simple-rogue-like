package controllers;

import Model.Entity;

public abstract class EntityController {
    Entity entity;

    public EntityController(Entity entity) {
        this.entity = entity;
    }

    public void takeDamage(int damage) {
        entity.setCurrentHealth(entity.getCurrentHealth() - damage);
    }
}
