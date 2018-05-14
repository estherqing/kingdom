package com.esther.code.pipeline.valve;

import java.util.List;

/**
 * Author: jiyanbin@zafh.com.cn
 * Date: 2015-11-6
 * JDK: 1.8
 */
public abstract class BaseValveChain<V> {
    protected List<V> valves = null;

    protected int index = 0;

    protected int size;

    public BaseValveChain(List<V> valves) {
        this.valves = valves;
        this.size = valves.size();
    }

    public BaseValveChain(List<V> valves, int index) {
        this(valves);
        this.index = index;
    }
}
