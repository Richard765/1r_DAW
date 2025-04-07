document.addEventListener("DOMContentLoaded", function () {
    const inputTexto = document.getElementById("texto");
    const botonVerificar = document.getElementById("verificar");
    const resultado = document.getElementById("resultado");

    function esPalindromo(palabra) {
        const palabraProcesada = palabra.toLowerCase();
        const palabraInvertida = palabraProcesada.split("").reverse().join("");
        return palabraProcesada === palabraInvertida;
    }

    function verificarPalindromo() {
        const texto = inputTexto.value.trim();
        if (texto === "") {
            resultado.textContent = "Por favor, introduce una palabra.";
            return;
        }
        resultado.textContent = esPalindromo(texto) ? "¡Es palíndromo!" : "No es palíndromo.";
    }

    botonVerificar.addEventListener("click", verificarPalindromo);
    inputTexto.addEventListener("keypress", function (event) {
        if (event.key === "Enter") {
            verificarPalindromo();
        }
    });
});
