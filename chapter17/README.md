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

```mermaid
graph TB;
A[ ] -- g --> B1[ ]
A[ ] -- h --> B2[ ]
A[ ] -- z --> B3[ ]

B1[ ] -- e --> C1[ ]
C1[ ] -- t --> D1[* ]

B1[ ] -- o --> C2["{*,t}"]
C2["{*,t}"]-- t --> D2["{*,t}"]
D2["{*,t}"] -- t --> E1[ ]
E1[ ]-- e --> F1[ ]
F1[ ]-- n --> G1[ * ]


B2[ ] -- a --> C3[ ]
C3[ ] -- l --> D4[ ]
D4[ ] -- l --> E2[ * ]
C3[ ] -- m --> D5["{*,m}"]
D5["{*,m}"]  -- m --> E5[ ]
E5[ ]  -- e --> F5[ ]
F5[ ]  -- r --> G5[ * ]

B2[ ] -- i --> C4[ ]
C4[ ] -- l --> D6[ ]
D6[ ] -- l --> E6[ * ]

B3[ ] -- e --> C5[ ]
C5[ ] -- b --> D7[ ]
D7[ ] -- r --> E7[ ]
E7[ ] -- a --> F7[ * ]
```
