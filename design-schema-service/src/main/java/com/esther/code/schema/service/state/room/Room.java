package com.esther.code.schema.service.state.room;

import com.esther.code.schema.api.state.IRoomState;

/**
 * @author esther
 * 2018-05-23 15:33
 * 房间类：有三种状态
 */

public class Room {
    //    房间的三种状态
    //    空闲状态
    private IRoomState freeTimeState = new FreeTimeState(this);
    //    入住状态
    private IRoomState checkInState = new CheckInState(this);
    //    预订状态
    private IRoomState bookedState = new BookedState(this);
    //    房间的状态
    private IRoomState state;

    public Room() {
//      初始状态为空闲
        this.state = freeTimeState;
    }

    public Room(IRoomState state) {
        this.state = state;
    }

    /**
     * 预订房间
     */
    public void bookRoom() {
        this.state.bookRoom();
    }

    /**
     * 退订房间
     */
    public void unsubscribeRoom() {
        this.state.unsubscribeRoom();
    }

    /**
     * 入住
     */
    public void checkInRoom() {
        this.state.checkInRoom();
    }

    /**
     * 退房
     */
    public void checkOutRoom() {
        this.state.checkOutRoom();
    }

    @Override
    public String toString() {
        return "该房间的状态是:" + getState().getClass().getName();
    }

    public IRoomState getFreeTimeState() {
        return freeTimeState;
    }

    public void setFreeTimeState(IRoomState freeTimeState) {
        this.freeTimeState = freeTimeState;
    }

    public IRoomState getCheckInState() {
        return checkInState;
    }

    public void setCheckInState(IRoomState checkInState) {
        this.checkInState = checkInState;
    }

    public IRoomState getBookedState() {
        return bookedState;
    }

    public void setBookedState(IRoomState bookedState) {
        this.bookedState = bookedState;
    }

    public IRoomState getState() {
        return state;
    }

    public void setState(IRoomState state) {
        this.state = state;
    }
}
