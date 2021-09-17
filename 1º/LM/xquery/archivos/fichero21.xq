(:6.- Mostrar las notas de los alumnos, incluyendo el nombre del alumno, de la asignatura y del profesor:)
<notas>{
for $notas in doc("/home/ertonix12/Formacion/1º/LM/xquery/colegio/notas.xml")/notas/alumno
for $nota in $notas/asignatura
for $asignatura in doc("/home/ertonix12/Formacion/1º/LM/xquery/colegio/asignaturas.xml")/asignaturas/modulo
for $alumnos in doc("/home/ertonix12/Formacion/1º/LM/xquery/colegio/alumnos.xml")//alumno


where $notas/@id = $alumnos/@id
and $notas/asignatura/@id = $asignatura/@id
and $nota/@id = $asignatura/@id


return
   <alumno nombre="{data($alumnos/nombre)}">
     <asignatura nombre="{data($asignatura/denominacion)}">{data($nota/nota)}</asignatura>
     <profesor>{
       for $profesor in doc ("/home/ertonix12/Formacion/1º/LM/xquery/colegio/profesores.xml")/profesores/profesor
       where $nota/profesor = $profesor/@id
       return data($profesor/nombre)
    }</profesor>
   </alumno>
}</notas>