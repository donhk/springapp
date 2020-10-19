package dev.donhk.pojo;

import java.io.Serializable;

public class ButtonData implements Serializable {

    private static final long serialVersionUID = -4534116989571738735L;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
