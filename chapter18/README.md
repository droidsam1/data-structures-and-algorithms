# Exercises

## Chapter 18. Connecting everything with Graphs

The following exercises provide you withe opportunity to practice with graph. The
solutions to these exercises are found in the section, Chapter 18, on page 461.

1. The first graph on page 385 powers a e-commerce store's recommendation engine. Each vertex
   represents a product available on the sore's website. The edges connect each product to other "
   similar" products the site will recommend to the user when browsing a particular item. <br/> If
   the user is browsing "nails", what other products will be recommended to the user?

```R: The recomended items would be: pins, needles, nail polish, hammer```

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
