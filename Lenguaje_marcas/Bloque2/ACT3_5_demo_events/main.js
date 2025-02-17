function hello() {
    alert("Hola B");
}

buttonC.onclick = function () {
    alert("Hola C");
};

buttonE.onclick = hello;

buttonF.addEventListener("click", hello);

buttonG.onclick = function (event) {
    console.log("Evento: ", event.type);
    console.log("Elemento objetivo: ", event.currentTarget);
    console.log("Coordenadas: X=", event.clientX, "Y=", event.clientY);
};

let obj = {
    handleEvent(event) {
        switch (event.type) {
            case "click":
                alert("Hola H");
                break;
            case "mouseup":
                alert("Adios H");
                break;
        }
    }
};

buttonH.addEventListener("click", obj);
buttonH.addEventListener("mouseup", obj);
