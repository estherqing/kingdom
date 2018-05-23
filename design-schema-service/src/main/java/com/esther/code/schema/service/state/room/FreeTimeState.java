package com.esther.code.schema.service.state.room;

import com.esther.code.schema.api.state.IRoomState;

/**
 * @author esther
 * 2018-05-23 15:31
 * 空闲状态只能预订和入住
 */

public class FreeTimeState implements IRoomState {
    private Room room;

    public FreeTimeState(Room room) {
        this.room = room;
    }

    @Override
    public void bookRoom() {
        System.out.println("您成功预订了该房间。");
        this.room.setState(this.room.getBookedState());
    }

    @Override
    public void unsubscribeRoom() {

    }

    @Override
    public void checkInRoom() {
        System.out.println("您成功入住了该房间。");
        room.setState(room.getCheckInState());
    }

    @Override
    public void checkOutRoom() {

    }
}
