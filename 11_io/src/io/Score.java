package io;

import javax.swing.table.DefaultTableModel;

public interface Score {

	public void input(ScoreDTO dto);
	
	public void print(DefaultTableModel model);	// 출력에 쓸 추상메소드 생성

	public void search(DefaultTableModel model);

	public void tot_desc();

	public void save();

	public void load();
	
	
	
}
