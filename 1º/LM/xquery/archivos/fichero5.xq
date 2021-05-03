for $planta in CATALOGO/PLANTA
return 
<PLANTA>
  <NOMBRE precio="{data($planta/PRECIO)}">{data($planta/NOMBRECOMUN)}</NOMBRE>
  <UNIDADES>{data($planta/DISPONIBILIDAD)}</UNIDADES>
</PLANTA>