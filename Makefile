SHELL := /bin/bash
CC =  javac
EXE = java
LIBS = -cp ./lib/org.apache.commons.io.jar:./lib/j_anno.jar:./lib/j_datab.jar:./lib/j_core.jar


.PHONY: server client

compile:
		$(CC) $(LIBS)  ./src/*.java 

execute:
		$(EXE) $(LIBS):./src Main $(desk)

