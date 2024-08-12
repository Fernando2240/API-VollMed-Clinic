ALTER TABLE Medico ADD COLUMN activo BOOLEAN;
UPDATE Medico SET activo=true;