# Two classes same name imported will not compile

Test to ensure that if two classes with same name are imported with import
statement, the compiler will output an error since it cannot possibly
discriminate which class to use as a default

javac -d out \*.java