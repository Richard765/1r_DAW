// Ejemplo 3: Almacenamiento privado de datos
function crearUsuario(nombre, edad) {
    let _nombre = nombre;
    
    let _edad = edad;
    function saludar() {
        return `Hola, me llamo ${_nombre} y tengo ${_edad} años`;
    }
    function cumplirAños() {
        _edad++;
        return `¡Feliz cumpleaños! Ahora tengo ${_edad} años`;
    }
        function cambiarNombre(nuevoNombre) {
        _nombre = nuevoNombre;
    }
    return { saludar, cumplirAños, cambiarNombre }; // retorna un objeto
}

const usuario = crearUsuario("Ana", 25);
console.log(usuario.saludar()); // "Hola, me llamo Ana y tengo 25 años"
console.log(usuario.cumplirAños()); // "¡Feliz cumpleaños! Ahora tengo 26 años"
usuario.cambiarNombre("Ana María");
console.log(usuario.saludar()); // "Hola, me llamo Ana María y tengo 26 años"