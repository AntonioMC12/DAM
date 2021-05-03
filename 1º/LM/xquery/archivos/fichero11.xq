(: devuelve el precio maximo de los coches por marca :)
(:
for $coche in /coches/coche
return <coche> 
          <marca>{data($coche/marca)}</marca>
          <precioMax>{max(data($coche/precio))}</precioMax>
       </coche>
:)
<estadistica>{
for $coche in /coches/coche
let $precio := $coche/precio
return 
        <marca precioMax="{max($precio)}">{data($coche/marca)}</marca>
}</estadistica>