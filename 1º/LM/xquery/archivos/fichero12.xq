let $todos := /coches/coche
for $coche in $todos
let $precio := $coche
return 
<estadistica>
  <preciomediocoche>{avg(data($todos/precio))}</preciomediocoche>
  <valorpormarca>
    <marca preciomedio="{avg($precio/precio)}">{data($coche/marca)}</marca>
  </valorpormarca>
</estadistica>


