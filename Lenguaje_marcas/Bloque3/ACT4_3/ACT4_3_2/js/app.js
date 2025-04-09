// Contants amb les referencies als elements HTML
const listTag = document.querySelector('#figures-list');
const priceTag = document.querySelector('#filter-price');
const priceMinTag = document.querySelector('#filter-min-price');
const btnFiltrarTag = document.getElementById("btn-filter");

let figuresList = [];

// TODO:Petició asíncona per recuperar les figures
function getFigures() {
    const promise = fetch("./data/star-wars-figures.json");

    promise.then(function()) {
        
    }
}


// TODO:Crea les cards HTML de cada figura 
function printFigures(listJSON) {
   
}

// TODO: Intercanvia el icone de favorit
function setFavourites() {

}

// TODO: Filtra les figures per preu i les ordena
function filterFigures() {
  
}

/*
// Filtre amb programació funcional
function filterFigures() {
    let list =[];
    for (let figure of figuresList){
        // El valor de la figura debe estar entre el mínimo y el máximo especificado
        if (figure.price>=priceMinTag.value && figure.price<=priceTag.value ){
            list.push(figure);
        }
    }
    if (list.length == 0) {
        listTag.innerHTML = "No hay figuras que coincidan con el filtro";
    } else {
        printFigures(list);
    }
}
*/

// Funció inicial de càrrega de la página
function init() {
    getFigures();
    btnFiltrarTag.addEventListener("click", filterFigures);
}
init();