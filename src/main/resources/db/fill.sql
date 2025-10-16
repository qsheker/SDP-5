-- USERS
INSERT INTO users (id, username, email, password)
VALUES
    (1, 'aldiyar', 'aldiyar@example.com', '1234'),
    (2, 'turbozone', 'turbozone@example.com', '5678');

-- PRODUCTS
INSERT INTO products (id, name, description, price)
VALUES
    (1, 'iPhone 15 Pro', 'Flagship smartphone from Apple', 4999.00),
    (2, 'MacBook Air M3', 'Ultra-thin laptop with Apple Silicon', 8999.00),
    (3, 'AirPods Pro 2', 'Wireless earbuds with noise cancellation', 999.00);

-- CARDS
INSERT INTO cards (id, user_id, card_holder_name, card_number, expiration_date, cvv)
VALUES
    (1, 1, 'Aldiyar T.', '4000123412341234', '12/28', '123'),
    (2, 2, 'Turbo Z.', '4111111111111111', '11/27', '456');

-- ORDERS
INSERT INTO orders (id, user_id, total_amount, status)
VALUES
    (1, 1, 13998.00, 'PAID'),
    (2, 2, 999.00, 'NEW');

-- ORDER_PRODUCTS (many-to-many link)
INSERT INTO order_products (order_id, product_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3);
