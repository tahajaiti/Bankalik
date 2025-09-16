package contract;

public interface IDIContainer {
	<T> void register(Class<T> type, T instance);

	<T> T resolve(Class<T> type);
}
