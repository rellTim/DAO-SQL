CREATE TABLE CUSTOMERS
(
    id           INT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255)       NOT NULL,
    surname      VARCHAR(255),
    age          VARCHAR(150)       NOT NULL,
    phone_number VARCHAR(50),
    PRIMARY KEY (id)
);
insert into customers(name, surname, age, phone_number)
values ('Timur', 'Petrov', 19, 7904),
       ('Ivan', 'Ivanov', 22, 7902),
       ('Viva', 'Ivanov', 53, 7914),
       ('Igor', 'Bit', 20, 7927);
CREATE TABLE ORDERS
(
    id           INT AUTO_INCREMENT NOT NULL,
    date         DATE               NOT NULL,
    customer_id  INT                NOT NULL,
    product_name VARCHAR(255)       NOT NULL,
    amount       DECIMAL(10, 2)     NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES dao.customers (id)
);

insert into orders(customer_id, product_name, amount)
values (1, 'product1', 200),
       (4, 'product2', 300),
       (3, 'product3', 400),
       (4, 'product4', 500),
       (2, 'product5', 600),
       (3, 'product6', 700),
       (2, 'product7', 800),
       (1, 'product8', 900);