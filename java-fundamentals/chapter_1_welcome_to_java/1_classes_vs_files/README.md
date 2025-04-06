# Classes Vs Files section

This section contains tests to validate the rules related to class definitions
in Java files, specifically regarding public and non-public classes.

1. Only one public class and any number of non public classes will compile, as long the public class match the file name.
2. Public class must match the corresponding file name.
3. Two non public classes inside the same file without a public class will compile just fine (public classes are not mandatory).
4. There can be, as a consequence, only one public class since two public classes cannot have the same name and therefore cannot match the file name.