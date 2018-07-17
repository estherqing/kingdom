package com.esther.code.common.utils;

 

import java.io.Serializable;

/**
 * 树形结构节点类
 *
 * @author chenyj
 * @version 2016-09-23
 */
public class Node implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int nodeId;// 节点ID
    private String nodeName;// 节点描述
    private int parentId;// 父节点ID
    private String parentIds;//路径
    private int level;//等级
    private Children children = new Children();

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // 子节点排序
    public void sortChildren() {
        if (children != null && children.getSize() > 0) {
            children.sortChildren();
        }
    }

    // 增加子节点
    public void addChild(Node node) {
        children.addChild(node);
    }

    // 转换为json字符串
    public String toString() {
        String result = "";
        if (nodeName != null) {
            result = "{\"" + "nodeId\" : " + nodeId + ", \"nodeName\" : \"" + nodeName + "\"" + ", \"parentId\" : "
                    + parentId + ", \"level\" : " + level;
        } else {
            result = "{\"" + "nodeId\" : " + nodeId + ", \"parentId\" : " + parentId;
        }

        if (children != null && children.getSize() != 0) {
            result += ", \"children\" : " + children.toString();
        } else {
            result += ", \"leaf\" : true";
        }

        result += ", \"expand\" : false";

        return result + "}";
    }

}
