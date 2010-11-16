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
D=M-D
@CONT
D;JEQ

@ad
D=M
@SCREEN
A=A+D
M=-1

@step
D=M
@ad
M=M+D

@FILL
0;JMP
(CONT)





@b
M=1
@CHECK
0;JMP // jumps to the start.
(CLEAR)
@b
D=M
@CHECK
D;JEQ

@ad
M=0

(CLEAR1)
@ad
D=M
@max
D=M-D
@CONT1
D;JEQ

@ad
D=M
@SCREEN
A=A+D
M=0

@step
D=M
@ad
M=M+D

@CLEAR1
0;JMP
(CONT1)



@b
M=0
@CHECK
0;JMP // jumps to the start.