const resultatElement = document.getElementById("resultat");

function randomSelect(array) {
    return array[Math.floor(Math.random() * array.length)];
}

function jugar(eleccioUsuari) {
    const eleccioOrdinador = randomSelect(["pedra", "paper", "tisores"]);
    let resultat = "";
    
    if (eleccioUsuari === eleccioOrdinador) {
        resultat = "Empat!";
    } else if (
        (eleccioUsuari === "pedra" && eleccioOrdinador === "tisores") ||
        (eleccioUsuari === "paper" && eleccioOrdinador === "pedra") ||
        (eleccioUsuari === "tisores" && eleccioOrdinador === "paper")
    ) {
        resultat = "Has guanyat!";
    } else {
        resultat = "Has perdut!";
    }
    
    resultatElement.innerHTML = `Has triat ${eleccioUsuari}. L'ordinador ha triat ${eleccioOrdinador}. ${resultat}`;
}

document.getElementById("pedra").addEventListener("click", () => jugar("pedra"));
document.getElementById("paper").addEventListener("click", () => jugar("paper"));
document.getElementById("tisores").addEventListener("click", () => jugar("tisores"));