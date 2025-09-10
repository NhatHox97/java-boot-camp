# Tree

## Terminology

               A (root)
        ┌────────┼─────────┐
        B        C         D
      ┌─┴─┐             ┌──┼──┐
      E   F             G   H  I
         ┌┴┐                │
         J K                L
         │               ┌──┴──┐
         M               N     O

- Tree is the collection of nodes and edges.
- If there are N nodes →, there will be N-1 edges.
- A is called the root.
- Subtree is a tree that is a part of another tree (e.g.: B is a subtree of A).

#### Definition

- Root: A is a root, the node on top.
- Parent: L is a parent of N, O.
- Child: N,O are children of L.
- Sibling: G,H,I are siblings of D (have the same parent).
- Descendent: E,F,J,K,M are descendents of B (below B, can be reach from B).
- Ancestor: J,F,B,A are ancestors of M (above M, the route from M to Root → A. L,H,D,A are ancestors
  of N).
- Degree of the Node: The number of direct children of a node(F is 2, J is 1, M is 0).
- Internal Node / External Node: Also call non-leaf nodes and leaf nodes.
    - Node with DoN = 0 is leaf node or external node.
    - Node with DoN > 0 is internal node or non-leaf node.
- Levels: The number of nodes below the root(we don't count duplicate, and it start at 1)
    - Example: A is level 1, B-C-D is level 2, E-F-G-H-I is level 3, J-K-L is level 3, M-N-0 is
      level 4.
- Height: Similar to level, but it count edge instead of node start at 0.
- Forest: Collection of trees.