// Per aquests exercicis farem servir l'API fetch de https://reqres.in/api/users
// (una altra API per proves amb fetch https://jsonplaceholder.typicode.com/todos)
// (el vídeo que originà d'aquest exercicis https://www.youtube.com/watch?v=cuEtnrL9-H0)
// (un altre vídeo interessant https://www.youtube.com/watch?v=eLqMkQf4Qks)

// 1. EXERCICI: Escriu "https://reqres.in/api/users" a la barra de navegació del teu navegador per comprovar que porta a un fitxer JSON (una llista d'usuaris)

// 2. EXERCICI: Fes una crida amb fetch() i mostra què retorna per defecte (una promesa)
console.log(fetch("https://reqres.in/api/users")); 

// 3. EXERCICI: Fes un fetch i mostra l'objecte 'response'. Quines propietats té?
fetch("https://reqres.in/api/users")
  .then(response => {
    console.log(response);
  });

// 4. EXERCICI: Converteix l'objecte 'response' en un objecte JavaScript fent servir .json()
fetch("https://reqres.in/api/users")
  .then(response => response.json())
  .then(data => {
    console.log(data); 
  });
  
// 5. EXERCICI: Fes un fetch a una pàgina que no retorna JSON. Comprova què passa.
// Mostra l'error amb un .catch()
fetch("https://example.com") 
  .then(response => response.json()) 
  .then(data => console.log(data))
  .catch(error => console.error("Error parsejant JSON:", error));

// 6. EXERCICI: Fes un fetch per obtenir un usuari concret (per exemple, l'usuari 5)
fetch("https://reqres.in/api/users/5")
  .then(response => response.json())
  .then(data => console.log("Usuari 5:", data));

// 7. EXERCICI: Fes un fetch d’un usuari que no existeix (ex: usuari 23). Què retorna? Dona error?
fetch("https://reqres.in/api/users/23")
  .then(response => {
    console.log("Response status:", response.status);
    return response.json();
  })
  .then(data => console.log("Usuari 23:", data));

// 8. EXERCICI: Comprova si la resposta ha estat correcta mirant la propietat response.ok
// Mostra un missatge amb el codi HTTP si tot ha anat bé o llença un error si ha fallat.
fetch("https://reqres.in/api/users/5")
  .then(response => {
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    return response.json();
  })
  .then(data => console.log("Dades correctes:", data))
  .catch(error => console.error("S'ha produït un error:", error));

// 9. EXERCICI: Repeteix l'exercici anterior però fent servir async/await en lloc de .then() per escriure una funció async anomenada fetchUser()
async function fetchUser(id) {
    const response = await fetch(`https://reqres.in/api/users/${id}`);
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    const data = await response.json();
    console.log("Usuari amb async/await:", data);
  }
  fetchUser(5).catch(error => console.error(error));

// 10. EXERCICI: Fes servir async/await per retornar les dades des d'una funció async fetchUser().
// La funció retorna una promesa. Mostra les dades usant .then() fora de la funció.
async function fetchUserData(id) {
  const response = await fetch(`https://reqres.in/api/users/${id}`);
  if (!response.ok) {
    throw new Error(`Error HTTP: ${response.status}`);
  }
  return await response.json(); // Retorna les dades
}
fetchUserData(5)
  .then(data => console.log("Dades retornades:", data))
  .catch(error => console.error("Error capturat:", error));

// 11. EXERCICI: Fes servir async/await però sense try/catch dins la funció.
// Deixa que la funció llenci un error i captura'l des de fora amb .catch()
// Nota: encara que throw en general sempre requereix estar dins d'un bloc try, les
// funcions async són una excepció, i poden tenir un throw fora d'un bloc try.
async function fetchUserWithoutTry(id) {
    const response = await fetch(`https://reqres.in/api/users/${id}`);
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status}`);
    }
    return await response.json();
  }
  fetchUserWithoutTry(23)
    .then(data => console.log("Usuari:", data))
    .catch(error => console.error("Error capturat des de fora:", error));