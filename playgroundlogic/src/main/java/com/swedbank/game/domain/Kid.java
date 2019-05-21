package com.swedbank.game.domain;

/**
 * Created by maryam on 10/3/2018.
 */
public class Kid {
    private String name;
    private String ticketNo;
    private Byte age;
    private Boolean isVip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Boolean isVip() {
        return isVip;
    }

    public void setVip(Boolean vip) {
        isVip = vip;
    }
}
