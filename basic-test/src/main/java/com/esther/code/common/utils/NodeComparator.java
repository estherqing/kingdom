package com.esther.code.common.utils;

 

import java.util.Comparator;

/**
 * 树形结构节点排序
 * 
 * @author chenyj
 * @version 2016-09-23
 */
public class NodeComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		int i = ((Node)o1).getNodeId();
		int j = ((Node)o2).getNodeId();
		return (i < j ? -1 : (i == j ? 0 : 1));
	}

}
