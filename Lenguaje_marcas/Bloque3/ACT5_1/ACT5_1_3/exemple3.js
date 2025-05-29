const API_URL =
  " https://crudcrud.com/api/d9e584c90c654cc0a09a171a2b6cf5ae/tasques"; // aquí va el teu endpoint personalizat

// CREATE: afegir una nova tasca
function crearTasca(nom) {
  fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ nom: nom }),
  })
    .then((res) => {
      if (!res.ok) throw new Error("Error en crear tasca" + res.statusText);
      return res.json();
    })
    .then((dada) => {
      console.log("Tasca creada:", dada);
      llegirTasques();
    })
    .catch((error) => console.error("Error:", error));
}

// READ: llistar totes les tasques
function llegirTasques() {
  fetch(API_URL)
    .then((res) => res.json())
    .then((dades) => {
      console.log("Llista de tasques:");
      dades.forEach((tasca) => {
        console.log(`- ${tasca.nom} (id: ${tasca._id})`);
      });
    });
}

// UPDATE: editar una tasca per ID
function editarTasca(id, nouNom) {
  fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ nom: nouNom }), // Has d'enviar TOT l'objecte, no només els camps canviats
  }).then(() => {
    console.log("Tasca actualitzada");
    llegirTasques();
  });
}

// DELETE: eliminar una tasca per ID
function eliminarTasca(id) {
  fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  })
    .then((res) => {
      if (!res.ok) throw new Error("Error en eliminar");
      console.log("Tasca eliminada");
      llegirTasques();
    })
    .catch((error) => console.error("Error:", error));
}

// Exemple d'ús:
crearTasca("Estudiar JavaScript");
crearTasca("Estudiar més JavaScript");
setTimeout(() => llegirTasques(), 1000);
