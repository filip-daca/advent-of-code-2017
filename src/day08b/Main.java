package day08b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.InputReader;

public class Main {
	
	private static void compute(List<Command> commands) {
		int maxRegVal = 0;
		
		Map<String, Integer> registers = new HashMap<>();
		for (Command c : commands) {
			int conditionRegVal = safeGet(registers, c.getConditionRegister());
			if (checkCondition(conditionRegVal, c.getConditionValue(), c.getConditionOperator())) {
				int oldVal = safeGet(registers, c.getRegister());
				registers.put(c.getRegister(), oldVal + c.getValue());
				
				if (oldVal + c.getValue() > maxRegVal) {
					maxRegVal = oldVal + c.getValue();
				}
			}
		}
		
		System.out.println(maxRegVal);
	}
	
	public static int safeGet(Map<String, Integer> m, String k) {
		if (!m.containsKey(k)) {
			m.put(k, 0);
		}
		return m.get(k);
	}

	public static boolean checkCondition(int conditionRegVal, int conditionVal, String operator) {
		switch (operator) {
			case "==": return conditionRegVal == conditionVal;
			case "<=": return conditionRegVal <= conditionVal;
			case ">=": return conditionRegVal >= conditionVal;
			case ">" : return conditionRegVal >  conditionVal;
			case "<" : return conditionRegVal <  conditionVal;
			case "!=": return conditionRegVal != conditionVal;
			default: return false;
		}
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
