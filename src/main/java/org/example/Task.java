package org.example;

public record Task(String value, boolean completed) {

    public Task asCompleted() {
        return new Task(this.value, true);
    }
}
