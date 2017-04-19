package learnStatic;

public class LearnStatic {

	public LearnStatic(){
		System.out.println("Constructor");
	}

	{
		System.out.println("empty");
	}
	public static void main(String[] args) {		

		LearnStatic obj = new LearnStatic();		
		System.out.println("Main Method");

	}
	static {
		System.out.println("Static 1");
	}

	static {
		System.out.println("Static 2");
	}



}
