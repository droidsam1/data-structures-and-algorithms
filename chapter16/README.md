# Exercises

## Chapter 16. Keeping Your Priorities Straight with Heaps

The following exercises provide you withe opportunity to practice with heaps. The
solutions to these exercises are found in the section, Chapter 16, on page 458.

1. Draw what the following heap would look like after we insert the value 11 into it:

```mermaid
graph TB;
A(( 10 )) --> B1(( 9 ))
A(( 10 )) --> B2(( 8 ))
B1(( 9 )) --> C1(( 6 ))
B1(( 9 )) --> C2(( 5 ))
C2(( 5 )) --> D3(( 3 ))
C1(( 6 )) --> D1(( 2 ))
C1(( 6 )) --> D2(( 1 ))
B2(( 8 )) --> C3(( 7 ))
B2(( 8 )) --> C4(( 4 ))
```

``R: ``

```mermaid
graph TB;
A(( 11 )) --> B1(( 9 ))
A(( 11 )) --> B2(( 8 ))
B1(( 10 )) --> C1(( 6 ))
B1(( 10 )) --> C2(( 9 ))
C2(( 9 )) --> D3(( 3 ))
C2(( 9 )) --> D4(( 5 ))
C1(( 6 )) --> D1(( 2 ))
C1(( 6 )) --> D2(( 1 ))
B2(( 8 )) --> C3(( 7 ))
B2(( 8 )) --> C4(( 4 ))
```

2. Draw what the previous heap would look like after we delete the root node

``R: ``

```mermaid
graph TB;
A(( 9 )) --> B1(( 6 ))
A(( 9 )) --> B2(( 8 ))
B1(( 6 )) --> C1(( 3 ))
B1(( 6 )) --> C2(( 5 ))
C1(( 3 )) --> D1(( 2 ))
C1(( 3 )) --> D2(( 1 ))
B2(( 8 )) --> C3(( 7 ))
B2(( 8 )) --> C4(( 4 ))
```

3. Imagine you've built a brand-new heap by inserting the following numbers into the heap in this
   particular order: 55, 22, 34, 10, 2, 99, 68. If you then pop them from the heap one at a time and
   insert the numbers into a new array, in what order would the numbers now appear? <br/>
   ```
   R: It would appear in ascending/descending order 
   Depending on heap condition:
    * if is max heap->then it would appear in descending order
    * if is a min heap -> it then appear in ascending order)
   
This would be an example for a max heap:

```mermaid
graph TB;
A(( 99 )) --> B1(( 22 ))
A(( 99 )) --> B2(( 68 ))

B1(( 22 )) --> C1(( 10 ))
B1(( 22 )) --> C2(( 2 ))

B2(( 68 )) --> C3(( 34 ))
B2(( 68 )) --> C4(( 55 ))
```
A resource where you can visualize the iterations (insertion, deletion, creation) step by step
* http://btv.melezinek.cz/binary-heap.html
* https://visualgo.net/en/heap