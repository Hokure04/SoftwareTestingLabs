package task3;

public class AeronauticalRodents extends Creature{

    public AeronauticalRodents(){
        super("воздухоплавающие грызуны", true, true, true);
    }


    @Override
    public void attack(Person person){
        System.out.println(this.creatureName + " загипнотизировали " + person.getPersonName());
    }
}
