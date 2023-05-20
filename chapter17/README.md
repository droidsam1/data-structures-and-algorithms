# Exercises

## Chapter 17. It Doesn't Hurt to Trie

The following exercises provide you withe opportunity to practice with tries. The
solutions to these exercises are found in the section, Chapter 17, on page 459.

1. List all the words stored in the following trie

```mermaid
graph TB;
A[ ] -- t --> B1[ ]
A[ ] -- w --> B2[ ]
B1[ ] -- a --> C1[ ]
C1[ ] -- g --> D1[ *]
C1[ ] -- n --> D2["{*,k}"]
C1[ ] -- p --> D3[ * ]
D2["{*,k}"] -- k --> E1[ * ]

B1[ ] -- o --> C2[ ]
C2[ ] -- d --> D4[ ]
C2[ ] -- t --> D5[ ]

D4[ ] -- a --> E2[ ]
D5[ ] -- a --> E3[ ]

E2[ ] -- y --> F1[ * ]
E3[ ] -- l --> F2[ * ]



B2[ ] -- e --> C3["{*,l,n}"]
C3["{*,l,n}"] -- l --> D6[ ]
C3["{*,l,n}"] -- n --> D7[ ]

D6[ ] -- l --> E4[ * ]
D7[ ] -- t --> E5[ * ]
```

``R: tag, tan, tank, tap, today, total, we, well, went``

2. Draw a trie that stores the following words: "get", "go", "got", "gotten", "hall", "ham", "
   hammer", "hill" and "zebra"