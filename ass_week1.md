# Assignment 1

Requirement : A string will have brackets (){}[] along with big and small latin words, 
numbers along with punctuation marks. Problem is to find unmatched bracket along with 
the position.

example 1 : [] -> o/p success
example 2 : (){} -> o/p success
example 3 : [{ac}] -> o/p success
example 4 : ( -> o/p 1
example 5 : {[} -> o/p will be 3


Steps of Algorithm

1. Iterate the string after converting it to an array.
2. any occurance of opening braces, put them into a stack.
3. else check if the value is any of the below )}]. 
4. compare these value with the value poped out of the stack.
5. If it does not match, return the index + 1.
6. if all the brackets have a match, return success. 