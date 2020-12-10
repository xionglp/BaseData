package 栈;

import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {
	private static HashMap<Character, Character> map =  new HashMap<Character, Character>();
	
	static {
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	}
	
	public boolean isValid4(String s) {
		// 左字符入栈，右字符出栈（如果栈是空的则返回false）
		// 不匹配则false， 
		// 最后都匹配完了， 栈不为空返回false
		Stack<Character> stack = new Stack<>();
		int strLength = s.length();
		for (int i = 0; i < strLength; i++) {
			char strChar = s.charAt(i);
			if (strChar == '(' || strChar == '{' || strChar == '[') {
				stack.push(strChar);
			}  else {
				if (stack.isEmpty()) return false;
				char leftStr = stack.pop();
				if (leftStr == '(' && strChar != ')') return false;
				if (leftStr == '{' && strChar != '}') return false;
				if (leftStr == '[' && strChar != ']') return false;
			}
		}
		return stack.isEmpty();
    }

	// [{()}]
	// 遍历字符串，遇见左字符入栈，遇见右字符，将左字符出栈与之做匹配
	// 1、栈是空的， 返回false
	// 2、栈不为空， 左右字符不匹配 返回false
	// 3、左右字符相匹配，则继续匹配，所有字符都匹配完毕，（栈不为空，返回false）
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i <len ; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) { // 左字符
				stack.push(c);
			} else { // 右字符
				if (stack.isEmpty()) return false;
				char left = stack.pop(); // 出栈
				if (c != map.get(left)) return false;
			}
		}
		return stack.isEmpty();
    }
	
	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i <len ; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') { // 左字符
				stack.push(c);
			} else { // 右字符
				if (stack.isEmpty()) return false;
				char left = stack.pop(); // 出栈
				if (left == '(' && c != ')') return false;
				if (left == '[' && c != ']') return false;
				if (left == '{' && c != '}') return false;
			}
		}
		return stack.isEmpty();
    }

	// 耗性能
	public boolean isValid2(String s) {
		// [{()}]
		while (s.contains("{}") || s.contains("[]") || s.contains("()") ) {
			s = s.replace("{}", "");
			s = s.replace("[]", "");
			s = s.replace("()", "");
		}
		return s.isEmpty();
    }

}
