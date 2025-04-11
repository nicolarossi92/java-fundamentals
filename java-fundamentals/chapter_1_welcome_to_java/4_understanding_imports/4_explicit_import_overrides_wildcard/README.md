# Explicit imports override wildcard imports 

This test ensures that if two classes are imported, one of which through wildcard and the other
through an explicit import statement, the program will compile.
This demonstrates that explicit imports override wildcard imports.

javac -d out \*.java