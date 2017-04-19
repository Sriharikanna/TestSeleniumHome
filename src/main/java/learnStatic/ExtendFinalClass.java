package learnStatic;

public class ExtendFinalClass extends LearnFinal {
	
	public void sam(){
		LearnFinal obj = new LearnFinal();
		System.out.println(obj.txt);
		obj.sample();
		sample();
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
