SELECT e.nombre AS NOMBRE, e.trabajo AS POUESTO FROM empleados AS e;

SELECT nombre FROM empleados WHERE Trabajo = "Comercial" OR Trabajo = "Mantenimiento" ORDER BY Nombre ASC;

SELECT e.nombre, e.trabajo, d.Nombre FROM empleados AS e, departamentos AS d WHERE e.Num_dept = d.Num_dept;

SELECT d.Nombre, p.Ano, p.Cantidad FROM departamentos AS d, presupuesto AS p WHERE d.Num_dept = p.Num_dept;
---------------------------------------------------------

-- Consulta 1
-- Obtener los datos completos de los empleados.
SELECT * FROM empleados;

-- Consulta 2
-- Obtener los datos completos de los departamentos.
SELECT * FROM departamentos;

-- Consulta 3
-- Obtener los datos de los Comerciales
SELECT * FROM empleados WHERE Trabajo = "Comercial";

-- Consulta 4
-- Idem. Pero ordenados por el nombre
SELECT * FROM empleados WHERE Trabajo = "Comercial" ORDER BY Nombre ASC;

-- Consulta 5
-- Hallar los datos de los Publicistas que cobren de salario más de 900 € ordenando el resultado descendentemente por ese salario.
SELECT * FROM empleados WHERE Trabajo = "Publicista" AND Salario > 900 ORDER BY Salario DESC;

-- Consulta 6
-- Obten el nombre y salario de los empleados
SELECT Nombre, Salario FROM empleados;

-- Consulta 7
-- Hallar el nombre de los departamentos
SELECT Nombre FROM departamentos;

-- Consulta 8
-- Idem. Pero ordenados por el nombre
SELECT Nombre FROM departamentos ORDER BY Nombre ASC;

-- Consulta 9
-- Lo mismo pero ordenando por la localización. Haz que aparezca ese campo en el resultado.
SELECT Nombre, Localizacion FROM departamentos ORDER BY Nombre ASC;

-- Consulta 10
-- Mostrar los nombres de los departamentos ordenados por su localización pero en orden inverso por su nombre.
SELECT Nombre FROM departamentos ORDER BY Localizacion DESC;

-- Consulta 11
-- Obtener el nombre, trabajo y salario de los empleados ordenado por salario.
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Salario;

-- Consulta 12
-- Ídem pero ordenando ahora por trabajo y descendentemente por el salario.
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Trabajo; 
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Salario DESC;

-- Consulta 13
-- Ídem pero ordenando inversamente por trabajo y ascendente por salario.
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Trabajo DESC;
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Salario DESC;

-- Consulta 14
-- Obtén los salarios y las comisiones de los empleados del departamento de marketing.
SELECT e.Salario, e.Comision FROM empleados AS e, departamentos AS d WHERE e.Num_dept = d.Num_dept;

-- Consulta 15
-- Ídem pero ordenando por comisión.
SELECT e.Salario, e.Comision FROM empleados AS e, departamentos AS d WHERE e.Num_dept = d.Num_dept ORDER BY e.Comision;

-- Consulta 16
-- Obtener los distintos trabajos que hay.
SELECT DISTINCT Trabajo FROM empleados;

-- Consulta 17
-- Obtener los distintos comisiones que hay.
SELECT DISTINCT Comision FROM empleados;

-- Consulta 18
-- Obtener los nombres de los distintos departamentos posibles sin repetirlos unidos junto con los trabajos posibles.
(SELECT DISTINCT Nombre FROM departamentos)
UNION
(SELECT DISTINCT Trabajo FROM empleados)
;