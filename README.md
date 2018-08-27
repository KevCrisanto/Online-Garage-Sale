# Online Garage Sale

Online Garage Sale, is a web application developed with Angular 6 and Java EE (Hibernate) which allows for the buying and selling of products.

# Features

## Different types of users

### Unverified users

A user can register for an account and view available items for sale but is unable to sell items.

### Verified users

Once an user is verified by an administrator, the user can sell items.

### Premium users

A user may also choose to upgrade to a premium membership which allows for the additional features such as premium ratings.

### Administrator

The administrator has access to all accounts and items and can remove accounts and items deemed unprofessional.

## Registration and authentication

Users can register and login. Their initial role is 'unverified user'.
![registration](/images/registration.gif)

## Sell items

Verified and premium users can sell items.
![sell](/images/sell.gif)

## Buy Items

Any user can buy items. We check if the credit card number has a valid pattern without hitting the database.
![buy](/images/buy.gif)

## Admin powers

Administrators can delete or verify users. They can also delete any items.
![admin](/images/admin.gif)

## Ratings

Users can rate a seller after a transaction. There's two types of raings: standard (for normal users) and premium (for premium users).

![ratings](/images/ratings.png)

# Testing

## JUnit

The backend was thoroughly tested with JUnit. We followed the Test Driven Development (TDD) methodology, so every function has been tested to make sure it is working.

## Selenium

We used Selenium for UI testing. We tested every page and developed several end-to-end tests.
