# Exercises

## Chapter 11. Learning to write Recursive

The following exercises provide you with the opportunity to practice with recursion. The solutions
of these exercises are found the section Chapter 11, on page 448

1. Use recursion to write a function that accepts and array of strings and returns the total number
   of characters across all the strings. For example, if the input array
   is ```["ab", "c", "def","ghij"]```, the output should be ``10`` since there are 10 characters in
   total
2. Use recursion to write a function that accepts an array of numbers and returns a new array
   containing just the even numbers.
3. There are a numerical sequence known as "Triangular Numbers". The pattern begins as
   1,3,6,10,15,21 and continues onward wit the Nth number in the pattern, which is N plus the
   previous number. For example, the 7th number in the sequence is 29, since it's 7 (which is N)
   plus 21 (the previous number). Write a function that accepts a number for N and returns the
   correct number from the series. That is, if the function was passed the number 7, the function
   would return 28.
4. Use recursion to write a function that accepts a string and returns the first index that contains
   the character "x". For example, the string "abcdefghijklmnopqrstuvwzyz" has an "x" at index 23. To
   keep things simple, assume the string definitely has at least one "x".