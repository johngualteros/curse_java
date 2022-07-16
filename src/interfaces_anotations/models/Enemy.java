package interfaces_anotations.models;

public abstract class Enemy {
    protected Double health;
    protected Integer positionX;
    protected Integer positionY;

    public Enemy(){

    }

    public Enemy(Double health, Integer positionX, Integer positionY) {
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }
}
