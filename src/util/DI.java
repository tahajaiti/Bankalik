package util;

import java.util.Map;
import java.util.HashMap;
import contract.IDIContainer;

public class DI implements IDIContainer {

	private Map<Class<?>, Object> instances = new HashMap<>();

	public <T> void register(Class<T> type, T instance) {
		instances.put(type, instance);
	}

	public <T> T resolve(Class<T> type) {
		T instance = (T) instances.get(type);

		if (instance == null) {
			throw new IllegalArgumentException("No registered instance found for type: " + type.getName());
		}

		return instance;

	}

}
