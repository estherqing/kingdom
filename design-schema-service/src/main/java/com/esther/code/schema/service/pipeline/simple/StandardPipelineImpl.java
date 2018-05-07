package com.esther.code.schema.service.pipeline.simple;


import com.esther.code.schema.api.pipeline.simple.StandardPipeline;
import com.esther.code.schema.api.pipeline.simple.StandardValve;
import org.springframework.stereotype.Component;

/**
 * @author esther
 * @create 2017-09-28 19:22
 * $DESCRIPTION}
 */
@Component("standardPipelineImpl")
public class StandardPipelineImpl implements StandardPipeline {
    protected StandardValve first = null;
    protected StandardValve basic = null;
    public void addValve(StandardValve valve) {
        if (first == null) {
            first = valve;
            valve.setNext(basic);
        } else {
            StandardValve current = first;
            while (current != null) {
                if (current.getNext() == basic) {
                    current.setNext(valve);
                    valve.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }
    }
    public StandardValve getBasic() {
        return basic;
    }
    public StandardValve getFirst() {
        return first;
    }
    public void setBasic(StandardValve valve) {
        this.basic = valve;
    }
}
