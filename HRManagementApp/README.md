## HR Management application

The HR Application will keep track of employees' access and leaves. The complete application revolves around employees only. Once an employee joins the company, the following attributes will be captured:

- First name
- Last name
- Role
- Reports To
- Leave balance
    - Sick leaves
    - Paid Leaves
- Contact
    - Email ID
    - Phone
- Address
    - City
    - Locality
    - State
    - Pin Code


**Every employee also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

The Employee with ID 0 denotes the CEO of the company, everybody except him/her reports someone else.

While onboarding an employee, there should be a proper check, such that he/she reports to a valid employee. As per company policy, every employee is entitled to 12 days of sick leave and 10 days of paid leaves in a year. While onboarding leave balances should be populated appropriately.

**There should be a different class called HR Application, which will be the interface for all customer-facing operations**:

1. Onboard an employee
2. Change manager of an employee
3. An employee should be able to apply for leave. An employee can apply for leave, only if there's sufficient balance for the corresponding leave type. Until the manager approves the leave, the leaves will be in an "Applied" state.
4. For each manager, there should be an option to see the pending leave application
5. Each manager can approve/reject a leave application. The leave state should be updated accordingly.
6. We should be able to get details of an employee with a given email ID or phone number. In case, the email or phone number is not valid, it should show appropriate failure messages.
7. For each manager, we should be able to list down the employee details, who are reporting to him/her.

There should be separate classes for managing Leaves. Leaves will be either of type Sick leave or Paid leave. Each leave should have a start date, end date & current status.