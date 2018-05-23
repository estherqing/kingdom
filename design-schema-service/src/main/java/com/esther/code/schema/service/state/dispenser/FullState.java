package com.esther.code.schema.service.state.dispenser;

import com.esther.code.schema.api.state.IDispenserState;

/**
 * @author esther
 * 2018-05-23 14:29
 * $DESCRIPTION}
 */

public class FullState implements IDispenserState {
    @Override
    public void press() {
        System.out.println("water is pouring.");
    }
}
