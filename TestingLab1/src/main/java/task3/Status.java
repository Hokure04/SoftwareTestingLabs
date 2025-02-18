package task3;

public enum Status {
    IN_DESPAIR ("в отчаянии"),
    HAPPY ("с счастьем"),
    SCARED("с испугом"),
    TIRED("с усталостью");

    private final String description;

    Status(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
