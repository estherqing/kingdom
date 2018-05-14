package com.esther.code.api.schema.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @author esther
 * 2018-05-09 14:57
 * $DESCRIPTION}
 */

public class DIYEvent extends ApplicationEvent {
    private static final long serialVersionUID = 7099057708183571977L;

    public DIYEvent(String source) {
        super(source);
    }
}
