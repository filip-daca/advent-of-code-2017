package day07b;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

	private String nodeName;
	private int nodeWeight;
	private List<String> childrenNames;
	
	public Command(String s) {
		Pattern p = Pattern.compile("(\\w+?)\\s\\((\\d+?)\\)");
		Matcher m = p.matcher(s);
		m.find();
		this.nodeName = m.group(1);
		this.nodeWeight = Integer.parseInt(m.group(2));
		if (s.contains("->")) {
			s = s.substring(s.lastIndexOf(">") + 2);
			childrenNames = Arrays.asList(s.split(", "));
		}
	}
	
	public String getNodeName() {
		return nodeName;
	}
	
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public int getNodeWeight() {
		return nodeWeight;
	}
	
	public void setNodeWeight(int nodeWeight) {
		this.nodeWeight = nodeWeight;
	}
	
	public List<String> getChildrenNames() {
		return childrenNames;
	}
	
	public void setChildrenNames(List<String> childrenNames) {
		this.childrenNames = childrenNames;
	}
	
}
