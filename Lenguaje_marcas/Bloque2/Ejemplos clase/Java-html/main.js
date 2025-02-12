function hello() {
    alert("Hola B");
}

buttonC.onclick = function () {
    alert("Hola C");
}

buttonE.onclick = hello;

buttonF.addEventListener("click", obj);

buttonG.onclick = function (event {
    console.log("Hola G");
})

let obj = {
    handleEvent(event){
        aswitch (event.type) {
            case "click":
                alert("Hola H");
                break;
            case "mouseup":
                alert("Adios H");
                break;
        }
    }
}

buttonH.addEventListener("click", obj);
buttonH.addEventListener("mouseup", obj);