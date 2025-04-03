
function init() {
    // Inicialment mostram totes les figures
    getFigures("all");
    let buttonsList = document.querySelectorAll('.btn-check');
    for (const button of buttonsList) {
        button.addEventListener("click", function () {
            getFigures(this.value);
        });
    }
}

function getFigures(pType) {
    // Petició asíncrona
    fetch('./data/figures.json')
        .then(response => response.json())
        .then((collection) => {
            console.log("name", collection.nameCollection);
            pintarListaFiguras(collection.figures, pType);

        });
}

const pintarListaFiguras = (listaFiguras, pType) => {
    const container = document.getElementById("card-container");
    container.innerHTML = "";
    for (let figure of listaFiguras) {
        if (pType == figure.type || pType=="all") {
            container.innerHTML += `
                <div class="card mb-3" style="max-width: 540px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="img/${figure.img}" width="100%" alt="tanos image">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${figure.name}</h5>
                                <p class="card-text">${figure.description}</p>
                                <p class="card-text"><small class="text-muted">Precio ${figure.price}€</small></p>
                                <a href="#" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                    </div>
                </div>
            `;
        }
    }
};

init();
