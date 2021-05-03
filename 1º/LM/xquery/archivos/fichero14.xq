let $a := ( for $b in //cliente 
            where $b/direccion = "Calle2" or $b/direccion = "Calle3" 
            return $b )
return count($a)