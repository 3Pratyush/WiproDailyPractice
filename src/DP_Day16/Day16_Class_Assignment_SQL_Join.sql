Create Database EcommerceDB;
use EcommerceDB;

Create table Customer(customer_id int primary key,
customer_name varchar(50),city varchar(50));

Create table Products(product_id int primary key,
product_name varchar(50),price decimal(10,2));

Create table Orders(order_id int primary key,
customer_id int,product_id int,order_date date,
foreign key(customer_id) references Customer(
customer_id),foreign key(product_id) references Products(
product_id));

Create table Payment(payment_id int primary key,
order_id int, amount decimal(10,2),payment_method varchar(50),
foreign key(order_id) references Orders(order_id));

Insert into Customer Values(1,'John','New York'),
(2,'Michael','England'),(3,'David','Australia'),(4,'Shaurya','India');

Insert into Products Values(101,'Laptop',65000),
(102,'Mobile',20000),(103,'Headphone',2500),(104,'Keyboard',1000);

Insert into Orders Values(1001,1,101,'2026-05-01'),(1002,2,102,'2026-05-02'),
(1003,3,103,'2026-05-03'),(1004,4,104,'2026-05-04');

Insert into Payment Values(5001,1001,65000,'Credit Card'),(5002,1002,20000,'UPI'),
(5003,1003,2500,'Debit Card');

Select Customer.customer_name,Orders.order_id from Customer inner join
Orders on Customer.customer_id = Orders.customer_id;

Select Orders.order_id,Products.product_name from Orders inner join
Products on Orders.product_id = Products.product_id;

Select Customer.customer_name,Orders.order_id from Customer left join
Orders on Customer.customer_id = Orders.customer_id;

Select Orders.order_id,Products.product_name from Orders left join
Products on Orders.product_id = Products.product_id;

Select Customer.customer_name,Orders.order_id from Customer right join
Orders on Customer.customer_id = Orders.customer_id;

Select Orders.order_id,Products.product_name from Orders right join
Products on Orders.product_id = Products.product_id;

Select Customer.customer_name,Orders.order_id from Customer left join
Orders on Customer.customer_id = Orders.customer_id union
Select Customer.customer_name,Orders.order_id from Customer right join
Orders on Customer.customer_id = Orders.customer_id;

Select A.customer_name as Customer1,B.customer_name as Customer2,A.city
from Customer A join Customer B on A.city=B.city and 
A.customer_id<>B.customer_id;