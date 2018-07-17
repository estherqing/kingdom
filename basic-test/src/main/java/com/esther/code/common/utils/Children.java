package com.esther.code.common.utils;

 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 树形结构子节点类
 * 
 * @author chenyj
 * @version 2016-09-23
 */
public class Children implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 子节点列表
	private List<Node> list = new ArrayList<Node>();

	// 获取子节点列表大小
	public int getSize() {
		return list.size();
	}

	// 增加子节点
	public void addChild(Node node) {
		list.add(node);
	}

	// 子节点排序
	public void sortChildren() {
		Collections.sort(list, new NodeComparator());
		for (Iterator<Node> it = list.iterator(); it.hasNext();) {
			((Node) it.next()).sortChildren();
		}
	}

	// 转换为json字符串
	public String toString() {
		String result = "[";
		for (int i = 0; i < list.size(); i++) {

			result += list.get(i).toString();
			result += ",";
		}
		result = result.substring(0, result.length() - 1);
		result += "]";
		return result;
	}
}
