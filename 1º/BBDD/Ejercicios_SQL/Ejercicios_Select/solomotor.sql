--Buscar descuento que incluya la palabra promocion
SELECT * FROM descuento WHERE Descripcion LIKE "%Promocion%";

--Aquellos modelos de coche que no tienen descuento

SELECT * FROM modelo WHERE CodDescuento IS NULL;

--modelos fabricados en alemania, españa, italia
SELECT * FROM modelo WHERE Pais IN ("España","Alemania","Italia");

--Para aquellos modelos de Opel o Renault mostrar sus datos junto con el descuento en cantidad que posea si este descuento está entre 500 y 1000
SELECT m.*, d.cantidad FROM modelo AS m, marca AS ma, descuento AS d WHERE (m.CIFMarca = ma.CIF AND m.CodDescuento = d.Codigo) AND (d.Cantidad BETWEEN 500 AND 1000) AND (ma.Nombre IN ("Renault","Opel"));

--Ejercicio 37
SELECT ve.*, tie.* 
FROM version ve, tiene tie 
WHERE ve.modelo = tie.modelo AND ve.Version = tie.Version 
AND tie.Extra like "%ABS%" 
AND (tie.Precio = (SELECT max(Precio) FROM tiene WHERE extra = "ABS") OR tie.Precio = (SELECT min(Precio) FROM tiene WHERE extra = "ABS"));

SELECT ve.*, tie.* 
FROM version ve, tiene tie 
WHERE ve.modelo = tie.modelo AND ve.Version = tie.Version 
AND tie.Extra like "%ABS%" 
AND tie.Precio IN ( (SELECT max(Precio) FROM tiene WHERE extra ="ABS"), (SELECT min(Precio) FROM tiene WHERE extra ="ABS"));

--Ejercicio39

SELECT ve.*, mc.Consumo, mo.*
FROM motor mo, montadocon mc, version ve
WHERE mo.codigo = mc.CodigoMotor 
AND ve.Modelo = mc.Modelo AND ve.Version = mc.Version
AND Codigo IN (SELECT codMotor FROM electrico) AND (Codigo IN (SELECT codMotor FROM gasolina) OR Codigo IN (SELECT codMotor FROM diesel))
ORDER BY consumo DESC
LIMIT 1; 

--Ejercicio34

SELECT ve.*, mc.PrecioBase, mc.Consumo, mot.*
FROM version ve, montadocon mc, motor mot
WHERE ve.Modelo = mc.Modelo AND ve.Version = mc.Version AND mc.CodigoMotor = mot.Codigo
AND ve.Peso=(SELECT max(peso) FROM version)
AND mot.Potencia = (SELECT max(Potencia) FROM motor, montadocon WHERE Codigo=CodigoMotor AND Modelo = ve.Modelo and version =ve.version)
--ORDER BY ve.Peso DESC, mot.Potencia DESC 
--LIMIT 1
;

--Ejercicio 36

SELECT * 
FROM version
WHERE modelo IN 
(SELECT modelo FROM tiene)

-- Ejercicio 38
SELECT *, Potencia/Peso
FROM motor
ORDER BY 5
;

--Ejercicio 45
--Incrementa el la cantidad de descuento en un 10% de aquellos descuentos que se apliquen a algún modelo que entre todas sus versiones utilice más tipos de motores eléctricos que no.

SELECT mo1.*
FROM modelo mo1
WHERE 
    (   SELECT coalesce(count(DISTINCT mot.Codigo),0)
        FROM version ver, montadocon mc, motor mot
        WHERE ver.Modelo=mc.Modelo AND ver.Version=mc.Version AND mc.CodigoMotor = mot.Codigo 
        AND mot.Codigo IN ( SELECT codMotor FROM electrico )
        AND ver.Modelo = mo1.nombre
    )
    >
        (   SELECT coalesce(count(DISTINCT mot.Codigo),0)
        FROM version ver, montadocon mc, motor mot
        WHERE ver.Modelo=mc.Modelo AND ver.Version=mc.Version AND mc.CodigoMotor = mot.Codigo 
        AND mot.Codigo NOT IN ( SELECT codMotor FROM electrico )
        AND ver.Modelo = mo1.nombre
    )
;

