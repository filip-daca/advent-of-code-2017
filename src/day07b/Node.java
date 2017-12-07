package day07b;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;
	private int weight;
	private boolean balanced;
	
	private Node parent;
	private List<Node> children;
	
	public Node(String name, int weight) {
		this.name = name;
		this.weight = weight;
		this.children = new ArrayList<>();
		balanced = true;
	}
	
	public void checkBalance() {
		if (children.isEmpty()) {
			this.balanced = true;
		} else {
			int childWeight = children.get(0).getSumWeight();
			children.forEach(c -> {
				if (c.getSumWeight() != childWeight) {
					this.balanced = false;
				}
				c.checkBalance();
			});
		}
	}
	
	public void findUnbalanced() {
		if (!isBalanced()) {
			System.out.println("Unbalanced " + this);
			children.forEach(c -> {
				System.out.println("  childs: " + c);
			});
			children.forEach(c -> {
				if (!c.isBalanced()) {
					c.findUnbalanced();
				}
			});
		} 
	}

	public void addChild(Node newChild) {
		children.add(newChild);
		newChild.setParent(this);
	}

	public String getName() {
		return name;
	}
	
	public int getSumWeight() {
		int sum = weight;
		for (Node child : children) {
			sum += child.getSumWeight();
		}
		return sum;
	}
	
	private void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public boolean isBalanced() {
		return balanced;
	}
	
	@Override
	public String toString() {
		return getName() + " (" + weight + "/" + getSumWeight() + ")" + (balanced?"":"!");
	}
}
