package ru.innopolis.java.homework09;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prize) {
        super(length, route, prize);
    }

    @Override
    public String toString() {
        return "CasualRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute()+ '\'' +
                ", prize=" + super.getPrize() +
                ", cars=" + super.getPrize() +
                '}';
    }
}
