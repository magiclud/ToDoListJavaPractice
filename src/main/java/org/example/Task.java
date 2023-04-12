package org.example;

public class Task {

    private String value;

    private boolean completed;
    Task(String value){
        this.value = value;
        this.completed = false;
    }


    @Override
    public String toString() {
        return "[" + value + "] > completed: "+completed ;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
