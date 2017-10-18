package threadpool;

public class Task implements Runnable {
	private String taskToDo;
	
	public Task(String taskToDo) {
		this.taskToDo = taskToDo;
	}

	@Override
	public void run() {
		System.out.println("Starting: " + taskToDo);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
