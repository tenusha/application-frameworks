package test;

public class MyThread {

	public static void main(String[] args) {

		// 1
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(i);
				}
			}
		};

		// 2
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(i);
				}
			}
		});
				
		//java 8
		// 3
		Runnable r = () -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			}
		};
		
		Thread thread3 = new Thread(r);

		// java 8
		// 4
		Thread thread4 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			}
		});

		new Thread(task1).start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
