document.addEventListener("DOMContentLoaded", function () {
    const productGrid = document.getElementById("productGrid");
    const searchForm = document.getElementById("searchForm");
    const searchInput = document.getElementById("searchInput");

    // Function to render products
    function renderProducts(products) {
        productGrid.innerHTML = "";
        products.forEach(product => {
            const productItem = document.createElement("div");
            productItem.className = "product-item";
            productItem.innerHTML = `
                <img src="${product.image}" alt="${product.name}">
                <h3>${product.name}</h3>
                <p>$${product.price.toFixed(2)}</p>
                <button onclick="addToCart(${product.id})">Add to Cart</button>
                <button onclick="addToWishlist(${product.id})">Add to Wishlist</button>
            `;
            productGrid.appendChild(productItem);
        });
    }

    // Function to handle add to cart
    window.addToCart = function (productId) {
        alert(`Product ${productId} added to cart.`);
        // Implement actual add to cart logic here
    };

    // Function to handle add to wishlist
    window.addToWishlist = function (productId) {
        alert(`Product ${productId} added to wishlist.`);
        // Implement actual add to wishlist logic here
    };

    // Fetch products and render them
    async function fetchProducts(query = '') {
        const response = await fetch(`/api/products/search?query=${query}`);
        const products = await response.json();
        renderProducts(products);
    }

    // Initial load of products
    fetchProducts();

    // Search functionality
    searchForm.addEventListener("submit", function (event) {
        event.preventDefault();
        fetchProducts(searchInput.value);
    });
});
