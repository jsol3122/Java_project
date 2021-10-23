package io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// 여러개의 구현용 ScoreImpl을 만들어서 Score에서 상속받아 쓸 수도 있음
public class ScoreImpl implements Score{ // Service클래스 역할
	private List<ScoreDTO> list;
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
	} // 생성자
	
	// Score에서 만들어진 추상메소드를 구현하기 위한 메소드들 생성
	
	@Override
	public void input(ScoreDTO dto) {
		list.add(dto);
		JOptionPane.showMessageDialog(null, "등록 완료"); // 여기에는 프레임없어서 this못함
	} // input()
	
	@Override
	public void print(DefaultTableModel model) { // model이 가는게 아니라 model의 주소값가져옴
		model.setRowCount(0); // model안의 내용 초기화 - 두번째입력시 1번내용+2번내용 출력되는거 방지
		
		for(ScoreDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor()+""); // 숫자형 문자열로 변환
			v.add(dto.getEng()+"");
			v.add(dto.getMath()+"");
			v.add(dto.getTot()+"");
			v.add(String.format("%.2f", dto.getAvg())); // 소수점 둘째자리까지 표시
			
			model.addRow(v);			
		}
		
	} // print()

	@Override
	public void search(DefaultTableModel model) {
		String hak = JOptionPane.showInputDialog(null, "찾으려는 학생의 학번을 입력하시오");
		// 바로취소버튼 누르기 + 아무것도안쓰고 검색누르기 두가지 상황 설정
		if(hak == null || hak.length() == 0) return;
		
		for(ScoreDTO dto : list) {
			if(dto.getHak().equals(hak)) {
				model.setRowCount(0);
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak());
				v.add(dto.getName());
				v.add(dto.getKor()+""); 
				v.add(dto.getEng()+"");
				v.add(dto.getMath()+"");
				v.add(dto.getTot()+"");
				v.add(String.format("%.2f", dto.getAvg())); 
				
				model.addRow(v);	
				return;
			}
		} // for
		model.setRowCount(0);
		JOptionPane.showMessageDialog(null, "찾으시는 학번이 없습니다");
	} // search()

	@Override
	public void tot_desc() { // 파일안의 내용을 List에 넣고, 담겨진 list의 데이터를 내림차순
		Comparator<ScoreDTO> c = new Comparator<ScoreDTO>() {
			@Override
			public int compare(ScoreDTO o1, ScoreDTO o2) {
				if(o1.getTot() > o2.getTot()) return -1;
				else if(o1.getTot() == o2.getTot()) return 0;
				else return 1;
				
				// 이렇게 표현할 수도 있음
				// return o1.getTot() < o2.getTot() ? 1 : -1;
			}
		};
		Collections.sort(list, c);
	} // tot_desc()

	@Override
	public void save() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);
		
		File file=null;		
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		//---------------------------
		if(file == null) return; // 파일선택 안하고 취소누르면 그냥 나가기
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			
			for(ScoreDTO dto : list) { // 파일안으로 dto속에 담아놓은 데이터들 넣기
				oos.writeObject(dto);
				//oos.writeInt(list.size()) -- 파일에 dto의 개수 미리 저장해놓음 [ 방법2 ]
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // save()

	@Override
	public void load() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			
			File file = chooser.getSelectedFile();
			if(file == null) return;
		
			list.clear(); // 기존에 출력되어있는 내용 다 지우고 새로 파일 읽어와서 출력
			try { //DTO가 직렬화걸려있으니 쪼개서 입출력 가능
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				
				// ---- 방법 1 ----
				while(true) { // dto갯수만큼 반복해서 읽어오기
					try {
					// readObject가 객체단위로 저장했어서, 객체단위로 읽어오기 때문에, 하나씩 다음 인덱스의 dto를 읽어옴
					// 파일오프셋(지정자)가 기본으로 존재하기 때문
						ScoreDTO dto = (ScoreDTO)ois.readObject();
						list.add(dto);
					} catch(EOFException e) { // 파일끝 오류 발생하면 break하도록 설정
						// End Of File Exception
						break;
					}
				}
				
				/*  ---- 방법 2 ---- : 입력할 때 ArrayList에 담겨있는 ScoreDTO의 개수 저장
				int size = ois.readInt(); // 아까 파일에 저장해놓은 길이 불러오기
				for(int i=0; i<size; i++){
					ScoreDTO dto = (ScoreDTO)ois.readObject();
					list.add(dto);
				}
				*/
				
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // if
	} // load()
	
}
