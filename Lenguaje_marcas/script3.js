let tornActual = "X";
let estatCaselles = ["", "", "", "", "", "", "", "", ""];
let jocActiu = true;

const casellesHTML = document.querySelectorAll(".casella");
const missatge = document.getElementById("missatge");
const reiniciarBtn = document.getElementById("reiniciar");

const combinacionsGuanyadores = [
    [0, 1, 2], [3, 4, 5], [6, 7, 8], // Files
    [0, 3, 6], [1, 4, 7], [2, 5, 8], // Columnes
    [0, 4, 8], [2, 4, 6]             // Diagonals
];

casellesHTML.forEach(casella => {
    casella.addEventListener("click", gestionarClicCasella);
});

reiniciarBtn.addEventListener("click", reiniciarJoc);

function gestionarClicCasella(event) {
    const index = event.target.dataset.index;
    if (estatCaselles[index] !== "" || !jocActiu) return;

    estatCaselles[index] = tornActual;
    event.target.textContent = tornActual;
    comprovarGuanyador();
    tornActual = tornActual === "X" ? "O" : "X";
}

function comprovarGuanyador() {
    for (const combinacio of combinacionsGuanyadores) {
        const [a, b, c] = combinacio;
        if (estatCaselles[a] && estatCaselles[a] === estatCaselles[b] && estatCaselles[a] === estatCaselles[c]) {
            missatge.textContent = `Guanyador: ${estatCaselles[a]}`;
            jocActiu = false;
            return;
        }
    }

    if (!estatCaselles.includes("")) {
        missatge.textContent = "Empat!";
        jocActiu = false;
    }
}

function reiniciarJoc() {
    estatCaselles = ["", "", "", "", "", "", "", "", ""];
    jocActiu = true;
    tornActual = "X";
    missatge.textContent = "";
    casellesHTML.forEach(casella => casella.textContent = "");
}
