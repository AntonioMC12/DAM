(:7.- Horas totales de clase que tiene cada curso:)

let $horas := doc("/home/ertonix12/Formacion/1º/LM/xquery/colegio/cursos.xml")/cursos/curso/asignaturas/asignatura

return <horas>{data(sum($horas/horas))}</horas>