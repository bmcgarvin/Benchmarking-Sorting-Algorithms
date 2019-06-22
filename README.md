# Benchmarking-Sorting-Algorithms
In this assignment you will practice predicting and verifying the impact of data "nature" on the run-time
of sorting algorithms. As we have seen with algorithms like insertion sort, the runtime (even worse case like
Big-Oh) can be impacted by the nature of the input.
To do this, we will create three dierent types of input data, that may give dierent results when sorted.
Two sorting algorithms will then be benchmarked on these three types of data. Each algorithm will be
run twice, for dierent dataset sizes, in order to get times that we can use to apply the doubling formula.
(see slide 23: Modeling Small Datasets) in the Analysis of Algorithms slide deck for details on the doubling
formula.) The doubling formula is lg T(2N)
T(N) = b. If we compute the formula, then we will be able to gure
out the algorithm's Big-Oh for a particular type of input data, since they will be O(nb). b is simply the
power.
This document is separated into four sections: Background, Requirements, Testing, and Submission.
You have almost nished reading the Background section already. In Requirements, we will discuss what is
expected of you in this homework. In Testing, we suggest some basic tests you use to start to verify your
implementation. Lastly, Submission discusses how your source code should be submitted on Canvas.
2 Requirements [30 points]
For this assignment you will be writing code to generate test data and benchmark sorting algorithms on it
(edited from Sedgewick and Wayne: 2.1.36). First, write a series of methods that generate test data that is
non-uniform:
 Half the data is 0s, half 1s. For example, an input of length 8 might look like [0, 1, 1, 0, 0, 1, 0, 1]. [4
points]
 Half the data is 0s, half the remainder is 1s, half the reminder is 2s, half the reminder is 3s, and so
forth. For example, an input of length 8 might look like [0, 0, 1, 3, 0, 1, 2, 0]. [5 points]
 Half the data is 0s, half random int values (can use nextInt() from Java's Random package). For
example, an input of length 8 might look like [0, 138617093, 0, 54119567, 0, 0, 4968, -650736346]. [4
points]
Each of these three techniques should be implemented as a static method that takes a integer representing
the size of a dataset, and returns an integer array containing that number of elements generated with the
corresponding rule. Randomize (shue) the contents of the array after you populate it.
Using the three methods you implemented, develop and test hypotheses about the eect of input on
the performance of two of the algorithms (your choice) we have covered. See the course git repository for
implementations.
 The program should contain your hypotheses (3 per algorithm) as comments: describe what you think
the running time will look like (O(n)? O(n2)? O(n3)?) on each data set, and explain briey why you
think that. As long as your ideas make sense, and you do the analysis prior to benchmarking,
you will receive full credit on the hypotheses. [5 points]
