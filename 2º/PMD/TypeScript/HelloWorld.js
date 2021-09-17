var Saludador = /** @class */ (function () {
    //Saludador(String nombre){}
    function Saludador(nombre) {
        //es obligatorio usar this
        this.nombre = nombre;
    }
    Saludador.prototype.saluda = function () {
        return 'Hola ' + this.nombre;
    };
    return Saludador;
}());
var s = new Saludador('Antonio');
var boton = document.createElement('button');
boton.textContent = 'Di hola';
boton.onclick = function () {
    alert(s.saluda());
};
document.body.appendChild(boton);
