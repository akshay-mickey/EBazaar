document.addEventListener('DOMContentLoaded', () => {
    const productList = document.getElementById('product-list');
    const createProductForm = document.getElementById('create-product-form');
    const updateProductDiv = document.getElementById('update-product');
    const updateProductForm = document.getElementById('update-product-form');

    // Load products
    async function loadProducts() {
        try {
            const response = await fetch('http://localhost:8088/api/products');
            const products = await response.json();
            productList.innerHTML = products.map(prod => `
                <li>
                    <span>${prod.name} - $${prod.price.toFixed(2)}</span>
                    <button onclick="editProduct(${prod.id}, '${prod.name}', ${prod.price}, '${prod.description}', '${prod.imageUrl}', ${prod.category.id})">Edit</button>
                    <button onclick="deleteProduct(${prod.id})">Delete</button>
                </li>
            `).join('');
        } catch (error) {
            console.error('Error loading products:', error);
        }
    }

    // Create product
    createProductForm.addEventListener('submit', async (event) => {
        event.preventDefault();
        const name = document.getElementById('product-name').value;
        const price = parseFloat(document.getElementById('product-price').value);
        const description = document.getElementById('product-description').value;
        const imageUrl = document.getElementById('product-image-url').value;
        const categoryId = parseInt(document.getElementById('product-category').value);

        try {
            const response = await fetch('http://localhost:8088/api/products', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name, price, description, imageUrl, category: { id: categoryId } })
            });

            if (response.ok) {
                alert('Product created successfully');
                loadProducts();
            } else {
                alert('Failed to create product');
            }
        } catch (error) {
            console.error('Error creating product:', error);
        }
    });

    // Update product
    updateProductForm.addEventListener('submit', async (event) => {
        event.preventDefault();
        const id = document.getElementById('update-product-id').value;
        const name = document.getElementById('update-product-name').value;
        const price = parseFloat(document.getElementById('update-product-price').value);
        const description = document.getElementById('update-product-description').value;
        const imageUrl = document.getElementById('update-product-image-url').value;
        const categoryId = parseInt(document.getElementById('update-product-category').value);

        try {
            const response = await fetch(`http://localhost:8088/api/products/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name, price, description, imageUrl, category: { id: categoryId } })
            });

            if (response.ok) {
                alert('Product updated successfully');
                updateProductDiv.style.display = 'none';
                loadProducts();
            } else {
                alert('Failed to update product');
            }
        } catch (error) {
            console.error('Error updating product:', error);
        }
    });

    // Edit product
    window.editProduct = (id, name, price, description, imageUrl, categoryId) => {
        document.getElementById('update-product-id').value = id;
        document.getElementById('update-product-name').value = name;
        document.getElementById('update-product-price').value = price;
        document.getElementById('update-product-description').value = description;
        document.getElementById('update-product-image-url').value = imageUrl;
        document.getElementById('update-product-category').value = categoryId;
        updateProductDiv.style.display = 'block';
    }

    // Delete product
    window.deleteProduct = async (id) => {
        try {
            const response = await fetch(`http://localhost:8088/api/products/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                alert('Product deleted successfully');
                loadProducts();
            } else {
                alert('Failed to delete product');
            }
        } catch (error) {
            console.error('Error deleting product:', error);
        }
    }

    loadProducts();
});
