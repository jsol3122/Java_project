package io;

import javax.swing.table.DefaultTableModel;

public interface Score {

	public void input(ScoreDTO dto);
	
	public void print(DefaultTableModel model);	// ��¿� �� �߻�޼ҵ� ����

	public void search(DefaultTableModel model);

	public void tot_desc();

	public void save();

	public void load();
	
	
	
}
