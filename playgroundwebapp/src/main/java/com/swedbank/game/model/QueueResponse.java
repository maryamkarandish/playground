package com.swedbank.game.model;

import com.swedbank.game.domain.Kid;

import java.util.List;

/**
 * Created by maryam on 10/6/2018.
 */
public class QueueResponse {
    private int queueLength;
    private List<Kid> vipQueue;
    private List<Kid> normalQueue;

    public int getQueueLength() {
        return this.queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    public List<Kid> getVipQueue() {
        return vipQueue;
    }

    public void setVipQueue(List<Kid> vipQueue) {
        this.vipQueue = vipQueue;
    }

    public List<Kid> getNormalQueue() {
        return normalQueue;
    }

    public void setNormalQueue(List<Kid> normalQueue) {
        this.normalQueue = normalQueue;
    }
}
