package interfaces_anotations.models;

public class Minotaur extends Enemy{

    public void figth(){
        attack((int endX, int endY)->{
            int diffX=endX - this.getPositionX();
            int diffY=endY - this.getPositionY();
            return diffX - diffY;
        });
    }
    public void attack(CalculateDistance calculateDistance){
        int distance=calculateDistance.calculate(this.getPositionX() + 10,this.getPositionY());
    };

}
