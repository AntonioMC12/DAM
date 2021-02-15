--Buscar descuento que incluya la palabra promocion
SELECT * FROM descuento WHERE Descripcion LIKE "%Promocion%";

--Aquellos modelos de coche que no tienen descuento

SELECT * FROM modelo WHERE CodDescuento IS NULL;

--modelos fabricados en alemania, españa, italia
SELECT * FROM modelo WHERE Pais IN ("España","Alemania","Italia");

--Para aquellos modelos de Opel o Renault mostrar sus datos junto con el descuento en cantidad que posea si este descuento está entre 500 y 1000
SELECT m.*, d.cantidad FROM modelo AS m, marca AS ma, descuento AS d WHERE (m.CIFMarca = ma.CIF AND m.CodDescuento = d.Codigo) AND (d.Cantidad BETWEEN 500 AND 1000) AND (ma.Nombre IN ("Renault","Opel"));