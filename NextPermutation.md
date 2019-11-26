## Problem Description

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

[1,2,3] → [1,3,2]
[3,2,1] → [1,2,3]
[1,1,5] → [1,5,1]

## Notes
This problem was challenging and took a few hours to recognize the pattern for the next permutations.

Key concepts:
* Permutation in this context is a string of numerals
* the values you are allowed to use are within the string of numberals given to you.
* My interpretation of lexicographically next greater - take string of numerals and rearrange the ordering such that the numeriacal value of the string i find is the next larger string within an ordered squence

> If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
ascending order is also sorted order

[1, 2, 3, 4] 
[1, 2, 4, 3] 
[1, 3, 2, 4] 
[1, 3, 4, 2]
[1, 4, 2, 3]
[1, 4, 3, 2]
[2, 1, 3, 4]
...
[4, 2, 1, 3]
[4, 2, 3, 1]
[4, 3, 1, 2]
[4, 3, 2, 1]
[1, 2, 3, 4]
[1, 2, 4, 3]

## Runtime Complexity | Space Complexity





