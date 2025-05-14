const API_URL = 'http://localhost:3000/usuaris';
// Obtenir tots els usuaris
const obtenirUsuaris = async () => {
const resposta = await fetch(API_URL);
const dades = await resposta.json();
console.log('Usuaris:', dades);
};
// Afegir un usuari nou
const afegirUsuari = async (email, nom, cognom) => {
const resposta = await fetch(API_URL, {
method: 'POST',
headers: { 'Content-Type': 'application/json' },
body: JSON.stringify({ email, nom, cognom })
});
const nou = await resposta.json();
console.log('Usuari afegit:', nou);
};
// Actualitzar un usuari existent
const actualitzarUsuari = async (id, email, nom, cognom) => {
const resposta = await fetch(`${API_URL}/${id}`, {
method: 'PUT',
headers: { 'Content-Type': 'application/json' },
body: JSON.stringify({ email, nom, cognom })
});
const actualitzat = await resposta.json();
console.log('Usuari actualitzat:', actualitzat);
};

// Eliminar un usuari
const eliminarUsuari = async (id) => {
await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
console.log(`Usuari amb id ${id} eliminat.`);
};
// Exemple d execució amb una funció autoexecutable
(async () => {
await obtenirUsuaris();
await afegirUsuari('nou.usuari@reqres.in', 'Nou', 'Usuari');
await actualitzarUsuari(1, 'george.bluth@reqres.in', 'George', 'Bluth Sr.');
await eliminarUsuari(2);
await obtenirUsuaris();
})();