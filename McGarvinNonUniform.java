/**
 * Description: This program allows us to practice
 * predicting and verifying the impact of data "nature"
 * on the run-time of sorting algorithms. More specfically,
 * three different arrays are created using method calls.
 * One array is filled half with 0's and the other half with
 * 1's. The second array, half the data is 0's, half the 
 * remainder is 1's, half the remainder is 2's, and so forth.
 * the last array will be half 0's and half random numbers.
 * We will then calculate the elapsed time when running 
 * Insertion Sort and Selection Sort on these arrays, where
 * one array is a small size and the next is double the size.
 * Lastly, the doubling formula is applied to determine if our
 * hypothesis is correct.
 * 
 * Completion Time: 7 - 10 hours total
 *
 * @author Bradley McGarvin, Ruben Acuna
 *         
 * @version 04/01/2019
 */

import java.util.Random;

public class McGarvinNonUniform{

public static void main(String[] args) {

// Integer Arrays variables
Integer[] a;
Integer[] b;
Integer[] c;
Integer[] d;
Integer[] e;
Integer[] f;

Integer[] g;
Integer[] h;
Integer[] i;
Integer[] j;
Integer[] k;
Integer[] l;



// create smaller arrays and then call stopwatch
// on each and run SelectionSort.
a = nonUniformArray(10000);
b = nonUniformRemainderArray(10000);
c = nonUniformRandomArray(10000);

/*
//print unsorted arrays to check that arrays were created correctly.
for(int x = 0; x < a.length; x++){

   System.out.print(a[x] + ", ");
}
System.out.println();

for(int x = 0; x < b.length; x++){

   System.out.print(b[x] + ", ");
}
System.out.println();

for(int x = 0; x < c.length; x++){

   System.out.print(c[x] + ", ");
}
System.out.println();
*/


Stopwatch stopwatch = new Stopwatch();
SelectionSort.sort(a);
double timeA = stopwatch.elapsedTime();
//System.out.println("elapsed time selection sort size 2048 a: " + timeA);

Stopwatch stopwatch2 = new Stopwatch();
SelectionSort.sort(b);
double timeB = stopwatch2.elapsedTime();
//System.out.println("elapsed time selection sort size 2048 b: " + timeB);

Stopwatch stopwatch3 = new Stopwatch();
SelectionSort.sort(c);
double timeC = stopwatch3.elapsedTime();
//System.out.println("elapsed time selection sort size 2048 c: " + timeC);



// create smaller arrays and then call stopwatch 
// on each and run InsertionSort.  
d = nonUniformArray(10000);
e = nonUniformRemainderArray(10000);
f = nonUniformRandomArray(10000);


Stopwatch stopwatch4 = new Stopwatch();
InsertionSort.sort(d);
double timeD = stopwatch4.elapsedTime();
//System.out.println("elapsed time insetion sort size 2048 d: " + timeD);

Stopwatch stopwatch5 = new Stopwatch();
InsertionSort.sort(e);
double timeE = stopwatch5.elapsedTime();
//System.out.println("elapsed time insertion sort size 2048 e: " + timeE);

Stopwatch stopwatch6 = new Stopwatch();
InsertionSort.sort(f);
double timeF = stopwatch6.elapsedTime();
//System.out.println("elapsed time insertion sort size 2048 f: " + timeF);


// create larger arrays and then call stopwatc
// on each and run SelectionSort.
g = nonUniformArray(20000);
h = nonUniformRemainderArray(20000);
i = nonUniformRandomArray(20000);


Stopwatch stopwatch7 = new Stopwatch();
SelectionSort.sort(g);
double timeG = stopwatch7.elapsedTime();
//System.out.println("elapsed time selection sort size 4096 g: " + timeG);

Stopwatch stopwatch8 = new Stopwatch();
SelectionSort.sort(h);
double timeH = stopwatch8.elapsedTime();
//System.out.println("elapsed time selection sort size 4096 h: " + timeH);

Stopwatch stopwatch9 = new Stopwatch();
SelectionSort.sort(i);
double timeI = stopwatch9.elapsedTime();
//System.out.println("elapsed time selection sort size 4096 i: " + timeI);

// create larger arrays and call stopwatch
// on each and run InsertionSort.
j = nonUniformArray(20000);
k = nonUniformRemainderArray(20000);
l = nonUniformRandomArray(20000);


Stopwatch stopwatch10 = new Stopwatch();
InsertionSort.sort(j);
double timeJ = stopwatch10.elapsedTime();
//System.out.println("elapsed time insertion sort size 4096 g: " + timeJ);

Stopwatch stopwatch11 = new Stopwatch();
InsertionSort.sort(k);
double timeK = stopwatch11.elapsedTime();
//System.out.println("elapsed time insertion sort size 4096 h: " + timeK);

Stopwatch stopwatch12 = new Stopwatch();
InsertionSort.sort(l);
double timeL = stopwatch12.elapsedTime();
//System.out.println("elapsed time insertion sort size 4096 i: " + timeL);


// Calculate B value to test hypothesis and print values.
System.out.println("nonUniformArray Testing Data");
System.out.println("InsertionSort B Value: " + Math.log(timeJ/timeD));
System.out.println("SelectionSort B Value: " + Math.log(timeG/timeA) + "\n");

System.out.println("nonUniformRemainderArray Testing Data");
System.out.println("InsertionSort B Value: " + Math.log(timeK/timeE));
System.out.println("SelectionSort B Value: " + Math.log(timeH/timeB) + "\n");

System.out.println("nonUniformRandomArray Testing Data");
System.out.println("InsertionSort B Value: " + Math.log(timeL/timeF));
System.out.println("SelectionSort B Value: " + Math.log(timeI/timeC));

}

/**
 *
 * This method creates a nonUniform array where half array
 * is filled with zeros and the other half with ones.
 *
 * Hypothesis for size 2048: Insertion Sort - O(n^2). Insertion sort 
 * steps through the array one at a time and if the element stored 
 * in the index after the first is < previous index, it swaps them. 
 * Then we start over. Since we start over every time and this array
 * is randomized, even though we only deal with 0's and 1's, it will need
 * to still compare each element 1 at a time and the array may not be sorted
 * until the very last call. I believe it has the potential to be O(n) depending
 * on how the array is randomized.
 *
 * Hypothesis for size 4096: Insertion Sort - O(n^2) for the same reason above.
 *
 * Hypothesis for size 2048: Selection Sort - O(n^2) because selection sort
 * uses two for loops where the first goes from 0 to n and the second from 
 * 1 to n. Once an element is found that is less than the first index, it
 * swaps them and then moves on to the next index. Again we are only dealing
 * with 0's and 1's so this should be best case scenario which is O(n^2).
 *
 * Hypothesis for size 4096: Selection Sort - O(n^2) for he same reason above.
 *
 */
public static Integer[] nonUniformArray(int size){

   Integer[] array = new Integer[size];
   int halfArraySize = size/2;
   
   for(int i = 0; i < halfArraySize; i++){
      array[i] = 0;
   }
   
   for (int k = halfArraySize; k < size; k++){
      array[k] = 1;
   }
   
   arrayRandomizer(array);
   
   
   return array;   

}

/**
 *
 * This method creates a nonUniform array where half array
 * is filled with zeros, half the remainder is 1s, half the 
 * remainder is 2s, half the remainder is 3s, and so forth.
 *
 * Hypothesis for size 2048: Insertion Sort - O(n^2). Insertion sort 
 * Since Insertion Sort starts over every time and this array
 * is randomized, the array may not be sorted until the very last call. 
 * Same thing as the last method though, I believe it has the potential to be O(n) 
 * depending on how the array is randomized.
 *
 * Hypothesis for size 4096: Insertion Sort - O(n^2) for the same reason above.
 *
 * Hypothesis for size 2048: Selection Sort - O(n^2) because selection sort
 * uses two for loops where the first goes from 0 to n and the second from 
 * 1 to n. I believe the big-oh will always be O(n^2) no matter the size.
 *
 * Hypothesis for size 4096: Selection Sort - O(n^2) for he same reason above.
 *
 */
public static Integer[] nonUniformRemainderArray(int size){

   Integer[] array2 = new Integer[size];
   int halfArraySize = size/2;
   int divisor = 2;
   int count = 1;
   
   for(int i = 0; i < halfArraySize; i++){
      array2[i] = 0;
   }
   
   while(halfArraySize < size){   
      
      for(int k = halfArraySize; k < size - halfArraySize/divisor; k++){
         array2[k] = count;         
      }
      
      halfArraySize = (size - (halfArraySize/divisor));
      divisor++;
      count++;
           
   }
   
   arrayRandomizer(array2);
   
   return array2;
}
 
/**
 *
 * This method creates a nonUniform array where half array
 * is filled with zeros, and the half with random numbers
 *
 * Hypothesis for size 2048: Insertion Sort - O(n^2).  
 * Since Insertion Sort starts over every time and this array
 * is randomized, the array may not be sorted until the very last call. 
 * Same thing as the last method though, I believe it has the potential 
 * to be O(n) depending on how the array is randomized.
 *
 * Hypothesis for size 4096: Insertion Sort - O(n^2) for the same reason above.
 *
 * Hypothesis for size 2048: Selection Sort - O(n^2) because selection sort
 * uses two for loops where the first goes from 0 to n and the second from 
 * 1 to n. I believe the big-oh will always be O(n^2) no matter the size.
 *
 * Hypothesis for size 4096: Selection Sort - O(n^2) for he same reason above.
 *
 */
public static Integer[] nonUniformRandomArray(int size){

   Integer[] array3 = new Integer[size];
   int halfArraySize = size/2;
   
   // Create a Random class object
   Random randomNumber = new Random(1000000000);
   
   for(int i = 0; i < halfArraySize; i++){
      array3[i] = 0;
   }
   
   for (int k = halfArraySize; k < size; k++){
      int random = randomNumber.nextInt();
      array3[k] = random;
   }
   
   arrayRandomizer(array3);
   
   
   return array3;   

}
   

/**
 * This method is to help randomize the order of each array.
 *
 */ 
public static Integer[] arrayRandomizer(Integer[] array){

      int randomSpot;
      int placeHolder;
   // Create a Random class object
      Random randomNumber = new Random();
      
      
      for(int i = 0; i < array.length; i++){
         randomSpot = randomNumber.nextInt(array.length);
         
         placeHolder = array[i];
         array[i] = array[randomSpot];
         array[randomSpot] = placeHolder; 
      
      }
      
      return array;
      
}



}