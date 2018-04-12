package vn.quantda.example.osgi.eventadmin.eventtutorial.handler;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class MyEventHandler implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		System.out.println("test event received..");
        System.out.println("handle event start--" + event);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

	}

}
