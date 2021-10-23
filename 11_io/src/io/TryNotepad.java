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

public class TryNotepad extends JFrame implements ActionListener{ // �޸��常���
	private JTextArea area;
	private MenuPane menu; // ������(container)�� menubar(component)�� �־��ֱ�
	private File file; // �ʵ忡���� �⺻���� �ʱ�ȭ ��
	
	public TryNotepad() {
		area = new JTextArea();
		area.setFont(new Font("���ü", Font.BOLD, 20));
		JScrollPane scroll = new JScrollPane(area); // ��ũ�ѹ� ���� - scroll���� area�ö� ��
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// ���ν�ũ�ѹٰ� �׻� ���ֵ��� ��Ģ ������ �� (���μ��� �� ���� / ���̰� ������� ��ũ�ѹ� ���̴°� �⺻������)
		
		menu = new MenuPane();
		this.setJMenuBar(menu); // �����ӿ� �޴����� ���ڴ� - add �Ⱦ��� �޼ҵ� �̿�
		
		this.add("Center", scroll); // area�� ǰ���ִ� scroll�� â�� ����� �ν���
		
		setBounds(800, 150, 500, 500);
		// setResizable(false);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  -- ����� �ᵵ ��
		
		//X�� ������ �� ���忩�� ���� ���� ���̾�α� ����(����������) - Y/N/C �ɼ�  
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int popup = JOptionPane.showConfirmDialog(TryNotepad.this, "�����Ͻðڽ��ϱ�?", "�޸���", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(popup == JOptionPane.YES_OPTION) { // ���� �� ����
					saveDialog();
					fileWrite();
					System.exit(0);
				}else if(popup == JOptionPane.NO_OPTION) {
					System.exit(0);
				}else if(popup == JOptionPane.CANCEL_OPTION) {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					// ���� �ʴ� ������ ���������� �ۿ� �ᵵ �� - ������ ���� ��ü�� ���� (����Ʈ������ HIDE)
				}
			}
		});
		
		// �̺�Ʈ
		menu.getNewM().addActionListener(this); // newM�� private�̴ϱ� getter���� ��������
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		
	} // ������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.getNewM()) { // ���θ����
			area.setText("");
		}else if(e.getSource()==menu.getOpenM()) { 
			// ���� ���̾�α� �˾�
			openDialog();
			// ���� ���� �о TextArea�� �ø��� - Input/OutputStream �̿�
			fileRead();
		}else if(e.getSource()==menu.getSaveM()) { 
			// STEP ���� - ���ε�
			saveDialog();
			fileWrite();
		}else if(e.getSource()==menu.getExitM()) { // ����
			// ���忩�� ���� ���̾�α� ���� - ( �˾���ġ, �� �޽���, ���̾�α� ����, ��ư�ɼ�, �����ܿɼ�)
			// �˾���ġ�� null�� �ϸ� �����Ӱ� �����ϰ� �˾� / this�� �ϸ� ������ ���� �˾�
			// �ɼǼ������� int������ ���ϵ�
			int result = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?", "�޸���", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION) { // �����ϰ� ����
					saveDialog();
					fileWrite();
					System.exit(0);
				} else if(result==JOptionPane.NO_OPTION) { // ������ϰ� ����
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
		JOptionPane.showMessageDialog(this, file); // ������ ������ �� ���ϸ� �˾�
	} // saveDialog()
	
	private void fileWrite() { // BufferedWriter �̿��� ó��
		// ����� Reader�� ������, �Է��� Writer�� �ϴ°��� ������
		String data = null;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
			data = area.getText();
			
			bw.write(data); // ���Ϸ� ����
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// -- true�� ���̸� ������� ���Ͽ� �ٽ� ������ ���, �������� �ڿ� append��
		// -- false�� ���̸� ������� ���̷� �ٽ� ������ ���, �������� ����� ���� ������� (default����)
		//BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));

		/*
		// outputStream ���� ���� ���� ������ ��������
		if(file != null) { 
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(area.getText());
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "���� �Ϸ�");
		}
		 */
		
	} // fileWrite()

	// ������ return�ϴ� �޼ҵ�� ��Ƽ�, fileRead�� ���޹��� ���� ���� -- �ʵ忡 File���� �ʰ�
	private void openDialog() { 
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);	// ����-�ݱ� �ɼ� ����� �޾��ֱ�
		
		if(result == JFileChooser.APPROVE_OPTION) { // ���� ����
			file = chooser.getSelectedFile(); // getSelectedFiles()�� ���� ������ �����Ұ��
		}
		
		// file�״�� ����ϸ� ������ �ּҰ��� ��µǾ�� �� 
		// BUT, File��ü�� �⺻���� toString() �ɷ��ֱ� ������ ���\���ϸ� �������� ��µ�
		JOptionPane.showMessageDialog(this, file); 
	}
	
	private void fileRead() {
		if(file == null) return; // ���� �޴� ������ �ƹ��͵� �ȴ����� ����ؼ� file=null�ΰ�� ���� ����
		area.setText(""); // ���� �б� ���� �ʱ�ȭ�ؼ� ������ �� ����� �о����
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while( (line = br.readLine()) != null) { // 1�� = ����ĥ������ ( ���ʹ� ���x )
				// area.setText(line); -- �о�� ������ ���پ� TextArea�� �������
				area.append(line+"\n"); // �о�� ���� ���پ� �ճ��� �ڷ� �̾����
			}
			br.close();
		} catch (IOException e) { // �θ� Exception���� �ѹ��� ����ó��
			e.printStackTrace();
		}
	}

//----------------------------------------------------------------------
	public static void main(String[] args) {
		new TryNotepad();

	} // main


}
