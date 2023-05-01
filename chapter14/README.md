# Exercises

## Chapter 14. Node-Based Data Structures

The following exercises provide you withe opportunity to practice with linked lists. The solutions
to these exercises are found in the section, Chapter 14, on page 453.

1. Add a method to the classic LinkedList class that prints all the elements of the list
2. Add a method to the DoublyLinkedList class that prints all the elements of the list in reverse
   order
3. Add a method to the classic LinkedList class that returns the last element from the list. Assume
   you don't know how many elements are in the list.
4. Here's a tricky one. Add a method to the classic LinkedLIst class that reverses the list. That
   is, if the original list is A -> B -> C, all the list's links should change so that C -> B ->
   A
5. Here is a brilliant little linked list puzzle for you. Let's say you have access to a node from
   somewhere in the middle of a classic linked list, but not the linked list itself. That is, you have
   a variable that points to an instance of Node, but you don't have access to the LinkedLIst
   instance. In this situation, if you follow this node's link, you can find all the items from this
   middle node until the end, but you have no way to find the nodes that precede this node in the
   list.<br/> Write code that will effectively delete this node from the list. The entire remaining
   list should remain complete with only this node removed.