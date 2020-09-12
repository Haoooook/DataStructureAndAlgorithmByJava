package DataStructure.chapter2;

import java.util.Stack;

/**
 * #20 valid-parentheses 有效的括号
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author Damon
 * @create 2020-09-12 21:22
 */
public class ValidParentheses {

    /**
     * 用java.util.stack解决，
     * 思路：即把左半部分的( { [ 推入栈stack中
     * 然后拿输入的String s的每个字符去匹配stack弹出来的字符，只要不符合（）{} [ ]规则都为false
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topC = stack.pop();

                if (c == ')' && topC != '(')
                    return false;
                if (c == ']' && topC != '[')
                    return false;
                if (c == '}' && topC != '{')
                    return false;
            }
        }
        //最后运行到这如果栈里还有元素，说明没有匹配完即为不成功
        //最后运行到这如果栈咯没有元素了为空，说明全都匹配成功那么返true
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topC = stack.pop();

                if (c == ')' && topC != '(')
                    return false;
                if (c == ']' && topC != '[')
                    return false;
                if (c == '}' && topC != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid1("()[]{}"));
        System.out.println(isValid1("(]"));
        System.out.println(isValid1("([)]"));
        System.out.println(isValid1("{[]}"));

        System.out.println();

        System.out.println(isValid2("()[]{}"));
        System.out.println(isValid2("(]"));
        System.out.println(isValid2("([)]"));
        System.out.println(isValid2("{[]}"));

    }

}
