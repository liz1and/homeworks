package ru.innopolis.java.homework03;

public class TV {
    private boolean state;

    private int channel;

    public TV() {
        this.state = false;
    }

    public TV(boolean state) {
        this.state = state;
    }

    public boolean isWorking() {
        return this.state;
    }

    public int getChannel() {
        return this.channel;
    }

    public void switchChannel(int channel) {
        this.channel = channel;
    }

    public void turnOn() {
        this.state = true;
    }

    public void turnOff() {
        this.state = false;
    }

    @Override
    public String toString() {
        return "TV{" +
                "state=" + state +
                ", channel=" + channel +
                '}';
    }
}
