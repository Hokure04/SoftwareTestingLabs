package task3;

public class Person {
    protected String personName;
    protected int age;
    protected Gender gender;
    protected Status personStatus;
    protected boolean isHaveAnyHand;
    protected int weight;

    public Person(String personName, int age, Gender gender, Status personStatus, boolean isHaveAnyHand, int weight){
        this.personName = personName;
        this.age = age;
        this.gender = gender;
        this.personStatus = personStatus;
        this.isHaveAnyHand = isHaveAnyHand;
        this.weight = weight;
    }

    public String getPersonName() {
        return personName;
    }

    public void grabHand(Person person){
        String wordEnding = "";
        if(this.gender.equals(Gender.FEMALE)){
            wordEnding = "а";
        }
        if(person.isHaveAnyHand){
            System.out.println(this.personName + " " + this.personStatus.getDescription() +" схватил"+ wordEnding+  " за руку " + person.personName);
        }else{
            System.out.println("У " + this.personName + " не получилось схватить "+ person.personName + " за руку");
        }
    }

    public void pull(Person person, Thing thing){
        if(this.weight > person.weight/2){
            System.out.println(this.personName + " потянул " + person.personName + " к " + thing.getThingName());
        }else{
            System.out.println("У " + this.personName + " не хватило сил, чтобы потянуть " + person.personName + " к " + thing.getThingName());
        }
    }


}
