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
package sort;

import java.util.Arrays;

public class BubbleSort
{

   public static void main(String[] args)
   {
      BubbleSort mbs = new BubbleSort();
      int[] arr = {10, 1, 8, 2, 4, 6, 5, 1};
      mbs.sort(arr);
      System.out.println(" Sorted Array: " + Arrays.toString(arr));
      int[] arr1 = {432, 900, 6, 34, 78, 123};
      mbs.sort(arr1);
      System.out.println(" Sorted Array: " + Arrays.toString(arr1));
   }

   private void sort(int[] arr)
   {
      for (int i = 0; i < arr.length; i++)
      {
         // basically large number is going the right place with each pass
         // note that the pass is getting reduced with each increment of i
         for (int j = 0; j < (arr.length - i - 1); j++)
         {
            if (arr[j] > arr[j + 1])
            {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
         System.out.println(" Pass " + i + ": " + Arrays.toString(arr));
      }
   }
}
