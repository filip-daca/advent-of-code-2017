package day07b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.InputReader;

public class Main {
	
	private static void compute(List<Command> commands) {
		Map<String, Node> nodes = new HashMap<>();
		commands.forEach(c -> nodes.put(c.getNodeName(), createNode(c)));
		commands.forEach(c -> {
				if (c.getChildrenNames() != null) {
					addChildren(nodes, c.getNodeName(), c.getChildrenNames());
				}
			});
		
		Node root = nodes.get(commands.get(0).getNodeName());
		while (root.getParent() != null) {
			root = root.getParent();
		}
		
		root.checkBalance();
		root.findUnbalanced();
	}
	
	private static void addChildren(Map<String, Node> nodes, String parentName, List<String> childrenNames) {
		Node parent = nodes.get(parentName);
		childrenNames.forEach(n -> parent.addChild(nodes.get(n)));
	}

	private static Node createNode(Command c) {
		return new Node(c.getNodeName(), c.getNodeWeight());
	}

	public static void main(String[] args) {
		List<Command> commands = new ArrayList<>();
		
		InputReader.init();
		while (InputReader.hasNext()) {
			commands.add(new Command(InputReader.nextLine()));
		}
		InputReader.close();		
		
		compute(commands);
	}
}
