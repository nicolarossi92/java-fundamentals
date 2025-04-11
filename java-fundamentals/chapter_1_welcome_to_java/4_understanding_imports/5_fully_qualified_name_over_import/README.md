# Fully qualified name over import 

This test ensures that two classes with same name can be used inside the same
program, if at least one of them uses a fully qualified name, which
makes the import statement not necessary

javac -d out \*.java