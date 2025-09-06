# Makefile for a simple Maven project

APP_NAME = practice
MAIN_CLASS = in.math2do.practice.Main

.DEFAULT_GOAL := help

.PHONY: help all com run test clean package deps

default: help

all: com run ## Compile and run

com: ## Compile sources
	mvn compile

deps: ## Resolve dependencies
	mvn dependency:resolve

run: ## Run the application
	mvn exec:java -Dexec.mainClass=$(MAIN_CLASS)

test: ## Run tests
	mvn test

package: ## Build a jar package
	mvn package

clean: ## Clean target files
	mvn clean

help:  ## Show available commands
	@echo "Usage: make <target>"
	@echo
	@echo "Targets:"
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z0-9_-]+:.*?## / {printf "  %-10s %s\n", $$1, $$2}' $(MAKEFILE_LIST)
