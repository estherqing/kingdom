package com.esther.code.schema.service.state.room;

import com.esther.code.schema.api.state.IRoomState;

/**
 * @author esther
 * 2018-05-23 15:31
 * 预订状态可以退订和入住
 */

public class BookedState implements IRoomState {
    private Room room;

    public BookedState(Room room) {
        this.room = room;
    }

    @Override
    public void bookRoom() {
        System.out.println("该房间已经被别人预订了！");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("退订成功，欢迎下次光临！");
        room.setState(room.getFreeTimeState());
    }

    @Override
    public void checkInRoom() {
        System.out.println("入住成功。");
        room.setState(room.getCheckInState());
    }

    @Override
    public void checkOutRoom() {

    }
}
