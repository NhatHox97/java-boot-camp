# N-ary Tree

## What is N-ary Tree?
- Every node has the capacity to have N children (not more than N).
- Could also be a binary tree.

### Example 1 – Small 3-ary Tree (height 2)
          A
       /  |  \
      B   C   D
     /|\      
    E F G     

### Example 2 – Full 3-ary Tree (height 2, all nodes filled)
           A
       /   |   \
      B    C    D
    / | \ /|\  /|\
    E  F  G H I J K L

### Example 3 – Skewed 3-ary Tree (like a chain but using middle child)
    A
     \
      B
       \
        C
         \
          D

## Strict 3-ary Tree (no middle child)
- A strict 3-ary tree is when node has degree(3) or degree(0)

## Height and Nodes

if Height is given:
- Min nodes = n*h + 1
- Max Nodes = $\frac{N^{h+1} - 1}{N - 1}, \quad (N > 1) $

if Nodes are given:
- Min Height = $\left\lceil \log_{N}\big( (N-1)\cdot N_{nodes} + 1 \big) \right\rceil - 1 $
- Max Height = $ N_{nodes} - 1$

## Internal and External Nodes
- Formula for external(e) and internal(i)
  - e = (n-1)i + 1

