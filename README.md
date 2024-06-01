<div style="font-family: Arial, sans-serif; font-size: 16px;">

# <span style="font-size: 24px; font-weight: bold;">Basic Banking System</span>

## Description

For this project, our task is to build a basic banking system that allows customers to view their balance, make deposits, and withdraw funds from their accounts. Before writing any code, let's examine our challenge, design a solution, and identify our assumptions.

We have a database with two tables: customers and accounts. These both represent objects within our application that we'll need to interact with, so we can develop Java classes that represent both of these. We'll also need to account for the actions or behaviors of our system, so we'll need methods to check the balance of an account, deposit, and withdraw. These are behaviors a customer makes on an account so we'll need a link between these two objects.

If we look at our database, the Customers table has a field called ACCOUNT_ID, and the Accounts table has a field called ID. These two IDs tie the customer to their account, so we can certainly keep that in mind when implementing our application. In fact, for security purposes, we should authenticate the customer before we allow any actions to be taken on an account. The database hosts fields for username and password, so we can create an authenticator class that will verify the customer's credentials.

All of this implementation occurs on the backend, so we'll also need to provide an interface that allows the user to enter input and let us know what actions they'd like to make. We'll keep it simple and build a menu class that provides a text-based user interface capable of input and output. And finally, because we'll need to read and write from our database, it's best to consolidate the code that does this within one class, so we'll make a data store class as well.

## Assumptions

- A customer only has one account.
- An account only has one customer.
- All accounts are checking accounts.

</div>
