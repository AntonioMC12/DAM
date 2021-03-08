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