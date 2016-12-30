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

public class InsertionSort
{

   public static void main(String[] args)
   {
      InsertionSort mbs = new InsertionSort();
      int[] arr = {10, 1, 8, 2, 4, 6, 5, 1};
      mbs.sort(arr);
      System.out.println(" Sorted Array: " + Arrays.toString(arr));
      int[] arr1 = {432, 900, 6, 34, 78, 123};
      mbs.sort(arr1);
      System.out.println(" Sorted Array: " + Arrays.toString(arr1));
   }

   private void sort(int[] arr)
   {
      for (int i = 1; i < arr.length; i++)
      {
         // select a number to be inserted in the sorted array which is on the left side
         int valueTobeInserted = arr[i];
         int j = i;

         // Run a loop from 0 upto ith position and insert the number at right position
         while (j > 0)
         {
            if (arr[j - 1] > valueTobeInserted)
            {
               arr[j] = arr[j - 1];
               j--;
            }
            else
            {
               break;
            }
         }

         arr[j] = valueTobeInserted;

         System.out.println(" Pass " + i + ": " + Arrays.toString(arr));

      }
   }
}
