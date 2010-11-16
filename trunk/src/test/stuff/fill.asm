@b
M=0

@8192
D=A
@max
M=D

@1
D=A
@step
M=D

(CHECK)//check if key pressed.
@KBD
D=M
@CLEAR
D;JEQ
@BLACK
0;JMP

(BLACK)//black the screen.
@b
D=M
@1
D=D-A
@CHECK
D;JEQ

@ad
M=0

(FILL)
@ad
D=M
@max
D=M -D
@CONT
D;JEQ

@ad
D=M
@SCREEN
A=D +A
M=-1

@step
D=M
@ad
M=D+M

@FILL
0;JMP
(CONT)





@b
M=1
@C  HECK
0;JM P // jump s  to the start.
(CL EAR)
@ b
D= M
@CHECK
D;JEQ

@ad
M=0

(C LEA R1)
@a d
D=M
@ max
D=M - D
@CONT1
D;JEQ

@a d
D=M
@SCREEN
A=D+A
M =0

@step
D=M
@ad
M=D+M

@CLEAR1
0;JM P
(CONT1)



@b
M=0
@ CHECK
0;J MP // jumps to the start.