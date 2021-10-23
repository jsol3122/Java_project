package io;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPane extends JMenuBar{ // component�̱� ������ container�� �ʿ���
	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;

	public JMenu getFileM() {
		return fileM;
	}

	public JMenu getEditM() {
		return editM;
	}

	public JMenu getViewM() {
		return viewM;
	}

	public JMenuItem getNewM() {
		return newM;
	}

	public JMenuItem getOpenM() {
		return openM;
	}

	public JMenuItem getSaveM() {
		return saveM;
	}

	public JMenuItem getExitM() {
		return exitM;
	}

	public JMenuItem getCutM() {
		return cutM;
	}

	public JMenuItem getCopyM() {
		return copyM;
	}

	public JMenuItem getPasteM() {
		return pasteM;
	}

	public MenuPane() {
		fileM = new JMenu("����");
		editM = new JMenu("����");
		viewM = new JMenu("����");
		
		newM = new JMenuItem("���θ����");
		openM = new JMenuItem("����");
		saveM = new JMenuItem("����");
		exitM = new JMenuItem("����");
		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		cutM = new JMenuItem("�߶󳻱�");
		copyM = new JMenuItem("����");
		pasteM = new JMenuItem("�ٿ��ֱ�");
		editM.add(cutM);
		editM.add(copyM);
		editM.add(pasteM);
		
		add(fileM);
		add(editM);
		add(viewM);
	}
}
