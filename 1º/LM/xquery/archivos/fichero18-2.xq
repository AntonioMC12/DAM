(:producto precio y descuento:)
for $producto in doc("/home/ertonix12/Formacion/1º/LM/xquery/xml/catalog.xml")//product
for $precio in doc("/home/ertonix12/Formacion/1º/LM/xquery/xml/prices.xml")/prices/priceList/prod[@num=$producto/number]
return <producto>
          <nombre>{data($producto/name)}</nombre>
          <precio>{data($precio/price)}</precio>
          <descuento>{data($precio/discount)}</descuento>
       </producto>