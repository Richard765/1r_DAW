// Función principal que crea una clausura 
function crearCronometro() { 
    // Variables privadas (solo accesibles dentro de esta función) 
    let _centesimas = 0; // '_' indica que son variables privadas (es solo por convención, no es obligatorio) 
    let _segundos = 0; 
    let _minutos = 0; 
    let _intervalo = null; 
    let _contadorVueltas = 1; 
    // Función para actualizar el display en la página 
    function actualizarDisplay() { 
    // TODO: Actualizar el contenido del elemento con id 'display' 
    // Para rellenar con ceros donde sea necesario y tener algo como 01:00:02, podemos utilizar 
    // const minStr = minutos.toString().padStart(2, "0"); 
    // const segStr = segundos.toString().padStart(2, "0"); 
    // const centStr = centesimas.toString().padStart(2, "0"); }
    // Función que incrementa el tiempo del cronómetro 
    function contar() { 
    // TODO: Aumentar centésimas, segundos y minutos correctamente // TODO: Llamar a actualizarDisplay() 
    } 
    // Definimos los métodos públicos primero 
    function iniciar() { 
    // TODO: Iniciar el cronómetro usando setInterval 
    // intervalo = setInterval(contar, 10); // 10ms = 1 centésima } 
    function pausar() { 
    // TODO: Pausar el cronómetro usando clearInterval(intervalo) y poniendo intervalo = null; 
    } 
    function reiniciar() { 
    // TODO: Reiniciar todas las variables a cero y actualizar el display // TODO: Limpiar las vueltas guardadas 
    } 
    function guardarVuelta() { 
    // Guarda una vuelta si el cronómetro está en marcha 
    if (_intervalo !== null) { 
    const minStr = _minutos.toString().padStart(2, "0"); 
    const segStr = _segundos.toString().padStart(2, "0");
    const centStr = _centesimas.toString().padStart(2, "0"); 
    // Crear el elemento para la vuelta 
    const vueltaElement = document.createElement('div'); 
    vueltaElement.className = 'vuelta'; 
    vueltaElement.innerHTML = ` 
    <span class="numero-vuelta">Vuelta ${_contadorVueltas}</span> 
    <span class="tiempo-vuelta"> ${minStr}:${segStr}:${centStr} </span>`; 
    // Agregar al contenedor de vueltas 
    const vueltasContainer = document.getElementById('vueltas'); 
    vueltasContainer.insertBefore(vueltaElement, 
    vueltasContainer.firstChild); // Añade al principio 
    // Incrementar el contador de vueltas 
    _contadorVueltas++; 
    } 
    } 
    // Devuelve un objeto con métodos públicos 
    return {iniciar, pausar, reiniciar, guardarVuelta}; 
    } 
    // Inicializar el cronómetro 
    const cronometro = crearCronometro(); 
    // Configurar event listeners para los botones
    document.getElementById('iniciar').addEventListener('click', () => cronometro.iniciar()); 
    document.getElementById('pausar').addEventListener('click', () => cronometro.pausar()); 
    document.getElementById('reiniciar').addEventListener('click', () => cronometro.reiniciar()); 
    document.getElementById('guardar-vuelta').addEventListener('click', () => cronometro.guardarVuelta());
    }
}