# Exercises

## Chapter 12. Dynamic Programming

The following exercises provide you with the opportunity to practice with dynamic programming. The
solutions to these exercises are found in the section. Chapter 12, on page 450

1. The following function accepts an array of numbers and returns the sum, as long as a particular
number doesn't bring the sum above 100. If adding a particular number will make the sum higher than
100, that number is ignored. However, this function makes unnecessary recursive calls. Fix the code
to eliminate the unnecessary recursion:
```
def add_until_100(array)
    return 0 if array.length == 0
    if array[0] + add_until_100(array[1, array.length -1]) > 100
        return add_until_100(array[1, array.length -1])
    else
        return array[0] + add_until_100(array[1, array.length -1])
    end
end
```
- Solution:
```
def add_until_100(array)
    return 0 if array.length == 0
    sum_of_remaining = add_until_100(array[1, array.length -1]);
    if array[0] +  sum_of_remaining > 100
        return sum_of_remaining;
    else
        return array[0] + sum_of_remaining;
    end
end
```