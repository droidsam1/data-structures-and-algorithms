# Exercises

## Chapter 18. Connecting everything with Graphs

The following exercises provide you withe opportunity to practice with graph. The
solutions to these exercises are found in the section, Chapter 18, on page 461.

1. The first graph on page 385 powers a e-commerce store's recommendation engine. Each vertex
   represents a product available on the sore's website. The edges connect each product to other "
   similar" products the site will recommend to the user when browsing a particular item. <br/> If
   the user is browsing "nails", what other products will be recommended to the user?

```R: The recomended items would be: pins, needles, nail polish, hammer```

2. If we perform depth-fist search on the second graph on page 385 starting with the "A" vertex,
   what is the order in which we'll traverse all the vertices? Assume that when given the choice to
   visit multiple adjacent vertices, we'll first visit the node that is earliest in the alphabet
   ``R: A-B-E-J-F-O-C-G-K-D-H-L-M-I-N-P``
3. If we perform breadth-first search on the previous graph starting with the "A" vertex, what is
   the order in which we'll traverse all the vertices? Assume that when given the choice to visit
   multiple adjacent vertices, we'll first visit the node that is earliest in the alphabet.
   ``R: ABCDEFGHIJKLMNOP``
4. In this chapter, I only provided the code for breadth-first traversal, as discussed in
   Breadth-First Search, on page 348. Hat is , the code simply printed the value of each vertex.
   Modify the code so that i performs and actual search for a vertex value provided to the
   function. (we did this for depth-first search) That is, if the function finds the vertex it's
   searching for, it should return that vertex's value. Otherwise, it should return null

_Graph on page 385 looks similar to:_

````mermaid
flowchart TD;
A(("drill")) --- B(("hammer")) --- C(("saw")) --- D(("knife")) --- E(( fork ))
B(("hammer")) --- B1(( nails ))
B1(( nails )) --- B2(( pins )) --- B3(( needles ))
B1(( nails )) --- B3(( needles ))
D(("knife")) --- D1(( spoon ))

A1(( brush )) --- A2(( nail polish ))
A2(( nail polish )) --- B1(( nails ))
A2(( nail polish)) --- A3(( eye shadow )) --- A4(( eye glasses ))
````

_Second graph on page 385 looks similar to:_

````mermaid
flowchart TB;
O(( O )) --- J(( J ))--- F(( F )) --- B(( B ))--- A(( A )) --- D(( D )) --- I(( I ))
J(( J ))--- E(( E )) --- B(( B ))

K(( K )) --- G(( G)) --- C(( C )) --- A(( A))

L(( L )) --- H((H )) --- M(( M ))
M(( M )) --- I(( I ))
H((H )) --- D(( D ))

P(( P )) --- N(( N )) --- I(( I ))
````