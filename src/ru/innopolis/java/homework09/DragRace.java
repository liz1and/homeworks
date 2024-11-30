package ru.innopolis.java.homework09;

public class DragRace extends Race {
    public DragRace(int length, String route, int prize) {
        super(length, route, prize);
    }

    @Override
    public String toString() {
        return "DragRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute()+ '\'' +
                ", prize=" + super.getPrize() +
                ", cars=" + super.getPrize() +
                '}';
    }

}
