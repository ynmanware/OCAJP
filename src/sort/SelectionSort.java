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

public class SelectionSort
{

   public static void main(String[] args)
   {
      SelectionSort mbs = new SelectionSort();
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

         // select/find the smallest element in the rest of the array and swap it with the one
         // at ith position
         int smallestNumber = arr[i];
         int indexOfSmallestNumber = i;
         for (int j = i + 1; j < arr.length; j++)
         {
            if (arr[j] < smallestNumber)
            {
               indexOfSmallestNumber = j;
               smallestNumber = arr[j];
            }
         }
         
         arr[indexOfSmallestNumber] = arr[i];
         arr[i] = smallestNumber;

         System.out.println(" Pass " + i + ": " + Arrays.toString(arr));

      }
   }
}
