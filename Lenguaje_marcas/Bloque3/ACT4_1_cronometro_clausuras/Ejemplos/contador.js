function crearContador() {
    let _contador = 0; // las variables privadas suelen empezar por _
    function incrementar() {
        _contador++;
        return _contador;
    }
    function decrementar() {
        _contador--;
        return _contador;
    }
    function obtenerValor() {
        return _contador;
    }
    return { incrementar, decrementar, obtenerValor }; // retorna un objeto
}

const miContador = crearContador();
console.log(miContador.incrementar()); // 1
console.log(miContador.incrementar()); // 2
console.log(miContador.decrementar()); // 1
console.log(miContador.obtenerValor()); // 1