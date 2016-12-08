import java.util.Arrays;

/*******************************************************************************
 * Copyright (c) 2016 SunGard CSA LLC and others. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: SunGard CSA LLC - initial API and implementation and/or initial
 * documentation
 *******************************************************************************/

public class TestArrays
{

   public static void main(String[] args)
   {
      int[] numbers = {9,2,4,6,8};
      Arrays.sort(numbers);
      System.out.println(Arrays.binarySearch(numbers, 2));
      System.out.println(Arrays.binarySearch(numbers, 4));
      System.out.println(Arrays.binarySearch(numbers, 1));
      System.out.println(Arrays.binarySearch(numbers, 3));
      System.out.println(Arrays.binarySearch(numbers, 9));
   }

}
