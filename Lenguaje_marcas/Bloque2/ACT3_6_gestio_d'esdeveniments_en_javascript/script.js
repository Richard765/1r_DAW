window.onload = (event) => {
    window.alert("Bienvenido");
    
    cat.addEventListener("change", cambio_categoria);
};

function cambio_categoria () {
    alert("Categoria cambiada");
}
