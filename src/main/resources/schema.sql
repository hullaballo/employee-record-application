CREATE TABLE employee (
    id              INT PRIMARY KEY,
    first_name      VARCHAR2(20) NOT NULL,
    last_name       VARCHAR2(20) NOT NULL,
    department      VARCHAR2(30) NOT NULL,
    salary          NUMERIC NOT NULL,
    start_date      DATE NOT NULL,
    office_location VARCHAR2(20) NOT NULL,
    winner          BOOLEAN DEFAULT FALSE
);

