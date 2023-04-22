# Exercises

## Chapter 13. Recursive algorithms for speed

The following exercises provide you withe opportunity to practice with fast sorting. The solutions
to these exercises are found in the section, Chapter 13, on page 451.

1. Given an array of positive numbers, write a function that returns the greatest product of any
   three numbers. The approach of using three nested loops would clock in at O(N<sup>3</sup>), which
   is very
   slow. Use sorting to implement the function in a way that it computes at O(N log N) speed. (There
   are even faster implementations, but we're focusing on using sorting as a technique to make code
   faster.)

   <br/>
2. The following function finds the "missing number" from an array of integers. That is, the array
   is expected to have all integers from 0 up to the array's length, but one is missing. As
   examples, the array, [5,2,4,1,0] is missing the number 3, and the array, [9,3,2,5,6,7,1,0,4] is
   missing the number 8.

   <br/>
   Here is an implementation that is O(N<sup>3</sup>)(the ``includes`` method alone is already O(N),
   since the computer needs to search the entire array to find n)

```
function findMissingNumber(array) {
   for (let i = 0; i < array.length; i ++){
      if(!array.includes(i)){
         return i;
      }
   }
   // If all numbers are present
   return null;
```

Use sorting to write a new implementation of this function that only takes O(N log N). (There are
even faster implementations, but we're focusing on using sorting as a technique to make code faster)