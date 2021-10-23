package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

public class DrCanvas extends Canvas{ // canvas�� �ݵ�� ��ӹ޾� ���� - component
	private MsPaint msPaint;
	private Image bufferImage;
	private Graphics bufferG; // �������� �׸��׸��⵵�� ���
	
	public DrCanvas(MsPaint msPaint) { // ĵ������ �������
		
		this.setBackground(new Color(255, 202, 255));
		this.msPaint = msPaint; // MsPaint�� �ؽ�Ʈ�ʵ� ��ǥ�� �������� ���� 
	}
	
	// �޸𸮿��� ������ �׸��׸��� (���⼭�� �׷���, �׷���bufferimage�� ĵ������ paint�� ��������) - callback
	@Override
	public void update(Graphics g) { 
		Dimension d = this.getSize();
		if(bufferG == null) { // ��ó�� ���ѹ��� null�� - repaint()�ݺ��Ǹ� update<->paint �ݺ��ϴϱ�
			bufferImage = this.createImage(d.width, d.height); // ĵ����ũ��� �Ȱ���
			bufferG = bufferImage.getGraphics(); // �����̹��� �������� �׷��Ƚ� ����
		} // ��� �׸��� bufferG���� �׸���
		
		// ��ó�� ����, �ٽ� update()���� �� �����ܻ� �ȳ��� ȭ�� �����
		bufferG.setColor(this.getBackground()); // ���� ���������� �׷���, �ܻ󵤱�
		bufferG.fillRect(0,  0,  d.width, d.height);
		
		int x1, x2, y1, y2, z1, z2, x1_temp, y1_temp;
		// list�� ����ִ� dto���� �ϳ��� ������ ���� �׷��� �Ŀ� ���� ������ �׸���(for��)	
		for(ShapeDTO dto : msPaint.getList()) { // �׳� list�� private�̶� getter�̿�
			x1 = dto.getX1();
			x2 = dto.getX2();
			y1 = dto.getY1();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			Vector<Integer> vector = dto.getVector();
			
			switch(dto.getColor()) { // setForeground���� repaint�Ǿ �����Ÿ�
			case 0 :bufferG.setColor(Color.RED); break;
			case 1 :bufferG.setColor(Color.GREEN); break;
			case 2 :bufferG.setColor(Color.BLUE); break;
			case 3 :bufferG.setColor(Color.CYAN); break;
			case 4 :bufferG.setColor(Color.MAGENTA); break;
			}
			
			if(dto.isFill()) { // ä���� ����
				if(dto.getShape() == Shape.LINE) 
					bufferG.drawLine(x1, y1, x2, y2); 
				else if(dto.getShape() == Shape.CIRCLE) 
					bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Shape.RECT) 
					bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Shape.ROUNDRECT) 
					bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);		
				/*else if(dto.getShape() == Shape.PEN) {
					int i = 0;
					while(true) {
						if(vector.size()-4 == i) break;
						g.drawLine(vector.get(i), vector.get(i+1), vector.get(i+2), vector.get(i+3));
						i+=2;
					}
				}*/
				//    -- ������ ���
				else if(dto.getShape() == Shape.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
				
			}else { // �� ����
				if(dto.getShape() == Shape.LINE) 
					bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape() == Shape.CIRCLE) 
					bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Shape.RECT) 
					bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); 
				else if(dto.getShape() == Shape.ROUNDRECT)
					bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				/*else if(dto.getShape() == Shape.PEN) {
					int i = 0;
					while(true) {
						if(vector.size()-4 == i) break;
						g.drawLine(vector.get(i), vector.get(i+1), vector.get(i+2), vector.get(i+3));
						i+=2;
					}
				}*/
				//    -- ������ ���
				else if(dto.getShape() == Shape.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
				 
			}
			
		}
		
//--------------------------------------------------------------------------------
		// paint�޼ҵ�� Canvas���� �׸��� ���� - frame������ �׸� �� x
		// ��ǥ ���ͼ� ���õ� ����+���� ���� �׸� �� �ְ� ��
		// �̹� MsCanvas�� �����Ǿ��� ������ �ǻ���x DrCanvas(��)�����ϸ� �� ��������
		// MsPaint�� ������ private�̱� ������ �������� ���� getter�̿�
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		x1_temp = msPaint.getX1_temp();
		y1_temp = msPaint.getY1_temp();
		
		/*   --  �޺��ڽ����� ���õ� ���� ������  --
		// ���ڷ� ������ - getSelectedItem()�� Object������ �����⶧���� ����ȯ���ֱ�
		switch((String)msPaint.getCombo().getSelectedItem()) { 
		case "����" : this.setBackground(Color.RED); break;
		}
		*/
		
		switch(msPaint.getCombo().getSelectedIndex()) { // index��ȣ�� ������
		case 0 :bufferG.setColor(Color.RED); break;
		case 1 :bufferG.setColor(Color.GREEN); break;
		case 2 :bufferG.setColor(Color.BLUE); break;
		case 3 :bufferG.setColor(Color.CYAN); break;
		case 4 :bufferG.setColor(Color.MAGENTA); break;
		}
		
		// ���� �׸��� - JCheckBox t/f �� ���� ����orä�������� ����
		// is~()�� �������� return��
		if(msPaint.getFill().isSelected()) { // true�� ��� ä���� ����
			if(msPaint.getLine().isSelected()) 
				bufferG.drawLine(x1, y1, x2, y2); // ���� ä������ ������� ����
			else if(msPaint.getCircle().isSelected()) 
				// Math.abs() -- ���� ������ֱ�
				// Math.min(,) -- �� �� ���� ������ ���� ������ ����ֱ� / �������� ������Ű�� �ȵ�
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); // ���� �簢���� ����
			else if(msPaint.getRect().isSelected()) 
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); // fillRect(����x��ǥ, ����y��ǥ, �ʺ�, ����)�� ä�����簢��
			else if(msPaint.getRoundRect().isSelected()) 
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); // �ձٸ𼭸������� z������ ǥ�� (Ŭ���� �ձ׷���)
			//    -- ������ ���
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			
		} else { // false�� ��� �� ����
			if(msPaint.getLine().isSelected()) 
				bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected()) 
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected()) 
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); // drawRect(����x��ǥ, ����y��ǥ, �ʺ�, ����)�� ��簢��
			else if(msPaint.getRoundRect().isSelected()) 
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			//    -- ������ ���
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			 
		}
		paint(g); // ����Ʈ�� ����ȣ���ؼ� �׸��׸��ºκ� �ʼ�!!!!!!!!!!!!!!!!!!!
	} // update - ������۸�
	
	// paint�� bufferImage�� ĵ���� ���� ���⸸ �ϰ�, �����׸��׸���� �޸𸮿����� �׸�
	@Override
	public void paint(Graphics g) { // callback�޼ҵ��� - setVisible()�ϸ� ȣ���
		g.drawImage(bufferImage, 0, 0, this);
	} // paint
} // class
