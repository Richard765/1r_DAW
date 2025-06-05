// Ejercicio 4: DOM e Interacción con API (40%)

// JavaScript (a completar):

// NO MODIFICAR LAS VARIABLES GLOBALES
// API Base URL
const API_URL = 'https://restcountries.com/v3.1';
// Elementos del DOM
const regionSelect = document.getElementById('region');
const sortNameRadio = document.getElementById('sort-name');
const sortPopulationRadio = document.getElementById('sort-population');
const countriesList = document.getElementById('countries-list');
const spinner = document.getElementById('spinner');
const errorAlert = document.getElementById('error-alert');
// Array para almacenar los países
let currentCountries = [];

// 1. Función para mostrar/ocultar elementos (ya implementada, NO MODIFICAR)
function toggleElement(element, show) {
  if (show) {
    element.classList.remove('d-none');
  } else {
    element.classList.add('d-none');
  }
}

// 2. Función para mostrar errores (ya implementada, NO MODIFICAR)
function showError(message) {
  errorAlert.textContent = message;
  toggleElement(errorAlert, true);
  setTimeout(() => toggleElement(errorAlert, false), 5000);
}

// 3. Función para crear una tarjeta de país (ya implementada, NO MODIFICAR)
function createCountryCard(country) {
  const card = document.createElement('div');
  card.className = 'col-md-3 col-sm-6 mb-3'; // Using updated Bootstrap grid classes
  card.innerHTML = `
<div class="card h-100">
<img src="${country.flags.png}" class="card-img-top" alt="${country.name.common} flag" style="height: 120px; object-fit: cover;">
<div class="card-body p-2">
<h6 class="card-title">${country.name.common}</h6>
<p class="card-text small"><strong>Capital:</strong> ${country.capital ? country.capital[0] : 'N/A'}</p>
<p class="card-text small"><strong>Población:</strong> ${country.population.toLocaleString()}</p>
</div>
</div>
`;
  return card;
}

// 4. Añadir event listeners para los elementos interactivos (ya implementada, NO MODIFICAR)
function setupEventListeners() {
  regionSelect.addEventListener('change', (event) => {
    loadCountriesByRegion(event.target.value);
  });
  sortNameRadio.addEventListener('change', sortCountries);
  sortPopulationRadio.addEventListener('change', sortCountries);
}

// 5. Inicializar la aplicación (ya implementada, NO MODIFICAR)
function initApp() {
  setupEventListeners();
  toggleElement(spinner, false);
  toggleElement(errorAlert, false);
  toggleElement(countriesList, true);
  sortNameRadio.disabled = true;
  sortPopulationRadio.disabled = true;
}

// 6. Función para ordenar países (ya implementada, NO MODIFICAR)
function sortCountries() {
  if (currentCountries.length === 0) {
    return;
  }
  if (sortNameRadio.checked) {
    currentCountries.sort((a, b) => a.name.common.localeCompare(b.name.common));
  } else if (sortPopulationRadio.checked) {
    currentCountries.sort((a, b) => b.population - a.population);
  }
  displayCountries();
}

// 7. Función para cargar países por región (COMPLETAR)
async function loadCountriesByRegion(region) {
  // A. Limpia la lista anterior de países (currentCountries) y el contenido del contenedor (countriesList)
  currentCountries = [];
  countriesList.innerHTML = '';

  // B. Oculta la alerta de error (errorAlert) y el contenedor de países (countriesList) mientras carga
  toggleElement(errorAlert, false);
  // No ocultar countriesList aquí, queremos que sea visible incluso si está vacío o cargando

  // C. Deshabilita los botones de ordenación (sortNameRadio, sortPopulationRadio) durante la carga y si no se ha seleccionado región
  sortNameRadio.disabled = true;
  sortPopulationRadio.disabled = true;

  // D. Si no se ha seleccionado ninguna región (el valor de 'region' está vacío),
  // oculta el spinner, muestra el contenedor de la lista (vacío) y sal de la función.
  if (!region) {
    toggleElement(spinner, false);
    toggleElement(countriesList, true); // Asegura que el contenedor esté visible (aunque vacío)
    return;
  }

  // E. Muestra el spinner de carga (spinner)
  toggleElement(spinner, true);

  // F. Define la URL completa para la petición fetch usando API_URL y la 'region' seleccionada
  const url = `${API_URL}/region/${region}`;

  // G. Inicia un bloque try...catch para manejar la petición asíncrona y los posibles errores
  try {
    // a. Realiza la llamada fetch a la URL
    const response = await fetch(url);

    // b. Verifica si la respuesta HTTP fue exitosa (response.ok). Si no, lanza un nuevo Error.
    if (!response.ok) {
      throw new Error(`Error HTTP: ${response.status} - ${response.statusText}`);
    }

    // c. Parsea la respuesta a JSON
    const data = await response.json();

    // d. Verifica si los datos recibidos son un array y no está vacío
    if (Array.isArray(data) && data.length > 0) {
      // i. Guarda el array de países en la variable global currentCountries
      currentCountries = data;
      // ii. Llama a la función sortCountries() para aplicar el ordenación inicial (por nombre, por defecto)
      //     (sortCountries también llama a displayCountries)
      sortNameRadio.checked = true; // Por defecto ordenar por nombre
      sortCountries();
      // iii. Habilita los radio buttons de ordenación (sortNameRadio, sortPopulationRadio)
      sortNameRadio.disabled = false;
      sortPopulationRadio.disabled = false;
    } else {
      // Si los datos no son un array válido o está vacío:
      // i. Llama a showError() indicando que no se encontraron países en esa región
      showError(`No se encontraron países en la región: ${region}`);
      // ii. Muestra el contenedor de la lista (countriesList) que ahora estará vacío
      displayCountries(); // Limpia y muestra lista vacía
    }
  } catch (error) {
    // Dentro del catch (manejo de errores de fetch o errores lanzados):
    // a. Llama a showError() con el mensaje del error
    showError(`Error al cargar los países: ${error.message}`);
    // b. Opcional: Muestra el error completo en la consola del navegador para depuración
    console.error("Error completo al cargar países:", error);
    // c. Muestra el contenedor de la lista (countriesList) que ahora estará vacío
    displayCountries(); // Limpia y muestra lista vacía
  } finally {
    // Dentro de un bloque finally (se ejecuta siempre al final del try/catch):
    // a. Oculta el spinner de carga (spinner)
    toggleElement(spinner, false);
    // Asegurar que la lista de países (aunque esté vacía o con error) sea visible
    toggleElement(countriesList, true);
  }
}

// 8. Función para mostrar la lista de países (COMPLETAR)
function displayCountries() {
  // A. Limpia todo el contenido HTML dentro del contenedor countriesList
  countriesList.innerHTML = '';

  // B. Verifica si el array currentCountries tiene elementos. Si tiene elementos:
  if (currentCountries && currentCountries.length > 0) {
    // Recorre el array currentCountries (puedes usar forEach o un bucle for).
    currentCountries.forEach(country => {
      // i. Llama a createCountryCard() pasando el objeto del país actual para obtener el elemento HTML de la tarjeta.
      const countryCard = createCountryCard(country);
      // ii. Añade (append) el elemento de la tarjeta recién creado al contenedor countriesList.
      countriesList.appendChild(countryCard);
    });
  }
  // C. Asegúrate de que el contenedor countriesList sea visible (aunque esté vacío después de limpiar si no hay países)
  toggleElement(countriesList, true);
}

// Iniciar la aplicación cuando el DOM esté cargado (NO MODIFICAR)
document.addEventListener('DOMContentLoaded', initApp);
