## Library Management System

Library management system will be responsible for managing a Library and its associated entities appropriately. Here, there are 3 major entities: books, writers & users.

**Each of these entities will have 2 attributes in common**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

**In the Library, we can add a book with the following attributes**:

1. Title
2. ISBN
3. Authors
4. category
5. Release year
6. Awards received

We should also be able to keep track of the inventory of books: while adding a book in the stock, we can provide the initial stock quantity, later on, we can also add more copies of the same book. Every book should be linked to its authors. We should be able to get details of the authors of a specific book.

**We can also add a writer in the system, with the following details**:

1. First Name
2. Last Name
3. Awards received
4. Active since

We should also be able to retrieve all the books a writer has authored or co-authored. Also, on what topics, a specific writer has written books.

**The system will have the provision of registering users with the following attributes**:

- First name
- Last name
- Contact
  - Email ID
  - Phone
- Address
  - City
  - Locality
  - State
  - Pin Code

Once the user completes registration, the system should also capture the time(Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered. A User should be able to have a maximum of 3 books at any point of time.

The Library management application should be able to track the book's inventory and user's book allotment history. The following operations should be supported in the same class:

1. Register an user
2. Add a writer
3. Add a new book
4. Add copies of an existing book
5. Allocate a copy of a book to an user
6. Return a copy of the book
7. Get books of an author
8. Get books of a specific category.

All these operations should have the required validations in place, like: a user can't have more than three books at a time. Book, writer and user identifier should be valid.