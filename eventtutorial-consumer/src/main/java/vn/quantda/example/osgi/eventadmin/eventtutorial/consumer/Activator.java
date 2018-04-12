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
package vn.quantda.example.osgi.eventadmin.eventtutorial.consumer;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import vn.quantda.example.osgi.eventadmin.eventtutorial.handler.MyEventHandler;

public class Activator implements BundleActivator {

	private ServiceReference sr;

    EventAdmin eventAdmin = null;

    HashMap properties = null;

    Event event = null;

    /**
     * event  topic
     */
    final static String[] topic = {"my_osgi_test_event"};

    ServiceRegistration registration = null;

    public void start(BundleContext context) throws Exception {
        System.out.println("activator4 start");
        Dictionary dict = new Hashtable();
        dict.put(EventConstants.EVENT_TOPIC, topic);
        EventHandler eventHandler = new MyEventHandler();
        //registering the eventHandler
        registration = context.registerService(EventHandler.class.getName(), eventHandler, dict);
        if (registration != null) {
            System.out.println("event handler registered.");
        }
    }

    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("event handler unregistered!");
    }

}