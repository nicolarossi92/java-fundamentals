# Grouping under packages can be achieved with package directive

This ensures that grouping classes under packages and compiling them
correctly, provides a logical grouping of classes which can be accessed by other classes
with import statements.

Use the following commands:

javac -d out ./packagea/ClassPackageA.java ./packageb/ClassPackageB.java

And then

java -cp out packageb.ClassPackageB