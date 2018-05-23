package com.esther.code.schema.service.state.dispenser;

import com.esther.code.schema.api.state.IDispenserState;

/**
 * @author esther
 * 2018-05-23 14:30
 * $DESCRIPTION}
 */

public class EmptyState implements IDispenserState {
    @Override
    public void press() {
        System.out.println("no water!");
    }
}
