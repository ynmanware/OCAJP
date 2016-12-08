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

import java.util.Map;
import java.util.stream.Stream;

public class TEst
{
   public static void main(String[] args)
   {
      Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
   }
}
