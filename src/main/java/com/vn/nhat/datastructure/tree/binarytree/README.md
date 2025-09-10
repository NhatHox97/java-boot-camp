# Binary Tree

        A (root)
       /       \
      B         C
     / \       / \
    D   E     F   G

## Description

- Tree of degree two (every none can have max two children).
- Because two children, we can name as `left child` and `right child`

## Number of Binary Trees

The formula for Catalan number
$$
C_n = \frac{1}{n+1} \binom{2n}{n}
$$

## Height vs Nodes

If height is given:

- Minimum nodes: $N_{\min} = h + 1$
- Maximum nodes: $N_{\max} = 2^{h+1} - 1$

If nodes are given:

- Minimum height: $h_{\min} = \lfloor \log_{2}(N) \rfloor$
- Maximum height: $h_{\max} = N - 1$

## Internal and External Nodes

- Relation: $E = I + 1$
- Total nodes: $N = I + E = 2I + 1$
- If height is $h$, then maximum external nodes: $E_{\max} = 2^h$

## Strict/Proper/Complete Binary Tree

- Nodes have either degree(0) or degree(2)

If height is given:

- Minimum nodes: $N_{\min} = h + 1$
- Maximum nodes: $N_{\max} = 2^{h+1} - 1$

if nodes are given:

- Minimum height: $h_{\min} = \log_{2}(N+1) - 1$
- Maximum height: $h_{\max} = (N - 1).div(2)$

## Internal and External Nodes in Strict Binary Tree

- Relation: $E = I + 1$
- Total nodes: $N = I + E = 2I + 1$
- If height is $h$, then maximum external nodes: $E_{\max} = 2^h - 1$

