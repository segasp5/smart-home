package ru.sbt.mipt.oop;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(String id, boolean isOpen) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
