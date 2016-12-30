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
package search;

public class BinarySearch
{
   public static void main(String[] args)
   {
      BinarySearch mbs = new BinarySearch();
      int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
      System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
      int[] arr1 = {6, 34, 78, 123, 432, 900};
      System.out.println("Key 432's position: " + mbs.binarySearch(arr1, 432));
   }

   private int binarySearch(int[] arr, int valueToSearched)
   {
      int start = 0;
      int end = arr.length - 1;

      while (start <= end)
      {
         int mid = (start + end) / 2;

         if (valueToSearched == arr[mid])
         {
            return mid;
         }
         else
         {
            if (valueToSearched < arr[mid])
            {
               end = mid - 1;
            }
            else
            {
               start = mid + 1;
            }
         }
      }
      return -1;
   }

}
