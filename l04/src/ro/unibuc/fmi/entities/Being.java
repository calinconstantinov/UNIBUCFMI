package ro.unibuc.fmi.entities;

public abstract class Being {

    private Integer position;

    private String name;

    private Integer hp;

    public Being(String name, Integer position, Integer hp) {
        this.position = position;
        this.name = name;
        this.hp = hp;
    }

    public abstract Integer doDamage();

    public Integer takeDamage(Integer damage) {
        hp -= damage;
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    protected void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getHp() {
        return hp;
    }
}
