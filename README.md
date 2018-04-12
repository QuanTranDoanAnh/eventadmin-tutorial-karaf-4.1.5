# EventAdmin Usage Tutorial in Karaf
This is a simple sample built for Apache Karaf 4.1.5 using OSGi Event Admin Service to communicate bundles.
We use Bundle Activator to initiate Event runs. Should consider using Blueprint or Declarative Service in the future.

## Overview
Communication between bundles in osgi can be done using EventAdmin. EventAdmin is an OSGi based Publisher-Subscriber pattern. 
After a Bundle publishes and publishes an event, another Bundle subscribes to the corresponding topic to communicate and use it. In the same communication mode, there is one eventbus in guava that can achieve the same effect, and the mq publish and subscribe are all the same, but the eventadmin service of osgi is not persistent in the communication process. Now we start between our osgi. Event event communication.

## Components
The sample code includes 2 Maven bundles for 2 OSGi bundles:
1. `eventtutorial`: Using Activator to post event every 5 seconds
2. `eventtutorial-consumer`: Using Activator to initiate an EventHandler which will listen to the Event posted by `eventtutorial` bundle and write log to the console.

## What we did to build code
From source folder run `mvn clean install`

## Install to Karaf
1. Start Karaf
2. From Karaf console, run `install -s mvn:vn.quantda.example.osgi.eventadmin/eventtutorial/1.0.0-SNAPSHOT`
3. From Karaf console, run `install -s mvn:vn.quantda.example.osgi.eventadmin/eventtutorial-consumer/1.0.0-SNAPSHOT`