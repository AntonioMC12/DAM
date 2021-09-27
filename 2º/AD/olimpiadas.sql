-----------------------------------------------------------------
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

-----------------------------------------------------------------

-----------------------------------------------------------------
--¿Cuántas veces ha ejercido de juez cada comisario?

-----------------------------------------------------------------