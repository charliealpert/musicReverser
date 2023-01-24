# musicReverser

**To Run the Program**:
This will allow file ‘ciphered.wav’ to be reversed into ‘cipheredOutput.wav’
- Download SOX to convert files
- Use the command in the terminal/unix system to convert the file from . wav to .dat:  sox ciphered.wav ciphered.dat 
- Create file ‘cipheredOutput.dat’ to store converted material
- Edit configurations in Java IDE to say ‘array ciphered.dat cipheredOutput.dat’ or ‘list ciphered.dat cipheredOutput.dat’ depending if wanting to use array or list to run
- Use the command in the terminal/unix system to convert the file from . dat to .wav:  sox cipheredOutput.dat cipheredOutput.wav 
- Use these steps but change file names to reverse whatever file desired


**ArrayStack**: 
	When deciding how I wanted to do my array stack. I was trying to decide whether I wanted my top value of the stack to be at the beginning or the end of the array. I also had to figure out whether the non-filled values in the array should be at the beginning or the end. My final solution relied on using an index to track the top of the stack to avoid having to move values everytime a new value was pushed on the stack. Therefore, my non-filled values of the stack will be at the end of the array.
	The doubleArray method first checks if the array needs to be doubled. My array will only ever double if it is full of values and therefore more space in the stack is required. First a new array is created with twice the length of the original stack. The original stack is then looped through every value. The new stack is then filled with the previous values. A variable ‘i’ is used to keep track of what index each value will go in. Finally, after all the looping, the original stack is reassigned with the new doubled stack. This has a complexity of O(n) with n being the size of the original stack. However, the looping will only ever be implemented when the stack needs to be doubled.
	The push method first calls the doubleArray method. Since the first check in the doubleArray method is whether or not the array needs to be doubled, this method will only fully execute when required. Then the value is inserted into the stack at the current index. The index is then incremented in preparation for another value to be pushed into the stack. Although the doubleArray method has a complexity of O(n). We can say that this method is O(1) since that complexity is already accounted for. The complexity of doubleArray will affect the program's total complexity.
	My pop method checks using isEmpty to make sure there is a value in the array. Then my program decreases the index by one. This is because index refers to the next value to be added in the stack, which is one greater to where the most recent value is/top of stack. Then the value in the array where the top is will be stored in a variable to make sure it is not lost when removed. Then the stack at the index is replaced with zero, removing the top value. The popped value is then returned by the variable used to temporarily store it. It has a complexity of O(1) since no looping is involved.
	The peek method first checks if there is something in the array using isEmpty. If so it will return the top value using index - 1. Since index is the value to insert a new value, the top of the stack will be one value less than index. Complexity is O(1).
	My isEmpty method used in peek and pop, uses index to check if there are any values. If the index is 0 that means there are no values, since the index tracks the current placement of the top of the stack. Even if there is only one value in the array at index zero, the index variable will store 1 since it is incremented after a value is pushed on the stack. Complexity is O(1).
	The file’s complexity is O(n) because of the one loop in doubleArray. Most of the time when the file is used, the file will disregard that loop since it will only ever compute when the array is full. However since big O refers to the upper bound complexity of the program, O(n) is accurate to represent the worst case.
	

**ListStack**:
	When first implementing the linked list, I was attempting to use a doubly linked list where the head would be at the bottom of the stack. Then to pop, I would iterate through the stack to make the value before tail the new tail and remove the current tail from the stack. I realized how inefficient this would be since it required a loop every time I needed to pop. Instead, I realized that I could just make the head value my top of stack and push down previous values to point from head which eliminated any looping. 
My push implementation works by creating a new node, assigning the next pointer of that new node to be the head, then reassigning head to be the new node. This pushes the new node into the head position then pushes the previous head down to the second position in the linked list. Anything connecting to the previous head will remain connected so that the new head now points to the rest of the list. When the previous head is null and a new node is added, then the list just becomes the head which will point to a null value indicating the end of the list. The push method has a complexity of O(1) since it will only run once with no looping. 
The pop method works similarly to the push method. First it stores the previous head value (which will be removed) in a local variable so that it can be returned at the end without being lost. After checking to make sure the list is not empty, my program reassigns the head value with the next value in the list (head.next). Now the elements have been moved up and the previous head value is gone. Finally, it returns the previous head value that was stored in the local variable. This is also O(1).
My peek method double checks that the stack is not empty, then returns the data value in head as long as there is a value. It has the complexity of O(1).
The isEmpty function used in both pop and peek checks to see if the head value is null. If the head value is null, that means either that nothing has been pushed in the stack or that all elements have already been popped. This works since my push implementation always reassigns the head value. The complexity is O(1).
	The entire program has a complexity of O(1) since there is no looping in the program. However, when BackMasking is using the ListStack program, it will use it for as many values that are in the file. This affects the complexity of BackMasking though, not ListStack.

