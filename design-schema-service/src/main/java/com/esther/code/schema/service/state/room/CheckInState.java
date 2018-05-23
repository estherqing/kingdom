package com.esther.code.schema.service.state.room;

import com.esther.code.schema.api.state.IRoomState;

/**
 * @author esther
 * 2018-05-23 15:31
 * 入住状态只能退房
 */

public class CheckInState implements IRoomState {
    private Room room;

    public CheckInState(Room room) {
        this.room = room;
    }

    @Override
    public void bookRoom() {
        System.out.println("该房间已经被别人入住了！");
    }

    @Override
    public void unsubscribeRoom() {

    }

    @Override
    public void checkInRoom() {
        System.out.println("该房间已经被别人入住了！");
    }

    @Override
    public void checkOutRoom() {
        System.out.println("退房成功。");
        room.setState(room.getFreeTimeState());
    }
}
