package com.esther.code.schema.api.state;

/**
 * @author esther
 * 2018-05-23 15:30
 * 状态接口：有四种行为
 */

public interface IRoomState {
    /**
     * 预订房间
     */
    void bookRoom();

    /**
     * 退订房间
     */
    void unsubscribeRoom();

    /**
     * 入住
     */
    void checkInRoom();

    /**
     * 退房
     */
    void checkOutRoom();
}
