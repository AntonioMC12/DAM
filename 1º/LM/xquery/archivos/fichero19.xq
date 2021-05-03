<pedidos>{
for $pedido in doc("/home/ertonix12/Formacion/1º/LM/xquery/xml/order.xml")//item
for $catalogo in doc("/home/ertonix12/Formacion/1º/LM/xquery/xml/catalog.xml")/catalog/product
for $precio in doc("/home/ertonix12/Formacion/1º/LM/xquery/xml/prices.xml")//prod
where $pedido/@num = $catalogo/number
and $precio/@num = $pedido/@num
and $precio/@num = $catalogo/number
return 	 
            <departamento dept="{data($pedido/@dept)}">
              <producto>
                <nombre>{data($catalogo/name)}</nombre>
                <cantidad>{data($pedido/@quantity)}</cantidad>
                <color>{data($pedido/@color)}</color>
                <precioUD>{data($precio/price)}</precioUD>
                <descuento>{data($precio/discount)}</descuento>
                <precioFinal>{data((data($precio/price)-data($precio/discount)))*data($pedido/@quantity)}</precioFinal>
              </producto>
            </departamento>
}</pedidos>