# Makefile for a simple Maven project

APP_NAME = practice
MAIN_CLASS = in.math2do.practice.Main

.PHONY: all com run test clean package deps

all: com run

com:
	mvn compile

deps:
	mvn dependency:resolve

run:
	mvn exec:java -Dexec.mainClass=$(MAIN_CLASS)

test:
	mvn test

package:
	mvn package

clean:
	mvn clean