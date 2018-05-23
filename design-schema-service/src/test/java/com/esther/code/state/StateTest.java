package com.esther.code.state;

import com.esther.code.schema.service.state.dispenser.FullState;
import com.esther.code.schema.service.state.dispenser.WaterDispenser;
import com.esther.code.schema.service.state.room.Room;

/**
 * @author esther
 * 2018-05-23 14:33
 * $DESCRIPTION}
 */

public class StateTest {
    public static void main(String[] args) {
      /*  WaterDispenser waterDispenser = new WaterDispenser(new FullState());
        for (int i = 0; i < 20; i++) {
            waterDispenser.press();
        }*/

        Room[] rooms = new Room[3];
        for (int i = 0, len = rooms.length; i < len; i++) {
            rooms[i] = new Room();
        }
        rooms[0].bookRoom();
        rooms[0].checkInRoom();
        rooms[0].bookRoom();
        System.out.println(rooms[0].toString());
        System.out.println("--------------------------");

        rooms[1].checkInRoom();
        rooms[1].bookRoom();
        rooms[1].checkOutRoom();
        rooms[1].bookRoom();
        System.out.println(rooms[1].toString());
        System.out.println("--------------------------");

        rooms[2].bookRoom();
        rooms[2].unsubscribeRoom();
        rooms[2].bookRoom();
        System.out.println(rooms[2].toString());
    }
}
