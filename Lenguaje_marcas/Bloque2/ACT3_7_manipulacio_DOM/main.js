// 1. Seleccionar elementos del DOM
let title = document.getElementById("title");
console.log(title);

let mainDiv = document.querySelector(".main-div");
console.log(mainDiv);

let listItems = document.querySelectorAll("ul.list > li");
console.log(listItems);

// 2. Modificar elementos del DOM
title.innerHTML = "<em>Nuevo</em>";

let image = document.querySelector("img");
image.setAttribute("src", "bun-logo.svg");
image.classList.add("img-fluid");

mainDiv.style.backgroundColor = "#FFcc00";

// 3. Crear y eliminar elementos del DOM
let oldDiv = document.querySelector(".old-div");
if (oldDiv) {
    document.body.removeChild(oldDiv);
}

let newDiv = document.createElement("div");
newDiv.textContent = "Soy un div nuevo";
document.body.appendChild(newDiv);

//4. Eventos en el DOM
let buttonA = document.querySelector(".buttonA");
buttonA.addEventListener("click", function () {
    alert("Boton presionado");
});

let butonB = document.querySelector(".buttonB");
function showMessage(message) {
    alert(message);
}

//5. Lista dinamica
let input = document.getElementById("itemInput");
let addButton = document.getElementById("addButton");
let list = document.getElementById("dynamicList");

addButton.addEventListener("click", function () {
	if (input.value.trim() !== "") {
		let newItem = document.createElement("li");
		newItem.innerText = input.value;
		list.appendChild(newItem);
		input.value = "";
	}
});

//6 Filtrado de elementos del DOM
