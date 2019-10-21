# Programming Assignment: Functional Sets

## Representation

We will work with sets of integers.

As an example to motivate our representation, how would you represent the set of all negative integers? You cannot list them all… one way would be so say: if you give me an integer, I can tell you whether it’s in the set or not: for 3, I say ‘no’; for -1, I say yes.

Mathematically, we call the function which takes an integer as argument and which returns a boolean indicating whether the given integer belongs to a set, the characteristic function of the set. For example, we can characterize the set of negative integers by the characteristic function (x: Int) => x < 0.

Therefore, we choose to represent a set by its characteristic function and define a type alias for this representation:


```python
type Set = Int => Boolean
```
Using this representation, we define a function that tests for the presence of a value in a set:

```python
def contains(s: Set, elem: Int): Boolean = s(elem)
```


## 2.1 Basic Functions on Sets
Let’s start by implementing basic functions on sets.

1. Define a function **singletonSet** which creates a singleton set from one integer value: the set represents the set of the one given element. Now that we have a way to create singleton sets, we want to define a function that allow us to build bigger sets from smaller ones.
2. Define the functions **union,intersect**, and **diff**, which takes two sets, and return, respectively, their union, intersection and differences. **diff(s, t)** returns a set which contains all the elements of the set **s** that are not in the set **t**.
3. Define the function filter which selects only the elements of a set that are accepted by a given predicate **p**. The filtered elements are returned as a new set.
