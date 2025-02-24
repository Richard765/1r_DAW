window.onload = (event) => {
    window.alert("Bienvenido");
    
    let cat = document.getElementById("cat");
    let botonGo = document.getElementById("btn-go");
    let datos = document.getElementById("dades");
    let logo = document.getElementById("logo");
    
    cat.addEventListener("change", cambio_categoria);
    botonGo.addEventListener("click", click_boton);
    datos.addEventListener("keyup", escribir_texto);
    logo.addEventListener("mouseover", cambiar_imagen);
    logo.addEventListener("mouseout", restaurar_imagen);
};

function cambio_categoria () {
    alert("Categoría cambiada");
    actualizar_especialidad(document.getElementById("cat").value);
}

function click_boton() {
    alert("Has hecho clic en el botón");
}

function escribir_texto() {
    alert("Has escrito: " + document.getElementById("dades").value);
}

function cambiar_imagen() {
    document.getElementById("logo").src = "https://www.uoc.edu/portal/system/modules/edu.uoc.resources/resources/common/img/icons/favicon/uoc/favicon-32x32.png";
}

function restaurar_imagen() {
    document.getElementById("logo").src = "https://www.udemy.com/staticx/udemy/images/v6/favicon-32x32.png";
}

function actualizar_especialidad(categoria) {
    let esp = document.getElementById("esp");
    let opciones = {
        "p": ["java", "php", "python"],
        "x": ["IPV4", "AZURE", "CISCO"],
        "s": ["Certificados", "Phishing", "Cloud"]
    };
    esp.innerHTML = "";
    opciones[categoria].forEach(item => {
        let opcion = document.createElement("option");
        opcion.textContent = item;
        opcion.value = item.toLowerCase();
        esp.appendChild(opcion);
    });
}
