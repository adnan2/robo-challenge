# Robot Challenge 

https://github.com/ioof-holdings/recruitment/wiki/Robot-Challenge

Robot Commands
```bash
place 1,2,north     	To Place a Robot at 1,2 facing North
left                	To change direction of Robot to the left side
right               	To change direction of Robot to the right side
move                	To move the robot in its current direction
report              	To display the position and direction of active robot
display             	To view tabletop grid with robots and their direction
robot 2             	To activate a specific robot by its number
help                	To display help
```
------------------------------------------------------
You can also use shortened commands for above mentioned commands.
```bash
p 1,2,north         	To Place a Robot at 1,2 facing North
l                   	To change direction of Robot to the left side
r                   	To change direction of Robot to the right side
m                   	To move the robot in its current direction
rt                  	To display the position and direction of active robot
d                   	To view tabletop grid with robots and their direction
rb 2                	To activate a specific robot by its number
h                   	To display help
```
------------------------------------------------------

Here are a few examples

Example 1
```bash
place 1,2,north
move
move
right
move
report
Output: 2,4,EAST

```

Example 2
```bash
p 2, 2, west
display
     0               1               2               3               4              
    +---------------+---------------+---------------+---------------+---------------
4                                                                                   
    +---------------+---------------+---------------+---------------+---------------
3                                                                                   
    +---------------+---------------+---------------+---------------+---------------
2                                    Robot  1 ←                                     
    +---------------+---------------+---------------+---------------+---------------
1                                                                                   
    +---------------+---------------+---------------+---------------+---------------
0                                                                                   
    +---------------+---------------+---------------+---------------+---------------

right
display
     0               1               2               3               4              
    +---------------+---------------+---------------+---------------+---------------
4                                                                                   
    +---------------+---------------+---------------+---------------+---------------
3                                                                                   
    +---------------+---------------+---------------+---------------+---------------
2                                    Robot  1 ↑                                     
    +---------------+---------------+---------------+---------------+---------------
1                                                                                   
    +---------------+---------------+---------------+---------------+---------------
0                                                                                   
    +---------------+---------------+---------------+---------------+---------------
move
report
Output: 2,3,NORTH

display
     0               1               2               3               4              
    +---------------+---------------+---------------+---------------+---------------
4                                                                                   
    +---------------+---------------+---------------+---------------+---------------
3                                    Robot  1 ↑                                     
    +---------------+---------------+---------------+---------------+---------------
2                                                                                   
    +---------------+---------------+---------------+---------------+---------------
1                                                                                   
    +---------------+---------------+---------------+---------------+---------------
0                                                                                   
    +---------------+---------------+---------------+---------------+---------------


```

