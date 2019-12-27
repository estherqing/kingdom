package com.vivo.jovi.scene.common.model;

import java.util.List;

public class TagTree {

    private List<TagTree> children;

    private String selectAble;

    private String label;

    private String hasScore;

    private String key;

    public List<TagTree> getChildren() {
        return children;
    }

    public void setChildren(List<TagTree> children) {
        this.children = children;
    }

    public String getSelectAble() {
        return selectAble;
    }

    public void setSelectAble(String selectAble) {
        this.selectAble = selectAble;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHasScore() {
        return hasScore;
    }

    public void setHasScore(String hasScore) {
        this.hasScore = hasScore;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
