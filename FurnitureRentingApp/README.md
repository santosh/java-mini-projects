## Furniture Renting

Furniture renting application keeps track of furniture and rents them among customers. The application majorly maintains 2 entities: furniture and customer.

**A customer can register into the system with the following attributes**:

- First name
- Last name
- Contact
  - Email ID
  - Phone
- Address
  - Apartment
  - City
  - Locality
  - State
  - Pin Code


Once the user completes registration, the system should also capture the time(Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered.

**Furnitures can be added to the system with the following attributes**:

- Title
- Description
- Color
- Length
- Width
- Leight
- Monthly rent
- Type of furniture
- Suitable rooms
- Quantity in stock

**Both furniture and customers will also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

**The application should also keep track of the rent invoices, containing the following details**:

- ID (ID needs to be generated from counter variable n the same way as of customer & furnitures)
- Furniture ID
- Customer ID
- Amount
- Status
- Start date
- End date 
- Delivery Address
  - Apartment
  - City
  - Locality
  - State
  - Pin Code

**There should be a central class for maintaining the application, which provides the interfaces for the following operations**:

1. Register a customer
2. Add a furniture
3. Add more stocks for a specific furniture
4. Search for furniture based on the type of furniture. It should show only from the list of available ones, sorted by monthly rent in ascending order.
5. The customers should also search the furniture based on both color and type of furniture in similar manner.
6. Rent a furniture to a user. This should also generate the rent invoice for that customer.
7. Cancel a rent invoice. The user can cancel a rent invoice, only before the start date, free of cost. Once the start date has begun, the invoice can no longer be cancelled.
8. Return furniture post the end period for renting.