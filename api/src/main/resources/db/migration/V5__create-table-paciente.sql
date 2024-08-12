CREATE TABLE Paciente(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    documento VARCHAR(10) NOT NULL UNIQUE,
    calle VARCHAR(100) NOT NULL,
    distrito VARCHAR(100) NOT NULL,
    complemento VARCHAR(100),
    ciudad VARCHAR(100) NOT NULL,
    numero VARCHAR(20),
    telefono VARCHAR(10) NOT NULL,
    activo BOOLEAN NOT NULL
)