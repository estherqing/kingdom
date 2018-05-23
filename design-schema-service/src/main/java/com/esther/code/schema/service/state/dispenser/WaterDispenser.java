package com.esther.code.schema.service.state.dispenser;

import com.esther.code.schema.api.state.IDispenserState;

/**
 * @author esther
 * 2018-05-23 14:31
 * $DESCRIPTION}
 */

public class WaterDispenser {
    private int capacity = 10;
    private IDispenserState state;

    public WaterDispenser(IDispenserState state) {
        this.state = state;
    }

    public IDispenserState getState() {
        return state;
    }

    public void setState(IDispenserState state) {
        this.state = state;
    }

    public void press() {
        if (capacity <= 0) {
            setState(new EmptyState());
            this.state.press();
            return;
        }
        capacity--;
        System.out.println("water capacity:" + capacity);
        this.state.press();
    }
}
