package dev.donhk.pojo;

public class Stats {
    private final long pressed;
    private final String ip;

    public Stats(long pressed, String ip) {
        this.pressed = pressed;
        this.ip = ip;
    }

    public long getPressed() {
        return pressed;
    }

    public String getIp() {
        return ip;
    }
}
