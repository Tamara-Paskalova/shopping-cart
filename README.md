# shopping-cart
This is a very simple server-side project. It has two main entities: 
Product and Shopping Cart, and one auxiliary entity Type, which defines
the product type.
The project has dao, service and controller layers, as well as dto classes.
#### Technologies used:
- Spring Boot
- Hibernate
- MySQL
- Java 11
- Maven

Before starting, you should configure `application.properties` file
and add your MySQL username and password. 

#### Controllers and methods


- `POST:/shopping-carts`- create a new empty shopping cart 
- `PUT:/shopping-carts/add/{id}` - add the product to shopping cart
- `PUT:/shopping-carts/{id}` - remove the product from shopping cart 
- `POST:/products` - add new product

First, create an empty cart. Then create some product.
After that, you can add items to your cart.
When you add or remove an item from cart, the program calculates the total 
purchase price and returns it along with the list of items in the cart.
If the list contains more than two products of the same type, their cost is reduced by 10%.
If the total value of the cart exceeds 100, you will receive a 10% discount on the entire 
amount.
Some product types are already provided and will be automatically loaded into the database at startup.
