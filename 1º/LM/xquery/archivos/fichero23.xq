for $nota in doc ("/home/ertonix12/Formacion/1º/LM/xquery/colegio/notas.xml")//notas/alumno
for $alumno in doc ("/home/ertonix12/Formacion/1º/LM/xquery/colegio/alumnos.xml")//alumnos/alumno
where $nota/@id = $alumno/@id
return <alumno>
            <nombre>{data($alumno/nombre)}</nombre>
           {for $asig in $nota/nota
            for $asignatura in doc ("/home/ertonix12/Formacion/1º/LM/xquery/colegio/asignaturas.xml")//asignaturas/modulo
            where $asig/@asignatura = $asignatura/@id
            return  <asignatura>
                              <nombre>{data($asignatura/denominacion)}</nombre>
                              <nota>{data($asig)}</nota>
                    </asignatura>
      }         
</alumno>