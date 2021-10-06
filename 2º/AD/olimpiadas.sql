----------------------------------------------------------------------------
--Cuantos eventos hay en la sede de Córdoba
SELECT
    COUNT(ev.id)
FROM
    evento as ev
    JOIN area as ar ON ev.id_area = ar.id
    JOIN complejo as co ON ar.id_complejo = co.id
    JOIN sede as sd ON co.id_sede = sd.id
WHERE
    sd.nombre = "Córdoba";

----------------------------------------------------------------------------

----------------------------------------------------------------------------
--¿Cuántas veces ha ejercido de juez cada comisario?
SELECT
    co.nombre AS NOMBRE,
    COUNT(*) AS N_JUEZ
FROM
    comisario as co
    LEFT JOIN evento_comisario as ec ON co.id = ec.id_comisario 
    JOIN evento as e ON ec.id_evento = e.id
WHERE 
    ec.rol = 1
GROUP BY
    co.id
;
    
----------------------------------------------------------------------------

----------------------------------------------------------------------------
--¿Cuántos eventos ya se han celebrado ha fecha de hoy?
SELECT 
    COUNT(*) AS N_EVENTOS
FROM
    evento AS e
WHERE
    e.fecha < NOW()
;


----------------------------------------------------------------------------

----------------------------------------------------------------------------
--¿Cuál es el área total calculada de cada complejo?
SELECT
    c.nombre AS NOMBRE,SUM(a.area) AS AREA_TOTAL
FROM
    complejo AS c
    LEFT JOIN area AS a ON c.id = a.id_complejo
GROUP BY 
    c.id;

----------------------------------------------------------------------------

----------------------------------------------------------------------------
--¿Lista por número de eventos de mayor a menos los complejos multideporte?
SELECT
    c.nombre AS NOMBRE, COUNT(e.id) AS N_EVENTOS
FROM
    complejo AS c
    LEFT JOIN area AS a ON c.id = a.id_complejo
    JOIN evento AS e on a.id = e.id_area
WHERE
    c.tipo = 1
GROUP BY 
    c.id
ORDER BY
    count(e.id)
;

----------------------------------------------------------------------------

----------------------------------------------------------------------------
--¿?