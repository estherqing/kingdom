package com.vivo.jovi.scene.common.activity.rule;

import com.vivo.jovi.scene.common.model.SceneRequest;
import com.vivo.jovi.scene.common.model.SceneResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tian Guangxin
 * @date 2018/11/20
 * @since 1.0
 */
public abstract class AbstractRule implements Rule {
    private static final int OPERATOR_AND = 1;

    private static final int OPERATOR_OR = 2;

    private static final int OPERATOR_NEGATE = 3;

    private Rule other;

    private int operator = 0;

    private Map<String,String> attribute;

    @Override
    public boolean predicate(SceneRequest request, SceneResponse response) {
        if(other == null){
            return doPredicate(request,response);
        }
        if(OPERATOR_AND == operator){
            return other.predicate(request,response) && doPredicate(request,response);
        }
        if(OPERATOR_OR == operator){
            return other.predicate(request,response) || doPredicate(request,response);
        }
        if(OPERATOR_NEGATE == operator){
            return !doPredicate(request,response);
        }
        return false;
    }



    @Override
    public Rule and(Rule other) {
        this.other = other;
        this.operator = OPERATOR_AND;
        return this;
    }

    @Override
    public Rule or(Rule other) {
        this.other = other;
        this.operator = OPERATOR_OR;
        return this;
    }

    @Override
    public Rule negate() {
        this.other = null;
        this.operator = OPERATOR_NEGATE;
        return this;
    }

    @Override
    public String getAttribute(String name) {
        if(this.attribute == null){
            return null;
        }
        return this.attribute.get(name);
    }

    @Override
    public Map<String, String> getAttributeMap() {
        if(this.attribute == null){
            return null;
        }
        return new HashMap<>(this.attribute);
    }

    @Override
    public String getType() {
        return RuleTypeRepository.getType(getClass());
    }

    protected abstract boolean doPredicate(SceneRequest request, SceneResponse response);
}
