let products = [];
let visibleCount = 6;
let currentCategory = 'all';

const productContainer = document.getElementById('productContainer');
const categoryFilter = document.getElementById('categoryFilter');
const loadMoreButton = document.getElementById('loadMore');

// Crear input de búsqueda
const searchInput = document.createElement('input');
searchInput.type = 'text';
searchInput.placeholder = 'Cerca per nom...';
searchInput.id = 'searchInput';
productContainer.parentNode.insertBefore(searchInput, productContainer);

function getUniqueCategories(products) {
  const categories = products.map(p => p.category);
  return ['all', ...new Set(categories)];
}

function renderProducts(productList) {
  productContainer.innerHTML = '';

  productList.forEach(product => {
    const card = document.createElement('div');
    card.className = 'product-card';

    card.innerHTML = `
      <img src="${product.image}" alt="${product.name}">
      <h3>${product.name}</h3>
      <p>${product.price.toFixed(2)} €</p>
      <button class="details-btn">Veure Detalls</button>
    `;

    card.querySelector('.details-btn').addEventListener('click', () => {
      alert(product.description);
    });

    productContainer.appendChild(card);
  });
}

function updateProductDisplay() {
  let filtered = [...products];

  if (currentCategory !== 'all') {
    filtered = filtered.filter(p => p.category === currentCategory);
  }

  const searchTerm = searchInput.value.toLowerCase();
  if (searchTerm) {
    filtered = filtered.filter(p => p.name.toLowerCase().includes(searchTerm));
  }

  const visibleProducts = filtered.slice(0, visibleCount);
  renderProducts(visibleProducts);

  loadMoreButton.classList.toggle('hidden', visibleCount >= filtered.length);
}

function populateCategoryFilter() {
  const categories = getUniqueCategories(products);
  categories.forEach(category => {
    const option = document.createElement('option');
    option.value = category;
    option.textContent = category;
    categoryFilter.appendChild(option);
  });
}

categoryFilter.addEventListener('change', () => {
  currentCategory = categoryFilter.value;
  visibleCount = 6;
  updateProductDisplay();
});

searchInput.addEventListener('input', () => {
  visibleCount = 6;
  updateProductDisplay();
});

loadMoreButton.addEventListener('click', () => {
  visibleCount += 6;
  updateProductDisplay();
});

document.getElementById('year').textContent = new Date().getFullYear();

// Carregar els productes amb fetch()
document.addEventListener('DOMContentLoaded', () => {
  fetch('products.json')
    .then(res => res.json())
    .then(data => {
      products = data;
      populateCategoryFilter();
      updateProductDisplay();
    })
    .catch(error => {
      console.error('Error carregant els productes:', error);
    });
});
