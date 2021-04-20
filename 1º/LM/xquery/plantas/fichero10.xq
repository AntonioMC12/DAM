(:media redondeada de los coches filtrado por marca:)
for $marca in coches/coche
let $precios := $marca/precio
return <media marca="{$marca/marca}">{round(avg($precios))}</media>