const button = document.getElementById("addTaskButton");
const text = document.getElementById("taskInput");
const taskList = document.getElementById("taskList");
let buttonTick;
let buttonBin;


text.addEventListener("keypress", function (event) {
    if (event.key === 'Enter') {
        añadirTarea();
    }
});

button.addEventListener("click", function () {
    añadirTarea();
});

function añadirTarea() {
    if (text.value.trim() !== "") {
        //Instanciar variables
        let newItem = document.createElement("li");
        let buttonTick = document.createElement("button");
        let buttonBin = document.createElement("button");
        
        newItem.innerHTML = text.value;
        buttonTick.innerHTML = ("✔");
        buttonBin.innerHTML = ("🗑");
        
        newItem.appendChild(buttonTick);
        newItem.appendChild(buttonBin);
        taskList.appendChild(newItem);
        text.value = "";
        
        //Evento tachar tarea
        buttonTick.addEventListener("click", function () {
            newItem.classList.toggle("completed");
        });
        
        //Evento borrar tarea
        buttonBin.addEventListener("click", function () {
            taskList.removeChild(newItem);
        });
        
    }
}