let figuras = [];
let figurasFiltradas = [];

function init() {
    // Inicialmente mostramos todas las figuras
    getFigures("all");

    // Configuración de eventos en los botones de tipo
    let buttonsList = document.querySelectorAll('.btn-check');
    for (const button of buttonsList) {
        button.addEventListener("click", function () {
            getFigures(this.value);
        });
    }

    // Cargar figuras desde el archivo JSON
    function getFigures(pType) {
        fetch('./data/figures.json')
            .then(response => response.json())
            .then((data) => {
                figuras = data.figures;  // Guardamos las figuras
                figurasFiltradas = figuras;  // Inicialmente mostramos todas las figuras
                pintarListaFiguras(figurasFiltradas, pType);
            });
    }

    // Pintar las figuras en la página
    function pintarListaFiguras(listaFiguras, pType) {
        const container = document.getElementById("card-container");
        container.innerHTML = "";  // Limpiamos el contenedor

        listaFiguras.forEach(figure => {
            // Mostrar solo las figuras que coincidan con el tipo (si no es 'all')
            if (pType === "all" || pType === figure.type) {
                container.innerHTML += `
                    <div class="card mb-3" style="max-width: 540px;">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="img/${figure.img}" width="100%" alt="${figure.name}">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">${figure.name}</h5>
                                    <p class="card-text">${figure.description}</p>
                                    <p class="card-text"><small class="text-muted">Precio: ${figure.price}€</small></p>
                                    <button class="btn btn-outline-primary" onclick="toggleFavorite('${figure.name}')">
                                        ${figure.isFavorite ? "Quitar de favoritos" : "Añadir a favoritos"}
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                `;
            }
        });
    }

    // Función para marcar y desmarcar figuras como favoritas
    function toggleFavorite(figureName) {
        const figure = figuras.find(f => f.name === figureName);
        figure.isFavorite = !figure.isFavorite;
        pintarListaFiguras(figurasFiltradas, "all");  // Volvemos a renderizar las figuras
    }

    // Filtrar por precio
    window.filtrarPorPrecio = function() {
        const minPrice = document.getElementById('minPrice').value;
        const maxPrice = document.getElementById('maxPrice').value;

        // Filtrar las figuras por precio
        figurasFiltradas = figuras.filter(figure => {
            return (minPrice ? figure.price >= minPrice : true) &&
                   (maxPrice ? figure.price <= maxPrice : true);
        });

        pintarListaFiguras(figurasFiltradas, "all");  // Volver a pintar las figuras filtradas
    }

    // Ordenar las figuras por nombre
    window.ordenarPorNombre = function() {
        figurasFiltradas.sort((a, b) => a.name.localeCompare(b.name));
        pintarListaFiguras(figurasFiltradas, "all");  // Volver a pintar las figuras ordenadas
    }

    // Mostrar solo las figuras favoritas
    window.verFavoritos = function() {
        figurasFiltradas = figuras.filter(figure => figure.isFavorite);
        pintarListaFiguras(figurasFiltradas, "all");  // Volver a pintar solo las favoritas
    }
}

init();