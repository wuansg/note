## ArrayList 源码分析

> ArrayList 是List接口的一个大小可扩展的实现，它实现了所有可能的**list operations**，并且允许所有元素为**null**。此外，内部还提供了方法去维护List的实际大小。

> ArrayList中的**size, isEmpyt, get, set, iterator, listIterator**操作都是$O(1)$，而**add**操作这是$O(n)$.

> 当需要添加很多元素时，可以使用**ensureCapacity**确保ArrayList有足够的容量，避免进行多次的再分配（reallocation）

## LinkedList 源码分析

> LinkedList 也是List接口的一个链表实现，除此之外，LinkedList还实现了**Deque**接口。同样的，LinkedList也允许元素为**null**。