/*******************************************************************************
 * Copyright (c) 2016 SunGard CSA LLC and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	SunGard CSA LLC - initial API and implementation and/or initial documentation
 *******************************************************************************/
package stream;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CheckResults {
	private static int counter = 0;
	public static void main(String[] args) throws InterruptedException {

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Hello Zoo");
		service.scheduleAtFixedRate(task1,5,1,TimeUnit.SECONDS);;
	}
}
