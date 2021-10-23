package io;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener{ // 메모장만들기
	private JTextArea area;
	private MenuPane menu; // 프레임(container)에 menubar(component)를 넣어주기
	private File file; // 필드에서는 기본으로 초기화 됨
	
	public TryNotepad() {
		area = new JTextArea();
		area.setFont(new Font("고딕체", Font.BOLD, 20));
		JScrollPane scroll = new JScrollPane(area); // 스크롤바 생성 - scroll위에 area올라간 것
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// 세로스크롤바가 항상 떠있도록 규칙 정해준 것 (가로세로 다 가능 / 길이가 길어져야 스크롤바 보이는게 기본설정임)
		
		menu = new MenuPane();
		this.setJMenuBar(menu); // 프레임에 메뉴값을 띄우겠다 - add 안쓰고 메소드 이용
		
		this.add("Center", scroll); // area를 품고있는 scroll을 창에 띄워야 인식함
		
		setBounds(800, 150, 500, 500);
		// setResizable(false);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  -- 여기다 써도 됨
		
		//X를 눌렀을 때 저장여부 묻고 종료 다이얼로그 생성(프레임위에) - Y/N/C 옵션  
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int popup = JOptionPane.showConfirmDialog(TryNotepad.this, "저장하시겠습니까?", "메모장", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(popup == JOptionPane.YES_OPTION) { // 저장 후 종료
					saveDialog();
					fileWrite();
					System.exit(0);
				}else if(popup == JOptionPane.NO_OPTION) {
					System.exit(0);
				}else if(popup == JOptionPane.CANCEL_OPTION) {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					// 숨지 않는 세팅을 윈도우어댑터 밖에 써도 됨 - 프레임 세팅 자체를 변경 (디폴트세팅은 HIDE)
				}
			}
		});
		
		// 이벤트
		menu.getNewM().addActionListener(this); // newM은 private이니까 getter만들어서 가져오기
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.getNewM()) { // 새로만들기
			area.setText("");
		}else if(e.getSource()==menu.getOpenM()) { 
			// 열기 다이얼로그 팝업
			openDialog();
			// 파일 내용 읽어서 TextArea에 올리기 - Input/OutputStream 이용
			fileRead();
		}else if(e.getSource()==menu.getSaveM()) { 
			// STEP 숙제 - 업로드
			saveDialog();
			fileWrite();
		}else if(e.getSource()==menu.getExitM()) { // 종료
			// 저장여부 묻는 다이얼로그 설정 - ( 팝업위치, 뜰 메시지, 다이얼로그 제목, 버튼옵션, 아이콘옵션)
			// 팝업위치를 null로 하면 프레임과 무관하게 팝업 / this로 하면 프레임 위에 팝업
			// 옵션선택지는 int형으로 리턴됨
			int result = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "메모장", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION) { // 저장하고 종료
					saveDialog();
					fileWrite();
					System.exit(0);
				} else if(result==JOptionPane.NO_OPTION) { // 저장안하고 종료
					System.exit(0);
				}
			// System.exit(0);
		}else if(e.getSource()==menu.getCutM()) { 
			area.cut();
		}else if(e.getSource()==menu.getCopyM()) { 
			area.copy();
		}else if(e.getSource()==menu.getPasteM()) { 
			area.paste();
		}
		
	}

	private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);

		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file); // 선택한 저장경로 및 파일명 팝업
	} // saveDialog()
	
	private void fileWrite() { // BufferedWriter 이용해 처리
		// 출력을 Reader로 했으면, 입력은 Writer로 하는것이 보편적
		String data = null;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
			data = area.getText();
			
			bw.write(data); // 파일로 저장
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// -- true를 붙이면 만들어진 파일에 다시 저장할 경우, 기존내용 뒤에 append됨
		// -- false를 붙이면 만들어진 파이레 다시 저장할 경우, 기존내용 지우고 새로 덮어쓰기함 (default설정)
		//BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));

		/*
		// outputStream 쓰면 파일 안의 내용이 깨져보임
		if(file != null) { 
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(area.getText());
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "저장 완료");
		}
		 */
		
	} // fileWrite()

	// 파일을 return하는 메소드로 잡아서, fileRead로 전달받을 수도 있음 -- 필드에 File잡지 않고
	private void openDialog() { 
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);	// 열기-닫기 옵션 결과값 받아주기
		
		if(result == JFileChooser.APPROVE_OPTION) { // 열기 선택
			file = chooser.getSelectedFile(); // getSelectedFiles()는 파일 여러개 선택할경우
		}
		
		// file그대로 출력하면 원래는 주소값이 출력되어야 함 
		// BUT, File객체는 기본으로 toString() 걸려있기 때문에 경로\파일명 형식으로 출력됨
		JOptionPane.showMessageDialog(this, file); 
	}
	
	private void fileRead() {
		if(file == null) return; // 열기 메뉴 누르고 아무것도 안누르고 취소해서 file=null인경우 에러 방지
		area.setText(""); // 파일 읽기 전에 초기화해서 기존값 다 지우고 읽어오기
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while( (line = br.readLine()) != null) { // 1줄 = 엔터칠때까지 ( 엔터는 출력x )
				// area.setText(line); -- 읽어온 내용을 한줄씩 TextArea에 덮어버림
				area.append(line+"\n"); // 읽어온 내용 한줄씩 앞내용 뒤로 이어써줌
			}
			br.close();
		} catch (IOException e) { // 부모 Exception으로 한번에 예외처리
			e.printStackTrace();
		}
	}

//----------------------------------------------------------------------
	public static void main(String[] args) {
		new TryNotepad();

	} // main


}
