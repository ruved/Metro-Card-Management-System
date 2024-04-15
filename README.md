# Metro-Card-Management-System-
# Features
Admin:-
Login
Users
Address
Categories
Products
Price & discount
Orders
User:-
Registration & Login
Fetch categories and products based on category
Adding & deleting products to cart
Managing address and products quantity
Ordering products and fetching order status
# Security
The API is secured using JSON Web Tokens (JWT) handled by Auth0. To access the API, you will need to obtain a JWT by authenticating with the /login endpoint. The JWT should then be passed in the Authorize option available in the Swagger-ui.

Example:
Authorization: <your_jwt>
Technologies:
Java 17 or above
Spring Boot 3.0
Maven
MySQL
Spring Data JPA
Spring Security
JSON Web Tokens (JWT)
Auth0
Swagger UI
Running the app
Clone the repository: git clone https://github.com/Sirajuddin135/E-Commerce-Application.git
Import the project into STS:
Click File > Import...
Select Maven > Existing Maven Projects and click Next
Browse to the project directory and click Finish
Update the values in application.properties with your MySQL database connection details.
Run the app: Right-click the project in the Package Explorer and click Run As > Spring Boot App.
API documentation
API documentation is available via Swagger UI at http://localhost:8080/swagger-ui/index.html
