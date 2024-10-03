package ru.innopolis.java.homework09;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prize) {
        super(length, route, prize);
    }

    @Override
    public String toString() {
        return "DriftRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute()+ '\'' +
                ", prize=" + super.getPrize() +
                ", cars=" + super.getPrize() +
                '}';
    }
}
