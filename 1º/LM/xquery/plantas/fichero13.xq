<estadistica>
    <preciomediocoche>{
    
  let $media := /coches/coche
  return avg(data($media/precio))
  
   }</preciomediocoche>
 <valorpormarca>{
   
   for $coche in /coches/coche
   let $precio := $coche
   return <marca preciomedio="{round(avg(data($precio/precio)))}">{data($coche/marca)}</marca>
   
 }</valorpormarca>
</estadistica>