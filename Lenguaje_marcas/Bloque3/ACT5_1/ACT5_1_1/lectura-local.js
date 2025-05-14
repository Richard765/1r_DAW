const filePath = "dades.json";
const obtenirUsuaris = async () => {
try {
const resposta = await fetch(filePath);
if (!resposta.ok) {
throw new Error(`Error al carregar el fitxer: ${resposta.status}`);
}
const usuaris = await resposta.json();
console.log("Usuaris des del fitxer local:", usuaris);
mostrarUsuaris(usuaris);
} catch (error) {
console.error("Error en obtenir els usuaris:", error);
}
};
const mostrarUsuaris = (usuaris) => {
const llista = document.getElementById("llista-usuaris");
usuaris.forEach((usuari) => {
const li = document.createElement("li");
li.textContent = `${usuari.nom} (${usuari.edat} anys)`;

llista.appendChild(li);
});
};
const enviarUsuari = async (usuari) => {
try {
const resposta = await fetch(filePath, {
method: "POST",
headers: {
"Content-Type": "application/json", // Indica que s'envia JSON
},
body: JSON.stringify(usuari), // Converteix l'objecte JavaScript a una cadena JSON
});
if (!resposta.ok) {
throw new Error(`Error en la petició POST: ${resposta.status}`);
}
const respostaJSON = await resposta.json();
console.log("Resposta del servidor:", respostaJSON);
// Aquí pots fer alguna cosa amb la resposta del servidor
} catch (error) {
console.error("Error en enviar l'usuari:", error);
}
};
// Exemple d'ús:
const nouUsuari = { nom: "Pere", edat: 25 };
enviarUsuari(nouUsuari);
obtenirUsuaris();