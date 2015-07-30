package zwb.cn.eventbus;


public final class EventBusManager {

	private static final EventBus EVENT_BUS = new EventBus();
	
	public static EventBus getInstance() {
		return EVENT_BUS;
	}
	
	
}
