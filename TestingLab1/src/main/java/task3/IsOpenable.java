package task3;

import java.util.List;

public interface IsOpenable {
    boolean open(List<Person> persons);
    boolean close(List<Person> person);
}
