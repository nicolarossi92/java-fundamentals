# Initializing variables section

This aection contains rules to validate the initialization of variables in Java 11
with var (local type inference), default initialization for non-local variables and
multiple variable initialization

1. The compiler will complain if a local variable is uninitialized and is used inside the code.
   There is no default value for local variables.
2. If a local variable is left uninitilized inside a branch in a conditional statement,
   and that variables is used later inside the program, the compiler will complain
3. For the purpose of validation by the compiler, an uninitialized variable cannot be passed
   as method or constructor parameter
4. All instances variables and class variables can be used even when left uninitialized
   because they do have a default value
5. Var can be used to infer the type of local variable, but has to be initialized on the same statement
6. As the name suggest, var cannot be used in instance variables and neither can be used
   on method parameter to infer the type of the parameter itself, since those variables
   have to be initialized before their use inside a method
7. var cannot be used unless the declaration is followed by initialization, and the object is not null
   Also, var is not allowed in multiple variable declaration and cannot be initialized in another line.
   Declaration and initialization must occur at the same time.
8. Var is a reserved type word but not a reserved keyword. As such, can be used inside an identifier, but not as a name
   of a type (a class)
9. Null is allowed as an assignment to a var variable only if an explicit cast is used to allow
   the compiler to infer the type anyway