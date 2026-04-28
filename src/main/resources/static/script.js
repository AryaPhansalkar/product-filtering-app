async function loadProducts() {
    const price = document.getElementById("price").value;
    const category = document.getElementById("category").value;

    let url = "/api/products?";
    if (price) url += "price=" + price + "&";
    if (category) url += "category=" + category;

    const res = await fetch(url);
    const data = await res.json();

    const table = document.getElementById("tableBody");
    const emptyMsg = document.getElementById("emptyMessage");

    table.innerHTML = "";
    emptyMsg.innerText = "";

    if (data.length === 0) {
        emptyMsg.innerText = "No products found.";
        return;
    }

    data.forEach(p => {
        const row = `<tr>
            <td>${p.name}</td>
            <td>${p.category}</td>
            <td>₹${p.price}</td>
        </tr>`;
        table.innerHTML += row;
    });
}