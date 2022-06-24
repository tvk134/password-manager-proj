# password-manager-proj
Basic text-based and encrypted password manager built in Java
Run "driver.java" file to start the program.
StdIn and StdOut libraries used to organize input and output. 
Separate encryption keys are generated for each password. Regenerated every time program is quit.
Encryption key is stored in a single string along with the encrypted password. Decryption requires reading the key and then decoding the password.
Users are never shown the encrypted version of the passwords for better usability. Encrypted versions are only stored in "database.out"
Program must be quit (by pressing 5 in the function select section) to save changes. Otherwise, the contents of the "database.out" file may be wiped.


-Tanay Kale
