###############################################################################
#
# Makefile for Java project
#
# Students:
# Itay Sabato, ID 036910008, itay.sabato@cs.huji.ac.il
# Rotem Barzilay, ID 300618592, rotem.barzilay@cs.huji.ac.il
#
###############################################################################

JAVAC=javac
JAVACFLAGS=

SRCS=assembler/*.java
EXEC=Assembler

TAR=tar
TARFLAGS=cvf
TARNAME=project6.tar
TARSRCS= *

all: compile

compile:
	$(JAVAC) $(JAVACFLAGS) $(SRCS)
	chmod +x $(EXEC)

tar:
	$(TAR) $(TARFLAGS) $(TARNAME) $(TARSRCS)

clean:
	rm -f *.class *~

