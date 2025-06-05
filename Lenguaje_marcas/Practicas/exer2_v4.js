// Ejercicio 2: Temporizadores y Promesas (20%)

// a) Escribe código que implemente una secuencia temporizada de mensajes para un proceso de carga:
// Tu código aquí

console.log("Iniciando carga de datos...");

setTimeout(() => {
  console.log("Progreso: 25%");
}, 1000);

setTimeout(() => {
  console.log("Progreso: 50%");
}, 2000);

setTimeout(() => {
  console.log("Progreso: 75%");
}, 3000);

setTimeout(() => {
  console.log("Carga completada!");
}, 4000);

// b) Crea una función `esperarTiempo(segundos)` que devuelva una promesa que se resuelva después del número especificado de segundos.

function esperarTiempo(segundos) {
  // Tu código aquí
  return new Promise((resolve) => {
    setTimeout(() => resolve(), segundos * 1000);
  });
}

// Ejemplo de uso (NO MODIFICAR):
console.log("Iniciando secuencia...");
esperarTiempo(2)
  .then(() => {
    console.log("Paso 1 completado");
    return esperarTiempo(1);
  })
  .then(() => {
    console.log("Paso 2 completado");
    return esperarTiempo(1.5);
  })
  .then(() => {
    console.log("Secuencia finalizada");
  });
