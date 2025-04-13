# Using a jar

This test ensures that a jar can be used in the classpath of compilation
of another class as external library


javac -d out \*.java -cp Library.jar (Compilation java files)
java -cp "Library.jar;out CreatingJarFile" (Execution program Windows)
java -cp "Library.jar:out CreatingJarFile" (Execution program Linux) 