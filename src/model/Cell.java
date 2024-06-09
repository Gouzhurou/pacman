package model;

import event.Event;

public class Cell {
    private boolean passability; //проходимость (ессть стена или нет)
    private Event event;
    public Cell(boolean passability, Event event){
        this.event = event;
        this.passability = passability;
    }
    //значения по умолчанию
    public Cell(){
        this(true, null);
    }
    //чтобы при проверке не создавать кажду клетку заново (конструктор копирования)
    public Cell(Cell cell){
        this(cell.isPassable(), cell.getEvent());
    }
    public boolean isPassable(){
        return this.passability;
    }

    public Event getEvent(){
        return this.event;
    }

    public void setEvent(Event event){
        this.event = event;
    }
}
