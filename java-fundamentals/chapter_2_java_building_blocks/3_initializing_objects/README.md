# Initializing objects section

 This section contains tests to validate the rule for correct definition of a constructor
 used to initialize variables inside an object and other constructs to initialize
 variables inside a class

1. This test ensures that correct definition of constructor allow to initialize an object upon invocation with new
2. This test ensures that field initialization is equally valid as constructor initialization.
Also, inside nay field initialization any value can be read if it was previously initialized.
3. This test ensures that initialization blocks are an equally valid alternative to initialize field variables
4. Firstly, fields initialization statements and in initialization blocks are run in the order
in which they appear inside the source code. After that, the code inside the invoked constructor is executed