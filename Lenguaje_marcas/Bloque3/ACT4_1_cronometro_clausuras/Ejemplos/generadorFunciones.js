// Ejemplo 2: Generador de funciones
function multiplicador(factor) {
    const _factor = factor; // _factor es una constante privada
    
    function operacion(numero) {
        return numero * _factor;
    }
    
    return operacion; // puede retornar una única función (en vez de un objeto)
}

const duplicar = multiplicador(2);
const triplicar = multiplicador(3);
console.log(duplicar(5)); // 10
console.log(triplicar(5)); // 15