package day07a;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;
	private int weight;
	
	private Node parent;
	private List<Node> children;
	
	public Node(String name, int weight) {
		this.name = name;
		this.weight = weight;
		this.children = new ArrayList<>();
	}

	public void addChild(Node child) {
		children.add(child);
		child.setParent(this);
	}

	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	private void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}
	
}
