package org.ashu.thymeleaf;

public class ThreadSafeSingleton implements SingletonService<Object> {

	private static volatile ThreadSafeSingleton instance;
	private static Object object;

	private ThreadSafeSingleton() {
	}
//
//	@Override
//	public <T> T getInstance() {
//		synchronized (object) {
//
//			if (null == instance) {
//				return new ThreadSafeSingleton();
//			}
//			return instance;
//		}
//	}

	@Override
	public Object getInstance() {
		synchronized (object) {
			if (null == instance) {
				return new ThreadSafeSingleton();
			}
			return instance;
		}

	}

}
