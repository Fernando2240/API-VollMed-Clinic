CREATE TABLE Consulta(
    id SERIAL PRIMARY KEY,
    medico_id INT4 NOT NULL,
    paciente_id INT4 NOT NULL,
    fecha TIMESTAMP NOT NULL,
    FOREIGN KEY(medico_id) REFERENCES Medico(id),
    FOREIGN KEY(paciente_id) REFERENCES Paciente(id)

)