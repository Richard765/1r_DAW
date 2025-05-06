const filterNameTag = document.querySelector("#filterName");

let state = {
  canciones: [],
  cancionesFiltradas: [],
  favoritos: [],
  cancionPlay: 1,
};

init();

function init() {
  cargarEstadoStorage();
  cargarCanciones();
  filterNameTag.addEventListener("input", handleFilter);
}

function handleFilter() {
  const textoFiltro = filterNameTag.value.trim().toLowerCase();
  state.cancionesFiltradas = filtrarCanciones(state.canciones, textoFiltro);
  pintarCanciones(state.cancionesFiltradas);
}

function cargarCanciones() {
  fetch("./data/canciones.json")
    .then(response => response.json())
    .then(data => {
      state.canciones = data.canciones;
      state.cancionesFiltradas = [...state.canciones];
      pintarCanciones(state.cancionesFiltradas);
      loadFavoritos();
      setCancionSonando(state.cancionPlay);
    })
    .catch(error => console.error("Error carregant les cançons:", error));
}

function pintarCanciones(lista) {
  const contenedor = document.querySelector("#contenedorCanciones");
  contenedor.innerHTML = "";

  lista.forEach(cancion => {
    contenedor.innerHTML += `
      <tr id="song-${cancion.id}" data-id="${cancion.id}" class="song">
        <th scope="row" class="volume"></th>
        <th><i id="icono-${cancion.id}" class="bi bi-heart"></i></th>
        <td class="title">${cancion.titulo}</td>
        <td>${cancion.artista}</td>
        <td>${cancion.album}</td>
        <td>${cancion.publicacion}</td>
        <td>${cancion.duracion}</td>
      </tr>
    `;
  });

  configurarMarcarFavorito();
  configurarMarcarCancionSonando();
  loadFavoritos();
}

function configurarMarcarFavorito() {
  const corazones = document.querySelectorAll(".bi-heart, .bi-heart-fill");
  corazones.forEach(icono => {
    icono.addEventListener("click", (e) => {
      const id = parseInt(e.target.id.replace("icono-", ""));
      if (state.favoritos.includes(id)) {
        deleteFavoritoStorage(id);
      } else {
        addFavoritoStorage(id);
      }
      pintarCanciones(state.cancionesFiltradas);
    });
  });
}

function configurarMarcarCancionSonando() {
  const filas = document.querySelectorAll(".song");
  filas.forEach(fila => {
    fila.addEventListener("click", () => {
      const id = parseInt(fila.dataset.id);
      setCancionSonando(id);
    });
  });
}

function cargarEstadoStorage() {
  const estadoGuardado = localStorage.getItem("stateSpotify");
  if (estadoGuardado) {
    state = JSON.parse(estadoGuardado);
  }
}

function loadFavoritos() {
  state.favoritos.forEach(id => {
    const icono = document.querySelector(`#icono-${id}`);
    if (icono) {
      icono.classList.remove("bi-heart");
      icono.classList.add("bi-heart-fill");
    }
  });
}

function addFavoritoStorage(idFavorito) {
  if (!state.favoritos.includes(idFavorito)) {
    state.favoritos.push(idFavorito);
    guardarEstado();
  }
}

function deleteFavoritoStorage(idFavorito) {
  state.favoritos = state.favoritos.filter(id => id !== idFavorito);
  guardarEstado();
}

function guardarEstado() {
  localStorage.setItem("stateSpotify", JSON.stringify(state));
}

function filtrarCanciones(lista, nombreCancion) {
  return lista.filter(cancion =>
    cancion.titulo.toLowerCase().includes(nombreCancion)
  );
}

function setCancionSonando(id) {
  const filas = document.querySelectorAll(".song");
  filas.forEach(fila => {
    fila.classList.remove("playing");
    const volumenIcono = fila.querySelector(".volume");
    if (volumenIcono) {
      volumenIcono.innerHTML = "";
    }
  });

  const filaActual = document.querySelector(`#song-${id}`);
  if (filaActual) {
    filaActual.classList.add("playing");
    const volumenIcono = filaActual.querySelector(".volume");
    volumenIcono.innerHTML = `<i class="bi bi-volume-up"></i>`;
    state.cancionPlay = id;
    guardarEstado();
  }
}
