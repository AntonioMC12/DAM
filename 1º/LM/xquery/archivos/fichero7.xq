    <misflores>{
for $planta in /CATALOGO/PLANTA
return 

          <maceta>
            <flor precio="{data($planta/PRECIO)}" unidades="{$planta/DISPONIBILIDAD}">{data($planta/NOMBRECOMUN)}</flor>
            <cientifico lugar="{data($planta/ZONA)}">{data($planta/NOMBREBOTANICO)}</cientifico>
          </maceta>
    }</misflores>