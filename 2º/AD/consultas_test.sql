-----------------------------------------------------------------
SELECT
    COUNT(p.cod)
FROM
    producto p
    JOIN proveedor prov ON p.id_proveedor = prov.id_Proveedor
WHERE
    prov.cif = 123456789;

-------------------------------------------------------------------
-------------------------------------------------------------------
SELECT
    prov.nombre AS PROVEEDOR,
    COUNT(cod) AS PRODUCTOS
FROM
    producto AS p,
    proveedor AS prov
WHERE
    P.id_proveedor = prov.id
GROUP BY
    prov.id;

-------------------------------------------------------------------
-------------------------------------------------------------------
SELECT
    prov.nombre AS PROVEEDOR,
    COUNT(cod) AS PRODUCTOS
FROM
    producto AS p
    JOIN proveedor AS prov ON P.id_proveedor = prov.id
GROUP BY
    prov.id;

-------------------------------------------------------------------
-------------------------------------------------------------------
SELECT
    prov.nombre AS PROVEEDOR,
    COUNT(cod) AS PRODUCTOS
FROM
    producto p
    RIGHT JOIN proveedor prov ON p.id_proveedor = prov.id
GROUP BY
    prov.id;

-------------------------------------------------------------------
-------------------------------------------------------------------
--listado de todas las ventas quien con dni y nombre el que y a quien
SELECT
    cl.dni,
    cl.nombre AS CLIENTE,
    p.nombre AS PRODUCTO,
    prov.nombre AS PROVEEDOR
FROM
    compra c
    LEFT JOIN cliente cl ON c.id_cliente = cl.id,
    producto P
    LEFT JOIN proveedor prov ON p.id_proveedor = prov.id
    AND c.id_producto = p.cod;

-------------------------------------------------------------------
-------------------------------------------------------------------
--ordenar los clientes que han gastado de mas a menos
SELECT
    c.nombre,
    IFNULL(SUM(p.precio), 0) AS TOTAL
FROM
    cliente AS c
    LEFT JOIN compra AS co ON co.id_cliente = c.id
    LEFT JOIN producto AS p ON co.id_producto = p.cod
GROUP BY
    c.id
ORDER BY
    TOTAL ASC;

-------------------------------------------------------------------
-------------------------------------------------------------------
--MOSTRAR LOS NOMBRES CON MAS DE 4 LETRAS 
SELECT
    c.nombre,
    IFNULL(SUM(p.precio), 0) AS TOTAL
FROM
    cliente AS c
    LEFT JOIN compra AS co ON co.id_cliente = c.id
    LEFT JOIN producto AS p ON co.id_producto = p.cod
GROUP BY
    c.id
HAVING
    LENGTH(c.nombre) > 4
ORDER BY
    TOTAL ASC;
-------------------------------------------------------------------
-------------------------------------------------------------------
SELECT
    cliente.nombre,
    IFNULL(SUM(producto.precio), 0) AS Total
FROM
    cliente
    LEFT JOIN compra ON cliente.id = compra.id_cliente
    LEFT JOIN producto ON compra.id_producto = producto.cod
GROUP BY
    cliente.nombre;

-------------------------------------------------------------------
-------------------------------------------------------------------
SELECT
    cliente.dni AS dni,
    cliente.nombre AS Cliente,
    producto.nombre AS Producto,
    proveedor.nombre AS Nombre_Proveedor
FROM
    compra
    INNER JOIN cliente ON compra.id_cliente = cliente.id
    INNER JOIN producto ON compra.id_producto = producto.cod
    INNER JOIN proveedor ON producto.id_proveedor = proveedor.id;

-------------------------------------------------------------------
-------------------------------------------------------------------
SELECT
    prov.nombre AS Proveedor,
    COUNT(cod) AS Productos
FROM
    producto AS p
    RIGHT JOIN proveedor AS prov ON p.id_proveedor = prov.id
GROUP BY
    prov.id;

-------------------------------------------------------------------
-------------------------------------------------------------------

--Esto simplemente es una prueba de lectura y escritura para ver si da pantallazo azul 
--No tiene que interpretarse como nada