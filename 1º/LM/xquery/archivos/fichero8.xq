for $planta in /CATALOGO/PLANTA
where (deep-equal(data($planta/ZONA),"3") or deep-equal(data($planta/ZONA),"4"))
and
$planta/PRECIO >"3"
and
$planta/DISPONIBILIDAD<"30000"
order by $planta/ZONA ascending
return $planta