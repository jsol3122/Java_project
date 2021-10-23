class CompTest5 
{
	public static void main(String[] args) 
	{
      int num1=0, num2=0;     
      boolean result;
      
      result = ( (num1+=10) < 0 && (num2+=10) > 0 );   // &&라서 앞에서 결과 났으니 뒤에것 수행안함 --> num2값변동x   
      System.out.println("result = "+result);      
      System.out.println("num1 = "+ num1 + " num2 = "+ num2);      
      System.out.println();
      
      result = ( (num1+=10) > 0 || (num2+=10) > 0 );   // ||라서 위와 동일 --> num2값 여전히 변동x
      System.out.println("result = "+result);
      System.out.println("num1 = "+ num1 + " num2 = "+ num2);

	}
}
