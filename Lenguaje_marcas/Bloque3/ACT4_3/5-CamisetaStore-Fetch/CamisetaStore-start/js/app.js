// Referencia a las etiquetas HTML
const camisetasTag = document.querySelector('#camisetas-container');
const cartTag = document.querySelector('#cart-user');

let camisetasJSON = [];
let carrito = [];

let currentPage = 1;
const itemsPerPage = 4;

const renderCamisetas = () => {
  camisetasTag.innerHTML = '';

  // Calcular el índice de los elementos a mostrar
  const start = (currentPage - 1) * itemsPerPage;
  const end = start + itemsPerPage;
  const camisetasToShow = camisetasJSON.slice(start, end);

  camisetasToShow.forEach(camiseta => {
    const card = document.createElement('article');
    card.className = 'card';

    // Mostrar los colores como círculos
    const colorCircles = camiseta.colors.map(color => {
      return `<span class="color-circle" style="background-color:${color}"></span>`;
    }).join(' ');

    card.innerHTML = `
      <img src="./img/${camiseta.image}" alt="${camiseta.name}">
      <h3>${camiseta.name}</h3>
      <p>Precio: ${camiseta.price}€</p>
      <p>Stock: ${camiseta.stock}</p>
      <p>Colores: ${colorCircles}</p>
      <p>Tallas: ${camiseta.sizes.join(', ')}</p>
      <button class="btn btn-primary">Añadir al carrito</button>
    `;

    camisetasTag.appendChild(card);
  });

  renderPagination();
};

const renderPagination = () => {
  const totalPages = Math.ceil(camisetasJSON.length / itemsPerPage);

  const pagination = document.createElement('div');
  pagination.className = 'pagination';

  for (let i = 1; i <= totalPages; i++) {
    const btn = document.createElement('button');
    btn.textContent = i;
    btn.className = i === currentPage ? 'btn btn-secondary mx-1' : 'btn btn-light mx-1';
    btn.addEventListener('click', () => {
      currentPage = i;
      renderCamisetas();
    });
    pagination.appendChild(btn);
  }

  camisetasTag.appendChild(pagination);
};

const toggleDarkMode = () => {
  document.body.classList.toggle('dark-mode');
};

// Cargar los datos
fetch('../data/camisetas.json')
  .then(res => res.json())
  .then(data => {
    camisetasJSON = data;
    renderCamisetas();
  })
  .catch(err => console.error('Error cargando camisetas:', err));

// Crear botón modo oscuro
const darkModeBtn = document.createElement('button');
darkModeBtn.textContent = '🌙 Modo Oscuro';
darkModeBtn.className = 'btn btn-dark my-3';
darkModeBtn.style.position = 'fixed';
darkModeBtn.style.top = '1rem';
darkModeBtn.style.right = '1rem';
darkModeBtn.addEventListener('click', () => {
  toggleDarkMode();
  darkModeBtn.textContent = document.body.classList.contains('dark-mode') ? '☀️ Modo Claro' : '🌙 Modo Oscuro';
});
document.body.appendChild(darkModeBtn);
