-- Insertar un empleado nuevo en la nómina de trabajo.
INSERT INTO Empleados (dni, nombre, apellido, pais_FK, departamento_FK)
VALUES(
"3423654",
"Alexander",
"Lopez",
"Argentina",
"Logistica"
);
-- Modificar la nacionalidad de algún empleado.
UPDATE Empleados
SET pais_FK = "Ecuador"
WHERE dni = "3423654";

-- Eliminar un departamento.
DELETE FROM Departamentos
WHERE nombre = "Sistemas";

-- Conocer los empleados que trabajan en el departamento de “logística” (puede ser cualquiera de los que agreguen).
SELECT e.dni, e.nombre, e.apellido, e.pais_FK as pais, d.nombre as departamento, d.presupuesto
FROM Empleados AS e
INNER JOIN Departamentos AS d
ON e.departamento_fk = d.nombre;

-- Mostrar todos los departamentos ordenados alfabéticamente
SELECT nombre, presupuesto
FROM Departamentos
ORDER BY nombre;
