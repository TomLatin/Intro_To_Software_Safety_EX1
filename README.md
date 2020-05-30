## READ ME:
This project has 2 parts where I demonstrate software safety issues when working with files, 
the first part demonstrates 2 problems in Java and the second part demonstrates 4 problems in C.

### Java part:
I demonstrate the follwing problems:
1.ERR08-J. Do not catch NullPointerException or any of its ancestors (when working with files)
2.EXP01-J. Do not use a null in a case where an object is required (when working with files)

Source for inspiration from:
[ERR08-J. Do not catch NullPointerException or any of its ancestors](https://wiki.sei.cmu.edu/confluence/display/java/ERR08-J.+Do+not+catch+NullPointerException+or+any+of+its+ancestors) and

[EXP01-J. Do not use a null in a case where an object is required](https://wiki.sei.cmu.edu/confluence/display/java/EXP01-J.+Do+not+use+a+null+in+a+case+where+an+object+is+required)

### C part:
In this section I use a tool called -fsanitize = which allows you to compile with flags that find specific problems in the code.
I demonstrate the follwing problems:

1.Exceeding the boundary of the array, can be discovered by -fsanitize=bounds

2 Use after free bugs, can be discovered by -fsanitize=address

3.Leak of memory, can be discovered by -fsanitize=leak

4.Integer divide by zero, can be discovered by -fsanitize=integer-divide-by-zero

Source for inspiration from:
[C resource](https://gcc.gnu.org/onlinedocs/gcc/Instrumentation-Options.html)

This project was done as part of a course at Ariel University, where the course "Introduction to Software Safety"
The assignment is attached with all files.

## How to compile:
#### Java part:

On Windows/Ubunto:
Javac case1.java && java case1
Javac case2.java && java case2

#### C part:

I use gcc version: gcc version 7.5.0 (Ubuntu 7.5.0-3ubuntu1~18.04)
To compile all the files just write in the terminal: make all
And for to run : ./target

![image](https://user-images.githubusercontent.com/57855070/83323867-2f2e0680-a26a-11ea-86bf-7966e416d2dc.png)

![image](https://user-images.githubusercontent.com/57855070/83323879-3e14b900-a26a-11ea-9b69-67d21e81ae5e.png)

