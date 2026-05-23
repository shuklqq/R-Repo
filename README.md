# R-Repo — DSA & Java Concepts Practice

A personal repository for practising Data Structures & Algorithms and core Java concepts, primarily aimed at interview preparation. Solutions are written in **Java** with a growing set of parallel implementations in **Go**.

---

## Repository Structure

```
R-Repo/
├── Practice_Java/
│   ├── src/                  # DSA problems by topic
│   └── JavaConcepts/src/     # Java language & concurrency concepts
└── Practice_Go/
    └── DSA/                  # DSA problems in Go (mirror of select Java problems)
```

---

## Practice_Java — DSA Topics

| Topic | What's covered |
|---|---|
| `Arrays` | Sorting, rotations, XOR queries, prefix common arrays, interval merging, duplicate detection |
| `BinarySearch` | Search in rotated sorted array, peak element |
| `BinarySearchTree` | BST construction, unique BST count, node deletion |
| `BinaryTree` | Flip equivalence, height after subtree removal |
| `BFS` | Number of islands, rotten oranges, farthest land distance |
| `DFS` | Course schedule (cycle detection) |
| `Graph` | Union-Find, network connectivity, redundant connection, evaluate division |
| `Tree` | AVL tree, BST traversal, LCA, right side view, path sum, ZigZag path |
| `Trie` | Trie implementation, prefix scoring, longest common prefix |
| `LinkedList` | Reverse, merge sorted, add two numbers, twin sum, odd-even reorder |
| `Heap / PriorityQueue` | Kth largest, task scheduler, max subsequence score, divide intervals |
| `HashTable` | LRU cache, longest substring without repeats, Roman to integer |
| `Map` | Anagram, isomorphic strings, word pattern, calendar booking |
| `Stack` | Valid parentheses |
| `MonotonicStack` | Daily temperatures |
| `TwoPointer` | Three sum |
| `String` | `myAtoi`, palindrome construction, string compression, parenthesis problems |
| `StringAndArray` | Sliding window, two pointers, prefix sum, trapping rain water, product except self |
| `DynamicProgramming` | Jump game, maximal square, longest palindromic substring, perfect squares, min cost tickets |
| `BitManipulation` | XOR pairings, bitwise AND/OR problems, vowel parity with bitmask |
| `PrefixSum` | Ball movement operations, shifting letters |
| `Recursion` | Different ways to add parentheses, extra characters in string |
| `SortingAlgorithm` | Bubble, Selection, Insertion, Merge, Quick, Heap, Counting sort — all implemented from scratch |
| `Math` | Palindrome number, prime subtraction, beautiful items per query |
| `Contest` | LeetCode contest solutions |

---

## Practice_Java — JavaConcepts

Core Java topics with runnable examples:

| File | Concept |
|---|---|
| `ThreadStates`, `ThreadPriority` | Java thread lifecycle and scheduling |
| `SynchronizatioOfThreads` | `synchronized` blocks, race condition prevention |
| `FixedThreadPoolExecutor`, `ExecutorServiceFrameworkQuestions` | `ExecutorService`, thread pools |
| `StreamAPIQuestions` | Java 8 Stream API — filter, map, reduce, collectors |
| `TreeMapOperationsImplementation`, `TreeMapCustomObjectWithComparator` | `TreeMap` with natural and custom ordering |
| `Encapsulation`, `Interfaces`, `Interfaces_2` | OOP fundamentals |
| `PassByValueForCollection` | How Java passes object references |
| `CurrencyInstance` | `NumberFormat` for currency formatting |
| `FindCalenderDay` | `Calendar` / `LocalDate` API usage |
| `JavaInputReaderAndWriter` | `BufferedReader`, `BufferedWriter`, file I/O |

---

## Practice_Go — DSA

Select problems implemented in Go to compare idiomatic patterns across languages:

| Topic | Problems |
|---|---|
| `HashTable` | Roman to Integer |
| `LinkedList` | Merge Two Sorted Lists |
| `Stack` | Valid Parentheses |
| `String` | Longest Common Prefix |
| `Math` | Palindrome Number |

---

## Who is this useful for?

- **Interview candidates** — problems are grouped by pattern (sliding window, two pointers, BFS/DFS, DP, etc.), making it easy to focus on one technique at a time.
- **Java learners** — the `JavaConcepts` module covers threading, collections, and streams with self-contained, runnable examples.
- **Go learners** — the `Practice_Go` module shows how the same DSA problems translate into idiomatic Go.
- **Anyone revisiting fundamentals** — all major sorting algorithms are implemented from scratch with clear structure.

---

## How to Run

### Java (IntelliJ / any IDE)
Open the `Practice_Java` directory as an IntelliJ project. Each file has a `main` method or is a self-contained class — run directly from the IDE.

### Go
```bash
cd Practice_Go/DSA/<topic>
go run <file>.go
```
