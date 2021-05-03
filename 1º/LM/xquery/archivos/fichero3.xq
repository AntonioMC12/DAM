for $planta in /CATALOGO/PLANTA
return <Flor>{
              (<Nombre1>{data($planta/NOMBRECOMUN)}</Nombre1>,
               <Nombre2>{data($planta/NOMBREBOTANICO)}</Nombre2>)
      }</Flor>