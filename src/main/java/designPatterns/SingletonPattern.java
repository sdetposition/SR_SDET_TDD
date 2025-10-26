package designPatterns;

public class SingletonPattern {
	
	public static SingletonPattern driver;
	
	private SingletonPattern () {}
	
	public synchronized static SingletonPattern getSingleton() {
				
		if(driver == null) {
			driver = new SingletonPattern();
		}		
		return driver;
	}
}
