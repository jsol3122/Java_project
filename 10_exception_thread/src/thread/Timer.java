package thread;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer extends JFrame implements ActionListener, Runnable{
	private JLabel lb;
	private JButton StartBtn, StopBtn;
	private boolean onoff;
	private int count;
	
	public Timer() {
		lb = new JLabel("0", JLabel.CENTER);
		lb.setFont(new Font("���ü", Font.BOLD, 70));
		StartBtn = new JButton("����");
		StopBtn = new JButton("����");
		
		JPanel p = new JPanel(new GridLayout(2, 1, 5, 10));
		p.add(StartBtn);
		p.add(StopBtn);
		
		add("Center", lb);
		add("East", p);
		
		setTitle("Ÿ�̸�");
		setBounds(800, 150, 300, 200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		StartBtn.addActionListener(this);
		StopBtn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t;
		if(e.getSource()==StartBtn) { // ���� ������ ��
			StartBtn.setEnabled(false);
			StopBtn.setEnabled(true);
			t = new Thread(this); // �͸�inner���� �ƴϴϱ� �׳� this�ص� ��
			t.start();
			onoff = true;
		} else if(e.getSource()==StopBtn) { // ���� ������ ��
			StopBtn.setEnabled(false);
			StartBtn.setEnabled(true);
			t = null;
			onoff = false;
		}
		
	} // actionlistener
	
	@Override
	public void run() {
		while(onoff) {
			count++;
			lb.setText(count+"");
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(count>=50) {
				count = 0; // 50������ ���� 
				StartBtn.setEnabled(true); // 50���� �� �������� ���۹�ưȰ��ȭ + �����ư��Ȱ��ȭ
				StopBtn.setEnabled(false);
				break;
			}
		}
	} // run
	
//--------------run()�� while��� for�� ����� ���-------------------
	/*
	 @Override
	   public void run() {
	      int i;
	      
	      for(i=count; i<=50; i++) {
	         label.setText(i+"");
	               
	         if( ! onoff) {
	            count = i;
	            break;
	         }
	            
	         
	         try {
	            Thread.sleep(100);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }//for
	      
	      if(i>=50) {
	         count=0;
	         
	         startBtn.setEnabled(true);
	         stopBtn.setEnabled(false);
	      }
	   }
	*/
//---------------------------------------------------------------
	public static void main(String[] args) {
		new Timer();

	}

}
