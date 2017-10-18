package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	
	public static void main(String[] args) {
		
		List<String> tasksToDo = new ArrayList<>();
		tasksToDo.add("Cleaning");
		tasksToDo.add("Paperwork");
		tasksToDo.add("Building");
		tasksToDo.add("Programming");
		tasksToDo.add("Cooking");
		tasksToDo.add("Doing documentation");
		tasksToDo.add("Duping");
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(String task : tasksToDo) {
			executor.submit(new Task(task));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All jobs done");
	}
}