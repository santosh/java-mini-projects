## Messaging App

In this assignment, we will be building a messaging app, where users can send messages to other users personally or in a group.

**The users can register with the following attributes**:

- First name
- Last name
- Contact
    - Email ID
    - Phone
- Link to Profile picture
- Status Message

Once the user completes registration, the system should also capture the time (Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered. **Every user will also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 1. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

The system should also keep track of one-to-one(private) and group messages for a user with proper messages. **Both private and group messages will have a set of common attributes and a few attributes specific to the type of the message. The common attributes will be**:

- Message-ID(All messages should have counter and ID similar to that of user ID & counter)
- Message Text
- Sender user ID
- Sending timestamp

The value of message ID should remain unique across private and group chat messages.

**Note: You can achieve this by using a common parent class of both the types of messages and implementing the ID & counter population logic in the Superclass constructor**.

**The following attributes will belong to private messages only**:

- Receiver user ID
- Received timestamp
- Message status[Unread or Read]

**The following attributes will belong to only group chat messages**:

- Group ID
- Received timestamps [A map of user ID and their respective received timestamps]
- The message read statuses [A map of User ID and the respective messages]

**A Group will contain the following information**:

- Group ID
- Group name
- Group Icon link
- List of admin user IDs
- List of non-admin member user IDs
- Creation timestamp

Another class needs to be created for running the functionalities together, let's call it MessagingApp. **The messaging app should support the following operations**:

1. Register a user
2. Send private messages from one person to another
3. Receive all chats with their most recent message for a user with respective statuses
4. See specific private chat's messages
5. Create a group of users
6. Adding a user to a group
7. See a group messages for a user


For all operations, the timestamp and message statuses have to be populated automatically. When a message is sent, the sending timestamp should be captured as the sending timestamp and the message status will be set as "Unread" for all users in the group or private chat. **Once a user enters a private/group chat, only then the corresponding message's status will be set to "Read" for that specific user**.