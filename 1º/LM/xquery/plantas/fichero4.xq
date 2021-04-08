for $planta in /CATALOGO/PLANTA
where deep-equal(data($planta/ZONA),"3")
and
starts-with($planta/NOMBRECOMUN,"P")
return <Flor>
              <Nombre1>{data($planta/NOMBRECOMUN)}</Nombre1>
      </Flor>