/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.quantda.example.osgi.eventadmin.eventtutorial;

import java.util.HashMap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;

public class Activator implements BundleActivator {

	private BundleContext context;
	boolean flag = true;
	private ServiceReference<?> serviceRef;
	EventAdmin eventAdmin = null;
	HashMap<String, Object> properties = null;
	Event event = null;
	
	
    public void start(BundleContext context) throws Exception {
        System.out.println("Starting the bundle");
        this.context = context;
        serviceRef = this.context.getServiceReference(EventAdmin.class.getName());
        if (serviceRef == null) {
        	throw new Exception("Failed to obtain EventAdmin service reference!");
        }
        eventAdmin = (EventAdmin) this.context.getService(serviceRef);
        
        if (eventAdmin == null) {
        	throw new Exception("Failed to obtain EventAdmin service object!");
        }
        
        while (flag) {
        	if (eventAdmin != null) {
        		properties = new HashMap<>();
        		properties.put(EventConstants.BUNDLE_SYMBOLICNAME, "est.first");
        		//create event topic
        		event = new Event("my_osgi_test_event", properties);
        		eventAdmin.postEvent(event);
        		System.out.println("Send Event!");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {}
        	}
        }
        System.out.println("ds service registered..");
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}