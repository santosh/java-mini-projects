## Telephone directory

The telephone directory application will maintain the list of users and their phone numbers. **Each user will have the following details**:

- Phone number
- First name
- Last name
- City
- State
- Picture
- Last seen timestamp

**The users will also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

Once the user completes registration, the system should also capture the time (Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered.

Every user will have a subscription to the application. By default, all the users will be having a free subscription available. In the free subscription, a user can do only upto 10 searches a day. A user can buy the premium subscription of the application by paying the subscription cost. Once the premium subscription is availed, the user can do unlimited searches per day.

The cost of a premium subscription is fixed at the application level. There will be a global call named TeleCallerApp, which will store all the user's contacts. It will also store the search history of all users.

**The TeleCallerApp will also provide an interface for the following operations**:

1. Add a user's contact
2. Update a specific user's contact
3. Update a list of user's contact
4. Search for a user by phone number
5. Search a user's contact by his/her name
6. Search all users, where the name contains a keyword. E.g. Search for users, where the name of the user contains the word "elvi". it will return the users having "Kelvin" as their first name. If there is another user present with the first name "Elvis'', then that user should also be displayed. **Hint: Use the "contains" method available in the Java String class**.
7. Avail premium subscription for a user
8. Get the search history of a specific user.

All the search operations need to be case insensitive. **For operations numbered 5 & 6, the search needs to be done in both first & last name**. Each operation needs to have proper validations. Like once a user has exhausted the search limit of free subscriptions, appropriate error messages should be shown.