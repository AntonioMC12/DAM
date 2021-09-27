"use strict";
/**
 * Simula la carga remota de una lista de libros.
 *
 * mook es crear datos falsos o de relleno
 */
function getFakeremoteData() {
    return new Promise((resolve, reject) => {
        let mookData = [];
        mookData.push({
            isbn: 1,
            tittle: 'El Quijote'
        });
        mookData.push({
            isbn: 2,
            tittle: 'El Señor de los Anillos'
        });
        setTimeout(() => {
            resolve(mookData);
        }, 2000);
    });
}
/**
 * Hace una funcion asíncrona.
 */
async function cargaLibros() {
    //paso 1 indicar al cliente la carga
    document.getElementById('contenedor').innerHTML = "Cargando...";
    try {
        let libros = await getFakeremoteData();
        document.getElementById('contenedor').innerHTML = "";
        let ui = '';
        libros.forEach((libro) => {
            ui += `<p>${libro.isbn}:${libro.tittle}</p>`;
        });
        document.getElementById('contenedor').innerHTML = ui;
    }
    catch (error) {
        document.getElementById('contenedor').innerHTML = "";
        alert('Error al Cargar');
    }
}
