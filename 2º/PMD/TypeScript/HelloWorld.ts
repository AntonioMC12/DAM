class Saludador {

    //private String nombre;
    private nombre: string;

    //Saludador(String nombre){}
    constructor(nombre: string) {
        //es obligatorio usar this
        this.nombre = nombre;
    }

    public saluda(): string {
        return 'Hola ' + this.nombre;
    }
}

let s: Saludador = new Saludador('Antonio');
let boton = document.createElement('button');
boton.textContent = 'Di hola';
boton.onclick =  () => {
    alert(s.saluda());
}

document.body.appendChild(boton);


