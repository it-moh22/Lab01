-- Delete existing data to avoid conflicts
DELETE FROM customer_phonenumbers;
DELETE FROM vehicle_options;
DELETE FROM sales;
DELETE FROM flowers;
DELETE FROM inventories;
DELETE FROM suppliers;
DELETE FROM employees;

-- Insert Customers
INSERT INTO suppliers (
    customer_identifier,
    last_name,
    first_name,
    email_address,
    username,
    password,
    street_address,
    city,
    province,
    postal_code
)
VALUES
    ('123e4567-e89b-12d3-a456-556642440000', 'Smith', 'John', 'john.smith@example.com', 'sjhon', 'pwd1', '123 Maple Street', 'Toronto', 'Ontario', 'M1M 1M1'),
    ('223e4567-e89b-12d3-a456-556642440001', 'Johnson', 'Emily', 'emily.johnson@example.com', 'jemily', 'pwd2', '456 Oak Avenue', 'Vancouver', 'British Columbia', 'V6B 2W1'),
    ('423e4567-e89b-12d3-a456-556642440003', 'Patel', 'Sara', 'sara.patel@example.com', 'psara', 'pwd4', '321 Pine Street', 'Calgary', 'Alberta', 'T2N 4T4'),
    ('523e4567-e89b-12d3-a456-556642440004', 'Garcia', 'Luis', 'luis.garcia@example.com', 'lgarcia', 'pwd5', '987 Birch Road', 'Montreal', 'Quebec', 'H3B 4W3'),
    ('623e4567-e89b-12d3-a456-556642440005', 'Chen', 'Ming', 'ming.chen@example.com', 'mchen', 'pwd6', '741 Elm Street', 'Edmonton', 'Alberta', 'T5J 3G7');

-- Insert Supplier PhoneNumbers
INSERT INTO customer_phonenumbers (customer_id, phone_type, phone_number)
VALUES
    (1, 'MOBILE', '5143456750'),
    (2, 'HOME', '4383456751'),
    (3, 'HOME', '5143451234'),
    (4, 'WORK', '6135556789'),
    (5, 'MOBILE', '9057774321');

-- Insert Employees
INSERT INTO employees (
    employee_identifier,
    first_name,
    last_name,
    email,
    job_title
)
VALUES
    ('EMP-001', 'Alice', 'Johnson', 'alice.johnson@example.com', 'Sales Manager'),
    ('EMP-002', 'Bob', 'Williams', 'bob.williams@example.com', 'Finance Analyst'),
    ('EMP-003', 'Charlie', 'Brown', 'charlie.brown@example.com', 'Sales Representative'),
    ('EMP-004', 'Diana', 'Martinez', 'diana.martinez@example.com', 'Supplier Support'),
    ('EMP-005', 'Evan', 'Davis', 'evan.davis@example.com', 'Finance Specialist');

-- Insert Inventories
INSERT INTO inventories (inventory_identifier, type)
VALUES
    ('INV001', 'New Cars'),
    ('INV002', 'Used Cars'),
    ('INV003', 'Luxury Vehicles'),
    ('INV004', 'Electric Vehicles');

-- Insert Vehicles
INSERT INTO flowers (
    vin,
    inventory_id,
    vehicle_status,
    usage_type,
    vehicle_year,
    manufacturer,
    make,
    model,
    body_class,
    price_amount,
    price_currency,
    price_payment_currency
)
VALUES
    ('5N1AR1NB3CC804298', 'INV001', 'AVAILABLE', 'NEW', 2023, 'Nissan', 'Rogue', 'S', 'SUV', 25000.00, 'CAD', 'CAD'),
    ('1HGCM82633A123456', 'INV002', 'SALE_PENDING', 'USED', 2020, 'Honda', 'Civic', 'LX', 'Sedan', 18000.00, 'USD', 'USD'),
    ('WBA3A5C52CF338499', 'INV003', 'AVAILABLE', 'NEW', 2024, 'BMW', '320i', 'M Sport', 'Sedan', 45000.00, 'CAD', 'USD'),
    ('4T1BF1FK0EU311987', 'INV004', 'AVAILABLE', 'NEW', 2023, 'Toyota', 'Camry', 'SE', 'Sedan', 32000.00, 'CAD', 'CAD'),
    ('JN8AZ2KR5DT308617', 'INV002', 'AVAILABLE', 'USED', 2021, 'Infiniti', 'QX80', 'Luxury', 'SUV', 68000.00, 'USD', 'USD');

-- Insert Flowers Options
INSERT INTO vehicle_options (vehicle_id, option_name, option_description, option_price)
VALUES
    (1, 'Sunroof', 'Electric sunroof', 1200.00),
    (1, 'Leather Seats', 'Premium leather interior', 1500.00),
    (2, 'Backup Camera', 'Rear-view backup camera', 800.00),
    (3, 'Heated Seats', 'Front and rear heated seats', 1000.00),
    (4, 'Bluetooth', 'Wireless connectivity', 600.00),
    (5, 'Adaptive Cruise Control', 'Advanced driver-assistance system', 2000.00);

-- Insert Sales (Updated to match your existing data)
INSERT INTO sales (
    purchase_id,
    sale_status,
    number_of_monthly_payments,
    monthly_payment_amount,
    down_payment_amount,
    sale_offer_date,
    amount,
    currency,
    payment_currency,
    warranty_end_date,
    warranty_terms,
    inventory_id,
    vin,
    customer_id,
    employee_id
)
VALUES
    ('05c8ab76-4f75-45c1-b6e2-aa8e914ea08f', 'PURCHASE_OFFER', 36, 1805.56, 10000.00, '2024-02-13', 75000.00, 'USD', 'CAD', '2027-02-13', 'Basic Warranty: The basic warranty covers the flower...', 'INV001', '5N1AR1NB3CC804298', '423e4567-e89b-12d3-a456-556642440003', 'EMP-001'),

    ('10c9db89-5f89-43c2-b781-aa9e512ea29c', 'PURCHASE_NEGOTIATION', 48, 1250.75, 5000.00, '2024-03-21', 55000.00, 'CAD', 'CAD', '2028-03-21', 'Extended Warranty: Covers major components for up to 5 years.', 'INV003', 'WBA3A5C52CF338499', '123e4567-e89b-12d3-a456-556642440000', 'EMP-003'),

    ('25b3ea21-6f92-45b1-8a24-bcd3412ff87a', 'PURCHASE_COMPLETED', 60, 950.00, 7000.00, '2023-11-10', 32000.00, 'CAD', 'USD', '2026-11-10', 'Manufacturer Warranty: 3 years or 60,000 km.', 'INV004', '4T1BF1FK0EU311987', '223e4567-e89b-12d3-a456-556642440001', 'EMP-002'),

    ('89a4fc12-7b98-45c6-a90c-dc1a4b6f98ea', 'PURCHASE_CANCELED', 24, 2800.00, 15000.00, '2024-01-15', 68000.00, 'USD', 'USD', '2029-01-15', 'Elite Warranty: 5 years unlimited coverage.', 'INV002', 'JN8AZ2KR5DT308617', '523e4567-e89b-12d3-a456-556642440004', 'EMP-004');
