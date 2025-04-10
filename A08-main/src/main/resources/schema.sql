-- -------------------------------------------------------------------------
-- DROP OLD TABLES IF THEY EXIST
-- -------------------------------------------------------------------------
DROP TABLE IF EXISTS customer_phonenumbers;
DROP TABLE IF EXISTS vehicle_options;
DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS flowers;
DROP TABLE IF EXISTS inventories;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS employees;

-- -------------------------------------------------------------------------
-- CREATE CUSTOMERS TABLE
-- -------------------------------------------------------------------------
CREATE TABLE suppliers (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           customer_identifier VARCHAR(36) NOT NULL UNIQUE,
                           last_name VARCHAR(50) NOT NULL,
                           first_name VARCHAR(50) NOT NULL,
                           email_address VARCHAR(100),
                           username VARCHAR(50),
                           password VARCHAR(50),
                           street_address VARCHAR(100), -- from Address embedded
                           city VARCHAR(50),
                           province VARCHAR(50),
                           postal_code VARCHAR(20)
);

-- Supplier phone numbers (ElementCollection)
CREATE TABLE customer_phonenumbers (
                                       customer_id INT NOT NULL,
                                       phone_type VARCHAR(20),
                                       phone_number VARCHAR(20),
                                       FOREIGN KEY (customer_id) REFERENCES suppliers(id)
);

-- -------------------------------------------------------------------------
-- CREATE EMPLOYEES TABLE
-- -------------------------------------------------------------------------
CREATE TABLE employees (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           employee_identifier VARCHAR(36) NOT NULL UNIQUE,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           email VARCHAR(100),
                           job_title VARCHAR(50)
);

-- -------------------------------------------------------------------------
-- CREATE INVENTORIES TABLE
-- -------------------------------------------------------------------------
CREATE TABLE inventories (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             inventory_identifier VARCHAR(36) NOT NULL UNIQUE,
                             type VARCHAR(50)
);

-- -------------------------------------------------------------------------
-- CREATE VEHICLES TABLE
-- -------------------------------------------------------------------------
CREATE TABLE flowers (
                          id INT AUTO_INCREMENT PRIMARY KEY,

    -- flowersIdentifier
                          vin VARCHAR(17) NOT NULL UNIQUE,

    -- inventoryIdentifier
                          inventory_id VARCHAR(36) NOT NULL,

    -- status/usage
                          vehicle_status VARCHAR(50),
                          usage_type VARCHAR(20),
                          vehicle_year INT,

    -- basic info
                          manufacturer VARCHAR(50),
                          make VARCHAR(50),
                          model VARCHAR(50),
                          body_class VARCHAR(50),

    -- embedded Price
                          price_amount DECIMAL(19,2),
                          price_currency VARCHAR(3),
                          price_payment_currency VARCHAR(3),

                          FOREIGN KEY (inventory_id) REFERENCES inventories(inventory_identifier)
);

-- Flowers options (ElementCollection)
CREATE TABLE vehicle_options (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 vehicle_id INT NOT NULL,
                                 option_name VARCHAR(50),
                                 option_description VARCHAR(200),
                                 option_price DECIMAL(10,2),
                                 FOREIGN KEY (vehicle_id) REFERENCES flowers(id)
);

-- -------------------------------------------------------------------------
-- CREATE SALES TABLE (PurchaseOrder)
-- -------------------------------------------------------------------------
CREATE TABLE sales (
                       id INT AUTO_INCREMENT PRIMARY KEY,

    -- PurchaseOrderIdentifier
                       purchase_id VARCHAR(36) NOT NULL UNIQUE,

    -- enumerated PurchaseStatus
                       sale_status VARCHAR(50),

    -- Financing
                       number_of_monthly_payments INT,
                       monthly_payment_amount DECIMAL(19,2),
                       down_payment_amount DECIMAL(19,2),

                       sale_offer_date DATE,

    -- embedded Price
                       amount DECIMAL(19,2),
                       currency VARCHAR(3),
                       payment_currency VARCHAR(3),

    -- embedded Warranty
                       warranty_end_date DATE,
                       warranty_terms VARCHAR(250),

    -- references for external IDs
                       inventory_id VARCHAR(36),    -- references inventory_identifier
                       vin VARCHAR(17),             -- references FlowersIdentifier
                       customer_id VARCHAR(36),     -- references customer_identifier
                       employee_id VARCHAR(36)      -- references employee_identifier
);
