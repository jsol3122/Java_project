package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueMain { // FIFO구조 - 들어간 순서대로 출력

	public static void main(String[] args) {
		String[] item = {"소나타", "렉스톤", "제규어"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n); // 요소추가 (입력) - offer
		
		out.println("q의 크기 : "+q.size()+"\n");
		
		String data = "";
		
		while((data=q.poll()) != null) { // 출력 - poll (자체함수 있으니까 iterator 안씀)
			out.println(data+" 삭제!");
			out.println("q의 크기 : "+q.size()+"\n");
		}

	}

}
