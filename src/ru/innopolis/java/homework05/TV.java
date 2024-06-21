package ru.innopolis.java.homework05;

import java.util.Objects;

public class TV {
    private boolean state;

    private int channel;

    private int volume;

    //public TV() {
        //this.state = false;
    //}

    //public TV(boolean state) {
      //  this.state = state;
   // }

    public TV(boolean state, int channel, int volume) {
        this.state = state;
        this.channel = channel;
        this.volume = volume;
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

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "TV{" +
                "state=" + state +
                ", channel=" + channel +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return state == tv.state && channel == tv.channel && volume == tv.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, channel, volume);
    }
}
