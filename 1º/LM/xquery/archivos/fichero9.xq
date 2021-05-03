(: devuelve la media del precio de todas planta :)
let $planta := CATALOGO/PLANTA
return <media_precio>{avg(data($planta/PRECIO))}</media_precio>