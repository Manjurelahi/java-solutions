// Create & demonstrate user defined custom logger class using the Singleton design pattern

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

class SingletonLogger {
	private static volatile SingletonLogger singletonLogger = null;
	
	private SingletonLogger() {
	}
	
	public static SingletonLogger getInstance() {
		if (singletonLogger == null) {
			synchronized(SingletonLogger.class) {
				if (singletonLogger == null) {
					singletonLogger = new SingletonLogger();
				}
			}
		}		
		return singletonLogger;
	}

	private void log(String message) {
		System.out.println(message);		
	}
	
	public void info(String message) {
		log("INFO: "+message);
	}
	
	public void debug(String message) {
		log("DEBUG: "+message);
	}
	
	public void error(String message) {
		log("Error: "+message);
	}
}

public class SingletonLoggerDemo {
	public static SingletonLogger[] singletonLoggerObjects = new SingletonLogger[2];
	
	private static void logThreads(int threadIndex) {
		singletonLoggerObjects[threadIndex] = SingletonLogger.getInstance();
		singletonLoggerObjects[threadIndex].info(Thread.currentThread().getName());
		singletonLoggerObjects[threadIndex].debug(Thread.currentThread().getName());
		singletonLoggerObjects[threadIndex].error(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) throws Exception {		
		new Thread(() -> logThreads(0)).start();
		new Thread(() -> logThreads(1)).start();
		if ( Arrays.stream(singletonLoggerObjects).allMatch(object -> object == SingletonLogger.getInstance())) {
			System.out.println("All Singleton Logger objects are same");
		}
	}
}

/*
Output:
INFO: Thread-0
INFO: Thread-1
DEBUG: Thread-1
Error: Thread-1
DEBUG: Thread-0
Error: Thread-0
All Singleton Logger objects are same
*/