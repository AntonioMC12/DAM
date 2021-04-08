for $planta in /CATALOGO/PLANTA
where data($planta/DISPONIBILIDAD) > "10000" and data($planta/DISPONIBILIDAD)< "30000"
order by $planta/NOMBRE ascending
return $planta