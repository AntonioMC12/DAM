for $a in //fruta
where $a/precio/@mes = "febrero"
return <fruta>
         <nombre precio="{
                          for $b in $a/precio
                          where $b/@mes = "febrero"
                          return data($b) 
                         }">{$a/nombre}</nombre>
       </fruta>