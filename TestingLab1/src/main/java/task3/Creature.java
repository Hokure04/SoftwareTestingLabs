package task3;

public class Creature {
    protected String creatureName;
    protected boolean isDangerous;
    protected boolean canFly;
    protected boolean canHypnotize;


    public Creature(String creatureName, boolean isDangerous, boolean canFly, boolean canHypnotize){
        this.creatureName = creatureName;
        this.isDangerous = isDangerous;
        this.canFly = canFly;
        this.canHypnotize = canHypnotize;
    }

    public String getCreatureName(){
        return creatureName;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public boolean isCanHypnotize() {
        return canHypnotize;
    }

    public void attack(Person person){
        if(isDangerous){
            System.out.println(this.getCreatureName() + " атакует "+ person.getPersonName());
        }else{
            System.out.println(this.creatureName + " решило не атаковать "+person.getPersonName());
        }
    }
}
