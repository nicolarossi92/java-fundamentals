# Understanding imports section

This section contains tests to validate the rules for the
imports and import conflicts.
1. Test to validate that a class external to java.lang package needs an import directive
2. Test to ensure that if imported correctly, a class can be used without raising a compilation error
3. Test to ensure that if two classes with the same name are import, the compiler will raise an error
4. This test ensures that if two classes are imported, one of which through wildcard and the other with explicit import, the program will compile
5. Two classes can be used even with the same name if one of them has a fully qualified name, which makes the import statement not necessary.