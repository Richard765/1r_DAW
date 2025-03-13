document.addEventListener("DOMContentLoaded", function () {
    const inputFrase = document.getElementById("frase");
    const botonGenerar = document.getElementById("generar");
    const resultado = document.getElementById("resultado");

    function generarAcronimo(frase) {
        const palabras = frase.split(" ");
        let acronimo = "";
        
        palabras.forEach(palabra => {
            if (palabra.length > 3) {
                acronimo += palabra[0].toUpperCase();
            }
        });
        
        return acronimo;
    }

    function procesarFrase() {
        const texto = inputFrase.value.trim();
        if (texto === "") {
            resultado.textContent = "Por favor, introduce una frase.";
            return;
        }
        resultado.textContent = generarAcronimo(texto);
    }

    botonGenerar.addEventListener("click", procesarFrase);
    inputFrase.addEventListener("keypress", function (event) {
        if (event.key === "Enter") {
            procesarFrase();
        }
    });
});
