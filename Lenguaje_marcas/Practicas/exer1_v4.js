// Ejercicio 1: Manipulación de JSON y XML (20%)

// a) Completa el código para convertir el objeto `datosCurso` a una cadena JSON formateada con 2 espacios de indentación y enviarla a la consola:

const datosCurso = {
  nombre: "JavaScript Avanzado",
  estudiantes: [
    { id: 1, nombre: "Ana", calificacion: 9.5 },
    { id: 2, nombre: "Carlos", calificacion: 8.7 },
    { id: 3, nombre: "Elena", calificacion: 9.2 }
  ],
  profesor: {
    nombre: "Miguel",
    experiencia: 8,
    especialidades: ["Frontend", "Node.js", "Arquitectura"]
  },
  fechaInicio: "2025-09-15"
};

// Tu código aquí
const datosCursoJSON = JSON.stringify(datosCurso, null, 2);
console.log(datosCursoJSON);


// b) Escribe código para convertir la siguiente cadena JSON en un objeto JavaScript `productosPedido` y calcula `precioTotal` que la suma de todos los productos incluidos en el pedido:

const pedidoJSON = '{"cliente":"Juan García","productos":[{"nombre":"Teclado","precio":45.99,"cantidad":1},{"nombre":"Monitor","precio":199.50,"cantidad":2},{"nombre":"Ratón","precio":25.75,"cantidad":1}],"urgente":true}';

// Tu código aquí
const productosPedido = JSON.parse(pedidoJSON);
let precioTotal = 0;

productosPedido.productos.forEach(producto => {
  precioTotal += producto.precio * producto.cantidad;
});

// Ejemplo de uso (NO MODIFICAR):
console.log("Precio total:", precioTotal); // Debe mostrar el precio total del pedido
console.log(productosPedido.cliente); // "Juan García"
console.log(productosPedido.urgente); // true


// c) Escribe el objeto `datosCurso` del apartado a) en su representación XML.

<curso>
    <nombre>JavaScript Avanzado</nombre>
    <estudiantes>
        <estudiante>
            <id>1</id>
            <nombre>Ana</nombre>
            <calificacion>9.5</calificacion>
        </estudiante>
        <estudiante>
            <id>2</id>
            <nombre>Carlos</nombre>
            <calificacion>8.7</calificacion>
        </estudiante>
        <estudiante>
            <id>3</id>
            <nombre>Elena</nombre>
            <calificacion>9.2</calificacion>
        </estudiante>
    </estudiantes>
    <profesor>
        <nombre>Miguel</nombre>
        <experiencia>8</experiencia>
        <especialidades>
            <especialidad>Frontend</especialidad>
            <especialidad>Node.js</especialidad>
            <especialidad>Arquitectura</especialidad>
        </especialidades>
    </profesor>
    <fechaInicio>2025-09-15</fechaInicio>
</curso>

