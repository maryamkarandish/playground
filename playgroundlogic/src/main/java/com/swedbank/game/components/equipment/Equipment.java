package com.swedbank.game.components.equipment;

import com.swedbank.game.components.EquipmentLogManager;
import com.swedbank.game.components.Factory;
import com.swedbank.game.domain.Kid;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by maryam on 10/3/2018.
 */
@Component
public abstract class Equipment {
    private final static String VIP = "V";
    private final static String NORMAL = "N";
    private final static int PLAYLIST_LENGTH = 3;

    private int type;
    private String id;
    private String name;
    private LinkedList<Kid> vipQueue;
    private LinkedList<Kid> normalQueue;
    private String[] playlist;
    private int playlistSeek;
    private int capacity;
    private List<Kid> usingList;
    private EquipmentLogManager equipmentLogManager;

    protected Equipment(int type, String name, int capacity) {
        this.name = name;
        this.type = type;
        this.id = UUID.randomUUID().toString();
        this.playlist = new String[PLAYLIST_LENGTH];
        this.playlistSeek = 0;
        this.capacity = capacity;
        this.equipmentLogManager = Factory.createEquipmentLogManager();

        for(int i = 0; i < PLAYLIST_LENGTH; i++)
            this.playlist[i] = NORMAL;
    }

    public int getType() { return this.type; }
    public String getId() {
        return this.id;
    }
    public String getName() { return this.name; }
    public int getCapacity() {
        return this.capacity;
    }

    public void addQueue(Kid kid)
            throws Exception {
        if(this.queueLength() > this.getCapacity())
            throw new Exception(String.format("For this equipment maximum queue is %d, please try later", this.getCapacity()));

        if(kid.isVip())
            this.addVipQueue(kid);
        else
            this.addNormalQueue(kid);

        this.equipmentLogManager.addedToQueue(this, kid);
    }

    public int queueLength() {
        int queueLength = (this.vipQueue == null ?  0 : this.vipQueue.size())
                + (this.normalQueue == null ? 0 : this.normalQueue.size());

        return queueLength == 0 ? -1 : queueLength;
    }

    public LinkedList<Kid> getVipQueue() {
        return vipQueue;
    }

    public LinkedList<Kid> getNormalQueue() {
        return normalQueue;
    }

    public void removeQueue(Kid kid) {
        if(kid.isVip())
            this.removeVipQueue(kid);
        else
            this.removeNormalQueue(kid);
    }

    private void addVipQueue(Kid kid) {
        if(this.vipQueue == null)
            this.vipQueue = new LinkedList<>();

        this.vipQueue.add(kid);
        System.out.println(String.format("%s Added To VIP Queue", kid.getName()));
    }

    private void removeVipQueue(Kid kid) {
        if(this.vipQueue != null)
            this.vipQueue.remove(kid);

        System.out.println(String.format("%s Removed To VIP Queue", kid.getName()));
    }

    private void addNormalQueue(Kid kid) {
        if(this.normalQueue == null)
            this.normalQueue = new LinkedList<>();

        this.normalQueue.add(kid);
        System.out.println(String.format("%s Added To Normal Queue", kid.getName()));
    }

    private void removeNormalQueue(Kid kid) {
        if(this.normalQueue != null)
            this.normalQueue.remove(kid);

        System.out.println(String.format("%s Removed To Normal Queue", kid.getName()));

    }

    protected Kid nextKid() {
        Kid currentKid = null;

        if((this.vipQueue != null && this.vipQueue.size() > 0
                && this.normalQueue != null && this.normalQueue.size() > 0
                && this.hasPlaylistVip() == false)
                || (this.vipQueue != null && this.vipQueue.size() > 0
                && (this.normalQueue == null || this.normalQueue.size() == 0))) {
            currentKid = this.vipQueue.poll();
            this.playlist[this.playlistSeek++ % PLAYLIST_LENGTH] = VIP;
        } else if (this.normalQueue != null && this.normalQueue.size() > 0) {
            currentKid = this.normalQueue.poll();
            this.playlist[this.playlistSeek++ % PLAYLIST_LENGTH] = NORMAL;
        }

        return currentKid;
    }

    protected boolean hasPlaylistVip() {
        for (String item : this.playlist) {
            if(item.equals(VIP))
                return true;
        }

        return false;
    }

    public void start()
            throws Exception {
        this.usingList = new ArrayList<>();
        for(int i = 0; i < this.getCapacity(); i++) {
            Kid currentKid = this.nextKid();
            if (currentKid != null) {
                this.equipmentLogManager.start(this, currentKid);
                System.out.println(String.format("%s Start Utilizing", currentKid.getName()));
                this.usingList.add(currentKid);
            }
        }
    }

    public void end() {
        for (Kid item : this.usingList) {
            this.equipmentLogManager.end(this.getId(), item);
            System.out.println(String.format("%s End Utilizing", item.getName()));
        }
    }
}
