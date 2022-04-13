## Expense reimbursement portal

Expense reimbursement portal will be used for managing the invoices submitted for expense claims for a  company. Each vertical/department in a company can have their own budget for a specific type of expense.

There will be a set of different types of expenses defined in the system level: likes: relocation, travel, morale etc. Every expense request needs to be submitted against one of these fixed sets of expense types.

**For each department in a company, the following details need to be stored**:

- Department Name
- Total number of employees
- Total budget for different types of expenses for each employee
- Total amount spent for each type of expenses across all employees

**Once an employee joins the company, the following attributes will be captured**:

- First name
- Last name
- Role
- Reports To
- Department ID
- Contact
  - Email ID
  - Phone
- Address
  - City
  - Locality
  - State
  - Pin Code

**Every employee, Department, Expense reimbursement request also have these 2 attributes**:

- Instance level attribute "ID"
- Static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1.

The Employee with ID 0 denotes the CEO of the company, everybody except him/her reports someone else. While onboarding an employee, there should be a proper check, such that he/she reports to a valid employee or whether the employee belongs to a valid department.

**Every expense reimbursement request should contain the following details other than ID & counter**:

- Expense type
- Amount of expenditure
- Date for the expense
- Employee ID
- Approver ID
- Timestamp for request submission.
- Status

**No expense request can be submitted, in case**:

- If the date of expense is older than 1 month from today's date or
- The amount requested is more than the budget allocated for that expense

An expense request can be approved by the manager of the employee. **A global application class needs to be created for providing interface for the following operations**:

1. Add a department
2. Onboard an employee
3. Change manager of an employee
4. An employee should be able to submit an expense reimbursement request. Until the manager approves the request, the leaves will be in "Submitted" state.
5. For each manager, there should be option to see the pending requests for approval
6. Each manager can approve/reject a reimbursement request. The request status should be updated accordingly.
7. For each department, we should be able to see the current available budget for different expense types
8. For each department, we should be able to see the total expense made so far across all employees for each type of expense.