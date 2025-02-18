package task3;

import java.util.List;
import java.util.StringJoiner;

public class Door extends Thing implements IsOpenable {
    protected boolean isSomethingPreventing;
    protected boolean isOpen;

    public Door(boolean isSomethingPreventing, boolean isOpen){
        super("дверь");
        this.isSomethingPreventing = isSomethingPreventing;
        this.isOpen = isOpen;
    }

    public void setIsOpen(boolean status){
        this.isOpen = status;

    }

    @Override
    public boolean open(List<Person> persons){

        if(isSomethingPreventing){
            System.out.println("Что-то мешает открыть дверь");
            return false;
        }
        if(persons.isEmpty()){
            System.out.println("Никто не пытается открыть дверь");
            return false;
        }

        System.out.println(formatPersonAttempt(persons) + " попытались открыть дверь");
        setIsOpen(true);
        System.out.println(this.getThingName() + " открылась");
        return true;
    }



    @Override
    public boolean close(List<Person> persons){
        if(isSomethingPreventing){
            System.out.println("Что-то мешает закрыть дверь");
            return false;
        }
        if (persons.isEmpty()){
            System.out.println("Никто не пытается закрыть дверь");
            return false;
        }
        System.out.println(formatPersonAttempt(persons) + " попытались закрыть дверь");
        setIsOpen(false);
        System.out.println(this.getThingName() + " закрылась");
        return true;
    }

    private String formatPersonAttempt(List<Person> personList){
        int size = personList.size();
        if(size == 1){
            return personList.get(0).getPersonName();
        }

        StringJoiner joiner = new StringJoiner(", ");
        for(int i = 0; i < size - 1; i++){
            joiner.add(personList.get(i).getPersonName());
        }

        return joiner.toString() + " и " + personList.get(size-1).getPersonName();
    }
}
