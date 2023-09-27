# Custom List Implementation
----------------------------
## Custom List Implementation, offering some typical features of Linked Lists and Array Lists. The List implementation is accompanied by some helper classes.

- Nested Node Class
- Country Class
- Three Classes Implementing Comparator
- Main Class


## Features

- Doubly Linked List - works in both directions
- Indexing - makes working with indexes possible
- Sorting - two built-in sorting algorithms - Selection Sort and Merge Sort
- Built-in Iterator - for list traversal
- Reversing Function - as the name states, it reverses the direction and order of the list
------------------------------------------

### The List works with the standard input and output. There are several helper classes.

> The functionality of the List is supported by additional classes, briefly described here.
> Nested Node Class - this is a private nested class, providing the main structural unit of the list - a Node, hence it's creation and functionionality.
> Country Class - provides custom objects of type Country with their 
respective attributes. 
> Three classes implementing Comparator - useful for Country Class objects 
comparison and sorting.
> Main Class - it's purpose is testing the List Functionality.
> This is Generic list, it works with different kind of objects, so the Country 
class only serves as an example of the capability of the list to work with 
custom objects.
> The Country Class implements Comparable, so it makes the comparison of 
it's objects possible and serves the sorting function of the List. 
> With the goal to offer different sorting critera the three Comparator 
implementing classes are added.
> Sorting and NULL values - the concept of sorting the elements in the list is in ascending order. Regarding the null values - the applied logic in this implementation is to treat them as highest values and put them at the end of the list. 
