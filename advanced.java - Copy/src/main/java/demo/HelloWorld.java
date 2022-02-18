package demo;

public class HelloWorld {
	public String hi(String name) {
		return "Hello " + name;
	}
	
	// มันคือ Test อย่างหนึ่ง แต่เป็น Manual Test
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorld();
		String result = helloWorld.hi("Boat");
		System.out.println(result);
	}
}
