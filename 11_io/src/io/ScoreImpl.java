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

// �������� ������ ScoreImpl�� ���� Score���� ��ӹ޾� �� ���� ����
public class ScoreImpl implements Score{ // ServiceŬ���� ����
	private List<ScoreDTO> list;
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
	} // ������
	
	// Score���� ������� �߻�޼ҵ带 �����ϱ� ���� �޼ҵ�� ����
	
	@Override
	public void input(ScoreDTO dto) {
		list.add(dto);
		JOptionPane.showMessageDialog(null, "��� �Ϸ�"); // ���⿡�� �����Ӿ�� this����
	} // input()
	
	@Override
	public void print(DefaultTableModel model) { // model�� ���°� �ƴ϶� model�� �ּҰ�������
		model.setRowCount(0); // model���� ���� �ʱ�ȭ - �ι�°�Է½� 1������+2������ ��µǴ°� ����
		
		for(ScoreDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor()+""); // ������ ���ڿ��� ��ȯ
			v.add(dto.getEng()+"");
			v.add(dto.getMath()+"");
			v.add(dto.getTot()+"");
			v.add(String.format("%.2f", dto.getAvg())); // �Ҽ��� ��°�ڸ����� ǥ��
			
			model.addRow(v);			
		}
		
	} // print()

	@Override
	public void search(DefaultTableModel model) {
		String hak = JOptionPane.showInputDialog(null, "ã������ �л��� �й��� �Է��Ͻÿ�");
		// �ٷ���ҹ�ư ������ + �ƹ��͵��Ⱦ��� �˻������� �ΰ��� ��Ȳ ����
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
		JOptionPane.showMessageDialog(null, "ã���ô� �й��� �����ϴ�");
	} // search()

	@Override
	public void tot_desc() { // ���Ͼ��� ������ List�� �ְ�, ����� list�� �����͸� ��������
		Comparator<ScoreDTO> c = new Comparator<ScoreDTO>() {
			@Override
			public int compare(ScoreDTO o1, ScoreDTO o2) {
				if(o1.getTot() > o2.getTot()) return -1;
				else if(o1.getTot() == o2.getTot()) return 0;
				else return 1;
				
				// �̷��� ǥ���� ���� ����
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
		if(file == null) return; // ���ϼ��� ���ϰ� ��Ҵ����� �׳� ������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			
			for(ScoreDTO dto : list) { // ���Ͼ����� dto�ӿ� ��Ƴ��� �����͵� �ֱ�
				oos.writeObject(dto);
				//oos.writeInt(list.size()) -- ���Ͽ� dto�� ���� �̸� �����س��� [ ���2 ]
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
		
			list.clear(); // ������ ��µǾ��ִ� ���� �� ����� ���� ���� �о�ͼ� ���
			try { //DTO�� ����ȭ�ɷ������� �ɰ��� ����� ����
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				
				// ---- ��� 1 ----
				while(true) { // dto������ŭ �ݺ��ؼ� �о����
					try {
					// readObject�� ��ü������ �����߾, ��ü������ �о���� ������, �ϳ��� ���� �ε����� dto�� �о��
					// ���Ͽ�����(������)�� �⺻���� �����ϱ� ����
						ScoreDTO dto = (ScoreDTO)ois.readObject();
						list.add(dto);
					} catch(EOFException e) { // ���ϳ� ���� �߻��ϸ� break�ϵ��� ����
						// End Of File Exception
						break;
					}
				}
				
				/*  ---- ��� 2 ---- : �Է��� �� ArrayList�� ����ִ� ScoreDTO�� ���� ����
				int size = ois.readInt(); // �Ʊ� ���Ͽ� �����س��� ���� �ҷ�����
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
