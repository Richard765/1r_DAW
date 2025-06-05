// a) Completa el código para convertir el objeto datosEstudiante a una cadena JSON
// estudianteJSON y enviarla a la consola:
const datosEstudiante = {
  nombre: "María",
  notas: [8, 9, 7.5],
  asignaturas: {
    matematicas: "A",
    programacion: "A+",
    historia: "B"
  }
};

// Tu código aquí
const estudianteJSON = JSON.stringify(datosEstudiante);
console.log(estudianteJSON);

/*b) Escribe código para convertir la siguiente cadena JSON en un objeto JavaScript
productoObjeto que cumpla con los ejemplos de uso:*/
const datosJSON = '{"producto":"Monitor","precio":249.99,"enStock":true}';

// Tu código aquí
const productoObjeto = JSON.parse(datosJSON);

// Ejemplos de uso (NO MODIFICAR):
console.log(productoObjeto.producto); // "Monitor"
console.log(productoObjeto.precio); // 249.99
console.log(productoObjeto.enStock); // true

//c) Escribe el objeto datosEstudiante del apartado a) en su representación YAML.
// Tu YAML aquí
/*
nombre: María
notas:
  - 8
  - 9
  - 7.5
asignaturas:
  matematicas: "A"
  programacion: "A+"
  historia: "B"
*/
