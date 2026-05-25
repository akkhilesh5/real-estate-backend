-- Create Users table
CREATE TABLE IF NOT EXISTS realestate.users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Agents table
CREATE TABLE IF NOT EXISTS realestate.agents (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(100) NOT NULL,
    review DECIMAL(3,2) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);

-- Create Property Managers table
CREATE TABLE IF NOT EXISTS realestate.property_managers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(100) NOT NULL,
    review DECIMAL(3,2) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);

-- Create Properties table
CREATE TABLE IF NOT EXISTS realestate.properties (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    bedrooms INT NOT NULL,
    bathrooms INT NOT NULL,
    area DECIMAL(10,2) NOT NULL,
    listingType INT NOT NULL CHECK (listingType IN (1, 2, 3))
);

-- Create Transactions table
CREATE TABLE IF NOT EXISTS realestate.transactions (
    id SERIAL PRIMARY KEY,
    userId BIGINT REFERENCES realestate.users(id),
    propertyId BIGINT REFERENCES realestate.properties(id),
    amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(50) NOT NULL
);