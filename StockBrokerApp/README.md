## Stock Broker

The Stock Broker application keeps track of stocks of multiple companies and notifies the various brokers about the change in prices of the stocks they have subscribed to.

**Every stock should be holding the following attributes**:

- Stock Symbol
- Current price
- launch timestamp
- Company name

Each stock should be uniquely identifiable by its stock Symbol.

**Brokers can register in the system with the following attributes**:

- First name
- Last name
- Contact
  - Email
  - Phone
- City
- Locality

**The broker will also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

Once the user completes registration, the system should also capture the time(Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered. **There will also be an application class for providing interfaces for all of the following operations**:

1. Register a broker
2. Add a stock
3. Update a specific stock's price. This should notify all the brokers who have subscribed to that specific stock
4. Each broker can subscribe to various stocks
5. Each broker should also be able to unsubscribe from a specific stock
6. Each broker should be able to buy a stock
7. Each broker should also be able to sell a stock
8. For each broker, we should be able to provide how much profit/loss that broker has made for each of the stocks.


**Bonus**: Try to apply the **Observer design pattern**. You can learn about the **Observer design pattern** from [here](https://www.baeldung.com/java-observer-pattern) and then try to implement it. You can also use the online resources available to understand the concept.