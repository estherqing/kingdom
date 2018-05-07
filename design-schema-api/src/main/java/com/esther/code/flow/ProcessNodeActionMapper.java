package com.esther.code.flow;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/10.
 */
public class ProcessNodeActionMapper<ACTION extends IBaseProcessAction> {

    /**
     * node和action的映射，key的值为flowType#flowNodeCode，配置文件中配置
     */
    private Map<String, ACTION> nodeActionMapper;

    public Map<String, ACTION> getNodeActionMapper() {
        return new HashMap<>(nodeActionMapper);
    }

    public void setNodeActionMapper(Map<String, ACTION> nodeActionMapper) {
        this.nodeActionMapper = nodeActionMapper;
    }

    /**
     * 根据key，获取action
     *
     * @param key 形式为flowType#flowNodeCode
     * @return
     */
    public ACTION getActionByFlowNodeKey(String key) {
        ACTION action = nodeActionMapper.get(key);
        if (Objects.isNull(action)) {
            return null;
        }
        return action;
    }
}
