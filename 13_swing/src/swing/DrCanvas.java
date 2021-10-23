package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

public class DrCanvas extends Canvas{ // canvas는 반드시 상속받아 쓰기 - component
	private MsPaint msPaint;
	private Image bufferImage;
	private Graphics bufferG; // 버퍼전용 그림그리기도구 잡기
	
	public DrCanvas(MsPaint msPaint) { // 캔버스색 연보라색
		
		this.setBackground(new Color(255, 202, 255));
		this.msPaint = msPaint; // MsPaint의 텍스트필드 좌표값 가져오기 위해 
	}
	
	// 메모리에서 실제로 그림그리기 (여기서만 그려서, 그려진bufferimage를 캔버스에 paint가 덮을것임) - callback
	@Override
	public void update(Graphics g) { 
		Dimension d = this.getSize();
		if(bufferG == null) { // 맨처음 딱한번만 null임 - repaint()반복되며 update<->paint 반복하니까
			bufferImage = this.createImage(d.width, d.height); // 캔버스크기와 똑같게
			bufferG = bufferImage.getGraphics(); // 버퍼이미지 전용으로 그래픽스 설정
		} // 모든 그림은 bufferG에서 그리기
		
		// 맨처음 제외, 다시 update()들어올 때 도형잔상 안남게 화면 지우기
		bufferG.setColor(this.getBackground()); // 같은 바탕색으로 그려서, 잔상덮기
		bufferG.fillRect(0,  0,  d.width, d.height);
		
		int x1, x2, y1, y2, z1, z2, x1_temp, y1_temp;
		// list에 담겨있는 dto들을 하나씩 꺼내서 먼저 그려준 후에 새로 도형을 그리기(for문)	
		for(ShapeDTO dto : msPaint.getList()) { // 그냥 list는 private이라 getter이용
			x1 = dto.getX1();
			x2 = dto.getX2();
			y1 = dto.getY1();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			Vector<Integer> vector = dto.getVector();
			
			switch(dto.getColor()) { // setForeground쓰면 repaint되어서 깜빡거림
			case 0 :bufferG.setColor(Color.RED); break;
			case 1 :bufferG.setColor(Color.GREEN); break;
			case 2 :bufferG.setColor(Color.BLUE); break;
			case 3 :bufferG.setColor(Color.CYAN); break;
			case 4 :bufferG.setColor(Color.MAGENTA); break;
			}
			
			if(dto.isFill()) { // 채워진 도형
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
				//    -- 선생님 방법
				else if(dto.getShape() == Shape.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
				
			}else { // 빈 도형
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
				//    -- 선생님 방법
				else if(dto.getShape() == Shape.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
				 
			}
			
		}
		
//--------------------------------------------------------------------------------
		// paint메소드는 Canvas위에 그리는 것임 - frame위에는 그릴 수 x
		// 좌표 얻어와서 선택된 도형+색깔에 맞춰 그릴 수 있게 함
		// 이미 MsCanvas는 생성되었기 때문에 또생성x DrCanvas(값)생성하며 값 가져오기
		// MsPaint의 값들은 private이기 때문에 가져오기 위해 getter이용
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		x1_temp = msPaint.getX1_temp();
		y1_temp = msPaint.getY1_temp();
		
		/*   --  콤보박스에서 선택된 색깔 얻어오기  --
		// 글자로 얻어오기 - getSelectedItem()은 Object형으로 얻어오기때문에 형변환해주기
		switch((String)msPaint.getCombo().getSelectedItem()) { 
		case "빨강" : this.setBackground(Color.RED); break;
		}
		*/
		
		switch(msPaint.getCombo().getSelectedIndex()) { // index번호로 얻어오기
		case 0 :bufferG.setColor(Color.RED); break;
		case 1 :bufferG.setColor(Color.GREEN); break;
		case 2 :bufferG.setColor(Color.BLUE); break;
		case 3 :bufferG.setColor(Color.CYAN); break;
		case 4 :bufferG.setColor(Color.MAGENTA); break;
		}
		
		// 도형 그리기 - JCheckBox t/f 에 따라 빈도형or채워진도형 선택
		// is~()는 참거짓을 return함
		if(msPaint.getFill().isSelected()) { // true일 경우 채워진 도형
			if(msPaint.getLine().isSelected()) 
				bufferG.drawLine(x1, y1, x2, y2); // 선은 채워지고 비워지고 없음
			else if(msPaint.getCircle().isSelected()) 
				// Math.abs() -- 절댓값 만들어주기
				// Math.min(,) -- 둘 중 작은 값으로 도형 시작점 잡아주기 / 시작점을 고정시키면 안됨
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); // 원도 사각형과 동일
			else if(msPaint.getRect().isSelected()) 
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); // fillRect(시작x좌표, 시작y좌표, 너비, 높이)는 채워진사각형
			else if(msPaint.getRoundRect().isSelected()) 
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); // 둥근모서리정도를 z값으로 표시 (클수록 둥그렇다)
			//    -- 선생님 방법
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			
		} else { // false일 경우 빈 도형
			if(msPaint.getLine().isSelected()) 
				bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected()) 
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected()) 
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1)); // drawRect(시작x좌표, 시작y좌표, 너비, 높이)는 빈사각형
			else if(msPaint.getRoundRect().isSelected()) 
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			//    -- 선생님 방법
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			 
		}
		paint(g); // 페인트를 강제호출해서 그림그리는부분 필수!!!!!!!!!!!!!!!!!!!
	} // update - 더블버퍼링
	
	// paint는 bufferImage를 캔버스 위에 덮기만 하고, 실제그림그리기는 메모리에서만 그림
	@Override
	public void paint(Graphics g) { // callback메소드임 - setVisible()하면 호출됨
		g.drawImage(bufferImage, 0, 0, this);
	} // paint
} // class
