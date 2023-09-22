# LibraryManagmentSystem

This is a basic Library Management System implemented in Java. 

#Project Setup
project was created with intellj with jdk 20 and it uses a binary file to set up and store database

##setps
1. create a folder inside data access called "storage" and run test data file to set up the database
2. run the main window in the UI folder

## to build project
1. run build artifacts on the main class and go to artifacts folder
2. create src/dataaccess/storage directory and add test data output files "MEMBERS", "BOOKS","USERS"
3. copy the image file "book.png" to the built jar file location

Basic Use Cases Implemented 
1. Login
• The first screen a user of the system sees is the login screen, which requests ID and
password. When the Submit button is clicked, the ID is looked up in the data store. If this ID
can be found, and if the password for this ID matches the password submitted, the
authorization level is returned. Authorization levels are LIBRARIAN, ADMIN, and BOTH. If
login is successful, UI features are made available according to the authorization level of the
user.

2. Add a new library member to the system.
• When an Administrator selects the option to add a new member, then he is presented with
a form with fields: member id, first name, last name, street, city, state, zip, telephone
number. After the data is entered and submitted, it is persisted using the persistence
mechanism for this project.

3. Checkout a book (if available) for a library member.
• A librarian can enter in a form a member ID and an ISBN number for a book and ask the
system whether the requested item is available for checkout. If ID is not found, the system
will display a message indicating this, or if the requested book is not found or if none of the
copies of the book are available, the system will return a message indicating that the item is
not available. If both member ID and book ID are found and a copy is available, a new
checkout record entry is created, containing the copy of the requested book and the
checkout date and due date. This checkout entry is then added to the member’s checkout
record. The copy that is checked out is marked as unavailable. The updated checkout
record is displayed on the UI and is also persisted. The display of the checkout record uses a
JTable, with all cells of the table read-only (to see an example of a JTable, see the project
ProjectSwingSample code and the class TableExample in the tables package) .

4. Add a copy of an existing book to the library collection.
• An administrator can look up a book by ISBN and add a copy to the collection. The result is
then persisted.

5. Add a book to the library collection.
• An Administrator can add a book by selecting an “add book” option. The system responds by
displaying a screen with the necessary fields (ISBN, title, authors, maximum checkout length,
number of copies). When the data is submitted, it is persisted.

6. Given a library member id, print (to console) the checkout record of that library member
• The Librarian can search for a library member by ID, and then select an option to print the
checkout record. When this is done, the checkout record appears in the console with
aligned columns.
 Determine whether a given copy of a publication is overdue and which library member has it in
his/her possession.

7. “Overdue” means that the due date is before today and the status of the copy is “not
available”. This should be implemented by providing a special screen for searching for
books. The screen should make it possible to search for a book by ISBN, and the display
should show, in a read-only JTable, the ISBN, book title, copy numbers of each copy, which
library member (if any) has checked out a given copy, and when that copy is due back in the
library.



Project Developers
Eyouel Kenfu 
Adeley Ladejobi
Yohannes Seyoum Gebreslasie 
