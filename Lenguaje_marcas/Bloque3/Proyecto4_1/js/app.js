const productosTag = document.getElementById('productos');
const orderFilterTag = document.getElementById('orderFilter');
let shoes = [];
let shoesJSON = [];
let shoesFavorites = [];

window.onload = async () => {
    const respuesta = await fetch('./data/products.json');
    shoesJSON = await respuesta.json();
    printShoes(shoesJSON);
    handleFavorites();
    loadFavorites();

    orderFilterTag.addEventListener("change", function(){
        sortShoes();
        loadFavorites();
        handleFavorites();
    });
};

const printShoes = (shoes) => {
    productosTag.innerHTML = "";
    shoes.forEach(e => {
        let template = `
        <article class="card">
            <img src="./img/${e.image}" alt="" />
            <p class="name">${e.name}</p>
            <p>Precio ${e.price}€</p>
            <p>${e.colors}</p>
            <div class="favorite">
                <i class="fas fa-heart" data-id="${e.id}"></i>
            </div>
        </article>`;
        productosTag.innerHTML += template;
    });
};

const changeView = (number)=>{
    if (number===4){
        productosTag.classList.replace("grid-6", "grid-4");
    }else if (number===6){
        productosTag.classList.replace("grid-4", "grid-6");
    }
};

orderFilterTag.addEventListener("change", function(){
    sortShoes();
    loadFavorites();
    handleFavorites();
});

const sortShoes = () => {
    let index = orderFilterTag.selectedIndex;
    let option = orderFilterTag.options[index];
    let nuevaLista = [];
    if (option.value === 'P') {
        nuevaLista = shoesJSON.sort((a, b) => a.price - b.price);
    } else if (option.value === 'N') {
        nuevaLista = shoesJSON.sort((a, b) => {
            if (a.name > b.name) return 1;
            else if (a.name < b.name) return -1;
            else return 0;
        });
    } else {
        return;
    }

    printShoes(nuevaLista);
};

const handleFavorites = () => {
    const favoritesList = document.querySelectorAll(".fa-heart");
    favoritesList.forEach(fav => {
        fav.addEventListener("click", function(){
            this.classList.toggle("on");
            saveFavorites(this);
        });
    });
};

const saveFavorites = (favObj) => {
    let idFavorite = favObj.dataset.id;
    if(favObj.classList.contains("on")){
        shoesFavorites.push({"id":idFavorite});
    } else {
        shoesFavorites = shoesFavorites.filter(e=>e.id != idFavorite);
    }
    localStorage.setItem("shoesFavorites", JSON.stringify(shoesFavorites));
};

const loadFavorites = () => {
    if (localStorage.getItem("shoesFavorites")){
        shoesFavorites = JSON.parse(localStorage.getItem("shoesFavorites"));
    } else {
        shoesFavorites=[];
    }

    shoesFavorites.forEach(fav => {
        document.querySelector(`.fa-heart[data-id]="${fav.id}"]`).classList.add("on");
    });
};