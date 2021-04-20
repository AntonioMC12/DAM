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
SELECT Nombre FROM departamentos ORDER BY Localizacion, Nombre DESC;

-- Consulta 11
-- Obtener el nombre, trabajo y salario de los empleados ordenado por salario.
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Salario;

-- Consulta 12
-- Ídem pero ordenando ahora por trabajo y descendentemente por el salario.
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Trabajo, Salario DESC;

-- Consulta 13
-- Ídem pero ordenando inversamente por trabajo y ascendente por salario.
SELECT Nombre, Trabajo, Salario FROM empleados ORDER BY Trabajo DESC, Salario DESC;

-- Consulta 14
-- Obtén los salarios y las comisiones de los empleados del departamento de marketing.
SELECT e.Salario, e.Comision FROM empleados AS e, departamentos AS d WHERE e.Num_dept = d.Num_dept AND d.Nombre="Marketing";

-- Consulta 15
-- Ídem pero ordenando por comisión.
SELECT e.Salario, e.Comision FROM empleados AS e, departamentos AS d WHERE e.Num_dept = d.Num_dept AND d.Nombre="Marketing" ORDER BY e.Comision;

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

-- Consulta 19
-- Obtenga  los  nuevos  salarios  que  resultarían  de  sumar  a  los  empleados  del  departamento  de desarrollo una gratificación de 135 unidades monetarias. 
SELECT e.salario+135 FROM empleados AS e, departamentos AS d WHERE e.Num_dept = d.Num_dept AND d.Nombre = "Desarrollo";

-- Consulta 20
-- Ídem pero obteniendo también el salario anterior.
SELECT e.salario+135, e.salario FROM empleados AS e, departamentos AS d WHERE  e.Num_dept = d.Num_dept AND d.Nombre = "Desarrollo";

-- Consulta 21
-- Hallar  los  empleados  que  tienen  una  comisión  superior  al  11%  de  su  salario.  Mostrar  en  el resultado también el salario y la comisión.
SELECT Nombre, Salario, Comision FROM empleados WHERE Comision > (0.11*Salario);

-- Consulta 22
-- Ídem  para  aquellos  empleados  cuya  comisión  incrementada  en  un  50%  es  menor  o  igual  que  el 15% del sueldo. 
SELECT Nombre, Salario, Comision FROM empleados WHERE ((Comision*1.5) <= (0.15*Salario));

-- Consulta 23
-- Haga que en cada fila figure “Empleado” y “Puesto” anteponiéndose a los valores de los nombres de empleado y su trabajo. 
SELECT CONCAT("Empleado: ", Nombre) AS Nombre, CONCAT("Puesto: ", Trabajo) AS Puesto FROM empleados;

-- Consulta 24
-- Hallar el salario y la comisión de los empleados cuyo número de supervisados es superior a 1.
SELECT e1.Nombre FROM empleados AS e1, empleados AS e2 WHERE  e1.Num_emp = e2.supervisor-- AND COUNT(e2.supervisor)>1; <- muestra los supervisores


-- Consulta 25
-- Si dividimos los empleados en dos grupos, A y B, empezando el nombre de los del grupo B en la letra “J”, obtén los nombres y trabajos de los del grupo B, por orden alfabético descendente. 
SELECT nombre, trabajo FROM empleados 
WHERE nombre >= "j"
ORDER BY nombre DESC
;

-- Consulta 26
-- Obtener  el  salario,  la  comisión  y  el  salario  total (salario  +  comisión)  de  los  empleados  con comisión, ordenado por salario total de forma descendente. Usa un alias para el salario total. 
(SELECT nombre, salario, comision, comision+salario total
FROM empleados
WHERE comision IS NOT NULL
)
UNION(SELECT nombre, salario, 0, salario total
FROM empleados
WHERE comision IS NULL
)
ORDER BY total DESC
;

-- Consulta 28
-- Hallar  el  nombre  y  salario  de  los  empleados  que,  teniendo  un  salario  superior  a  800  unidades monetarias tienen como supervisor a la empleada “Fatima Merino”.
SELECT nombre, salario
FROM empleados
WHERE salario>800
AND 
supervisor = (SELECT Num_emp FROM empleados WHERE nombre = "Fatima Merino");

-- Consulta 29
--Halla  el  conjunto  complementario  del  resultado  del ejercicio  anterior,  es  decir  aquellos  cuyo supervisor no sea ese empleado pero que si superen aquella cantidad. 
SELECT nombre, salario
FROM empleados
WHERE salario>800
AND 
if(supervisor != (SELECT Num_emp FROM empleados WHERE nombre = "Fatima Merino"),true,false)
;