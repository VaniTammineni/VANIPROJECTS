/**
 * 
 */
package com.faqs.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@Component
public class A2ZLogUtil {

	static Logger LOGGER = null;
	static {
		LOGGER  = Logger.getLogger("com.meeseva.paymentpg");
	}
	public static Logger getLOGGER() {
		return LOGGER;
	}
	public static void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}
	
}
