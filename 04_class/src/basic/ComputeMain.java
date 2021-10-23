package basic;

public class ComputeMain {

	public static void main(String[] args) {
	System.out.print("x\ty\tsum\tsub\tmul\tdiv");
		
	Compute aa = new Compute();
	aa.setX(320);
	aa.setY(258);
	aa.calc();
	
	System.out.println();
	System.out.print(aa.getX()+"\t"+aa.getY()
					+"\t"+aa.getSum()
					+"\t"+aa.getSub()
					+"\t"+aa.getMul()
					+"\t"+String.format("%.2f", aa.getDiv()));
	
	Compute bb = new Compute();
	bb.setX(236);
	bb.setY(125);
	bb.calc();
	
	System.out.println();
	System.out.print(bb.getX()+"\t"+bb.getY()
					+"\t"+bb.getSum()
					+"\t"+bb.getSub()
					+"\t"+bb.getMul()
					+"\t"+String.format("%.2f", bb.getDiv()));
	
	Compute cc = new Compute();
	cc.setX(539);
	cc.setY(327);
	cc.calc();
	
	System.out.println();
	System.out.print(cc.getX()+"\t"+cc.getY()
					+"\t"+cc.getSum()
					+"\t"+cc.getSub()
					+"\t"+cc.getMul()
					+"\t"+String.format("%.2f", cc.getDiv()));
	System.out.println();
		
	}
}
