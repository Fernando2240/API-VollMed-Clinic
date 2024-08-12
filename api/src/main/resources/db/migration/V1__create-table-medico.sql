CREATE TABLE Medico(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    documento VARCHAR(10) NOT NULL UNIQUE,
    especialidad VARCHAR(100) NOT NULL,
    calle VARCHAR(50) NOT NULL,
    distrito VARCHAR(50) NOT NULL,
    complemento VARCHAR(50),
    numero VARCHAR(10),
    ciudad VARCHAR(100) NOT NULL
)