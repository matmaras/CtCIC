package joinexample;

public class JoinExample {

	private int counter = 0;
	
	public static void main (String[] args) {
		JoinExample sync = new JoinExample();
		sync.counter();
	}
	
	private void counter() {
		
		Runnable count = () -> {
			for (int i = 0; i < 1000; i++) {
				counter++;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		System.out.println("first Thread");
		Thread firstThread = new Thread(count);
		firstThread.start();
		
		try {
			System.out.println("Join 1");
			firstThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number " + counter);
		
		System.out.println("second Thread");
		Thread secondThread = new Thread(count);
		secondThread.start();
		
		try {
			System.out.println("Join 2");
			secondThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number " + counter);
	}
}
