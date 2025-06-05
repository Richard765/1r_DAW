// Ejercicio 3: Almacenamiento en Cliente (20%)

// a) Crea código en JavaScript para guardar las preferencias de un usuario (idioma, tema y notificaciones) en `localStorage` de manera que persista entre sesiones.

const preferenciasUsuario = {
  idioma: "es",
  tema: "oscuro",
  notificaciones: true,
};

// Tu código aquí
// (Este código debe ejecutarse en la consola del navegador)
localStorage.setItem(
  "preferenciasUsuario",
  JSON.stringify(preferenciasUsuario)
);
console.log("Preferencias guardadas en localStorage.");

// b) Escribe una función `obtenerPreferencias()` que recupere la configuración guardada en el paso anterior. Si no existe configuración previa, debe devolver los valores por defecto: idioma "en", tema "claro", notificaciones false.

function obtenerPreferencias() {
  // Tu código aquí
  // (Este código debe ejecutarse en la consola del navegador)
  const preferenciasGuardadas = localStorage.getItem("preferenciasUsuario");
  if (preferenciasGuardadas) {
    return JSON.parse(preferenciasGuardadas);
  } else {
    return {
      idioma: "en",
      tema: "claro",
      notificaciones: false,
    };
  }
}

// Ejemplo de uso (NO MODIFICAR):
console.log(obtenerPreferencias());

// c) Escribe una función `gestionarHistorial(nuevaPagina)` que:

/* Mantenga un historial de las últimas 5 páginas visitadas por el usuario.
 * Al añadir una nueva página, debe colocarla al principio del historial.
 * Si el historial ya tiene 5 páginas, debe eliminar la más antigua.
 * Si la página ya está en el historial, debe moverla al principio.
 * La función debe devolver el array de páginas actual.*/

function gestionarHistorial(nuevaPagina) {
  // Tu código aquí
  // (Este código debe ejecutarse en la consola del navegador)
  let historial = JSON.parse(localStorage.getItem("historialVisitas")) || [];

  // Si la página ya está en el historial, eliminarla para moverla al principio
  const indiceExistente = historial.indexOf(nuevaPagina);
  if (indiceExistente > -1) {
    historial.splice(indiceExistente, 1); // Eliminar la página existente
  }

  // Añadir la nueva página al principio del array
  historial.unshift(nuevaPagina);

  // Mantener solo las últimas 5 páginas
  if (historial.length > 5) {
    historial.pop();
  }

  // Guardar el historial actualizado
  localStorage.setItem("historialVisitas", JSON.stringify(historial));

  return historial;
}

// Ejemplo de uso (NO MODIFICAR):
// (Este código se ejecuta mejor en la consola del navegador)
// Para probar, es mejor limpiar el localStorage antes o comentar las líneas de abajo
// localStorage.removeItem('historialVisitas'); // Descomentar para resetear en cada ejecución de prueba
console.log(gestionarHistorial("/inicio")); // ["/inicio"]
console.log(gestionarHistorial("/productos")); // ["/productos", "/inicio"]
console.log(gestionarHistorial("/contacto")); // ["/contacto", "/productos", "/inicio"]
console.log(gestionarHistorial("/productos")); // ["/productos", "/contacto", "/inicio"]
console.log(gestionarHistorial("/usuarios")); // ["/usuarios","/productos", "/contacto", "/inicio"]
console.log(gestionarHistorial("/posts")); // ["/posts","/usuarios","/productos", "/contacto", "/inicio"]
console.log(gestionarHistorial("/servicios")); // ["/servicios","/posts","/usuarios","/productos", "/contacto"]