-- Consulta 57
-- Datos de las versiones de coches que monten el/solo motor eléctrico (o híbrido) de mayor y menor peso y de mayor y menor amperaje.
SELECT ver.Modelo, ver.Version, ver.Peso, mc.PrecioBase
FROM version ver, montadocon mc
WHERE ver.modelo = mc.modelo AND ver.version = mc.version
AND mc.CodigoMotor IN(
                        (SELECT mot.codigo FROM motor mot
                        WHERE mot.codigo IN (SELECT codMotor FROM electrico)
                        ORDER BY mot.peso DESC
                        LIMIT 1)
                        ,
                        (SELECT mot.codigo FROM motor mot
                        WHERE mot.codigo IN (SELECT codMotor FROM electrico)
                        ORDER BY mot.peso ASC
                        LIMIT 1
                        )
                     )
                     ;

COMANDO TEE PARA PONER LA CONSOLA EN UN FICHERO
Y NOTEE PARA TERMINAR

-- Consulta 58
--Da la información de todos los motores (solo) híbridos con un amperaje superior a “8000”.

SELECT mot.* 
FROM motor mot, electrico el
WHERE mot.codigo = el.codMotor
AND el.Amperaje > 8000
AND mot.codigo IN (SELECT codMotor FROM gasolina UNION SELECT codMotor FROM diesel)
;

-- Consulta 59
--Cual es la potencia de los motores híbridos con un amperaje superior a la media. 

SELECT mot.potencia
FROM motor mot, electrico el
WHERE mot.codigo = el.codMotor
AND (el.Amperaje > (SELECT avg(amperaje) FROM electrico))
AND mot.codigo IN (SELECT codMotor FROM gasolina UNION SELECT codMotor FROM diesel)
;

SELECT fabricante,potencia
FROM motor 
WHERE codigo IN (SELECT codMotor FROM electrico WHERE amperaje > (SELECT avg(amperaje) FROM electrico))
AND codigo IN (SELECT codMotor FROM gasolina UNION SELECT codMotor FROM diesel)
;

--Sube el Porcentaje de descuento en 3 puntos, subir un 3% mas, a todos aquellos descuentos que se apliquen a algún modelo fabricando en Francia o que contengan en el nombre del modelo la cadena “TE”. 
UPDATE descuento SET Porcentaje=Porcentaje*1.03
WHERE codigo IN (    SELECT CodDescuento 
                    FROM modelo 
                    WHERE pais="Francia"
                    OR nombre LIKE "%TE%" )
;

--Borra los dos mayores descuentos en Cantidad, de aquellos descuentos que se apliquen a algún modelo que tenga alguna versión de más de 1500 kilos. 
DELETE FROM descuento
WHERE codigo IN (   SELECT mo.CodDescuento 
                    FROM modelo mo, version ver
                    WHERE mo.nombre= ver.modelo
                    AND ver.peso > 1500 )
ORDER BY cantidad DESC
LIMIT 2
;

--Baja el precio base en un 7% de todos los vehículos que usen cualquier tipo de motor eléctrico, es decir híbridos de cualquier tipo o eléctricos puros.
UPDATE montadocon SET PrecioBase = PrecioBase*0.93
WHERE CodigoMotor IN (  SELECT codMotor 
                        FROM electrico )
;


---------------------------------------------------------------------------
/*                       EJEMPLO GROUP BY Y HAVING                       */

SELECT colorPelo, count(*)
FROM alumnos
WHERE edad > 17
GROUP BY colorPelo
HAVING count(*) > 5
;

---------------------------------------------------------------------------

--Aumenta el descuento en cantidad en un 12% para aquellos descuentos que sean una "promoción" (que contengan la palabra), y se apliquen a almenos 2 modelos de coches no fabricados en España

UPDATE descuento SET Cantidad=Cantidad*1.12
WHERE Descripcion LIKE "%promocion%"
AND codigo IN ( SELECT CodDescuento FROM modelo
                WHERE pais NOT LIKE "España"
                GROUP BY CodDescuento
                HAVING count(*) > 1)
;

-- Para aquellos motores hibridos de gasolina que se monten en mas de dos versiones de coche mostrar toda su informacion y el numero de versiones que aparecen.
-- Mostrar solo los tres motores que mas se utilizan

SELECT mot.*, count(*)
FROM motor mot, montadocon mc
WHERE mot.codigo = mc.CodigoMotor
AND mot.codigo IN (SELECT codMotor FROM gasolina UNION SELECT codMotor FROM electrico)
GROUP BY mc.version 
HAVING count(*) > 2
ORDER BY count(*) DESC
LIMIT 3
;

