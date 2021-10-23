package collection;

import java.util.Stack;
import static java.lang.System.out; // �̷��� static�����ϸ� ��� �� ��������

public class StackMain { // stack�� ���Ͱ� �ݴ������ ��� (�������Էº��� ��� LIFO) - �Ѱ��� �����
						 // stack���� �Լ��� �ַ� ������

	public static void main(String[] args) {
		String[] groupA = {"���Ű��ź", "�����Ʈ", "����", "���ѹα�"};
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<groupA.length; i++) { // stack�� �Է� - push
			stack.push(groupA[i]);
		}

		while( ! stack.isEmpty()) { // stack���� ��� - pop
			out.println(stack.pop());
		}
	}

}
