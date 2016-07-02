package org.osanchezhuerta.eventscheduling.engine.soa.commons.util;

import org.osanchezhuerta.eventscheduling.engine.soa.commons.constants.EventSchedulingConstants;

public final class EventSchedulingPidUtil {
  public static String createPidName(String applicationName){
	  StringBuilder sbApplicationName = new StringBuilder();
	  sbApplicationName.append("./");
	  sbApplicationName.append(applicationName);
	  sbApplicationName.append(".");
	  sbApplicationName.append(EventSchedulingConstants.PID_EXTENSION);
	  return sbApplicationName.toString();
  }
}