--Para cada modelo mostrar su version mas pesada
SELECT mo.Nombre, mo.Pais, ver.version, ver.peso
FROM modelo mo, version ver
WHERE mo.Nombre = ver.Modelo
AND ver.peso = ( SELECT max(peso) 
                FROM version
                WHERE modelo = mo.nombre )
;

--Lista modelo, version, ,peso, precio base, codigo de motor y potencia de motor, incluyendo además el precio final si tenia un descuento en cantidad
SELECT ve.modelo, ve.version, ve.peso, mc.PrecioBase, mc.CodigoMotor, mot.potencia, 
mc.PrecioBase - (SELECT coalesce(cantidad,0) FROM descuento WHERE codigo = mo.CodDescuento) PFinal
FROM descuento de, modelo mo, version ve, montadocon mc, motor mot
WHERE de.codigo = mo.CodDescuento
AND mo.nombre = ve.modelo
AND ve.modelo = mc.modelo AND ve.version = mc.version
AND mc.CodigoMotor = mot.codigo
;

-- Consulta 47
--Baja un 2% el precio de los modelos que tengan los dos extras más caros. 

UPDATE montadocon SET PrecioBase = PrecioBase*0.98 
WHERE modelo = (    SELECT ver.modelo
                    FROM version ver, tiene tie 
                    WHERE ver.modelo = tie.modelo 
                    AND ver.version = tie.version
                    ORDER BY tie.precio DESC
                    LIMIT 1 )
AND modelo = (    SELECT ver.modelo
                    FROM version ver, tiene tie 
                    WHERE ver.modelo = tie.modelo 
                    AND ver.version = tie.version
                    ORDER BY tie.precio DESC
                    LIMIT 2,1 )

;

UPDATE montadocon SET PrecioBase = PrecioBase*0.98 
WHERE modelo = (    SELECT precio
                    FROM tiene
                    ORDER BY precio DESC
                    LIMIT 2 )
AND version = (    SELECT precio
                    FROM tiene
                    ORDER BY precio DESC
                    LIMIT 2 )

;
-- Consulta 48
--Rebaja el Precio base en un 5% para el coche con el extra más caro. Debe rebajarse para todas los diferentes montajes de motor que pueda tener.
UPDATE montadocon SET PrecioBase = PrecioBase*0.95 
WHERE modelo = (    SELECT ver.modelo
                    FROM version ver, tiene tie 
                    WHERE ver.modelo = tie.modelo 
                    AND ver.version = tie.version
                    ORDER BY tie.precio DESC
                    LIMIT 1 )
;

-- Consulta 49
-- Indica  los  descuentos  posibles  ordenando  el  resultado  de  forma  creciente  por  cantidad  y considerando para ordenar el porcentaje la media del precio base. 

SELECT des.* 
FROM descuento des, montadocon mc, modelo mo, version ver
WHERE des.codigo = mo.CodDescuento 
AND mo.nombre = ver.modelo 
AND ver.modelo = mc.modelo
AND ver.version = mc.version
ORDER BY avg(mc.PrecioBase)*100 ASC
;


SELECT *, coalesce(cantidad, porcentaje/100 * (SELECT avg(PrecioBase) FROM montadocon)) des
FROM descuento
ORDER BY des
;

-- Para cada marca y modelo indica cuantas versiones tiene excluyendo los modelos fabricados en Francia y las versiones de menos de 950kg
-- mostrar el cif y nombre de la marca, el nombre y pais de cada modelo y el numero de versiones que hay de cada modelo que cumplas las condiciones indicadas
-- Además el listado debe estar ordenado de mayor a menor por este ultimo valor

SELECT ma.cif, ma.nombre, mo.nombre, mo.pais, count(*) verCoche
FROM marca ma, modelo mo, version ver
WHERE ma.cif = mo.CIFMarca AND mo.nombre = ver.modelo
AND ver.peso >= 950
AND mo.pais <> "Francia"
GROUP BY mo.nombre
ORDER BY verCoche desc
;

-- Muestra mediante un listado el nombre y pais de fabricacion de cada modelo junto con la descripcion del descuento que tenga
-- incluyendo los modelos sin descuento que deben completar esta ultima con "sin descuento"

SELECT mo.nombre, mo.pais, coalesce(des.descripcion, "sin descuento")
FROM modelo mo
LEFT JOIN descuento des ON mo.CodDescuento = des.codigo
;
