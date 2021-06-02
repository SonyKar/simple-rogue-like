package Model;

public abstract class Entity {
    private String name;
    private int health;
    private int currentHealth;
    private int damage;

    public Entity() {
    }

    public Entity(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.currentHealth = health;
        this.damage = damage;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
