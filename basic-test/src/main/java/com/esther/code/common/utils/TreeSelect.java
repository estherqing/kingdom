package com.esther.code.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 树形控件工具类
 * 
 * @author chenyj
 * @version 2016-09-23
 */
public class TreeSelect {

	/**
	 * 获取json树形结构
	 * 
	 * @param list
	 * @return String
	 */
	public static String getJsonTree(List<Node> list) {
		Node root = new Node();
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			map.put(node.getNodeId(), node);
		}
		Set<Integer> keySets = map.keySet();
		for (Integer key : keySets) {
			Node node = map.get(key);
			if (node.getParentId() == 0) {
				root.addChild(node);
			} else {
				Node parent = map.get(node.getParentId());
				parent.addChild(node);
			}
		}
		root.sortChildren();
		return root.toString();

	}

}
