const showItems = document.querySelector("#show-items");
const formSearch = document.querySelector("#form-search");
const tableBody = document.querySelector("#table-body");
const svgIcon = document.querySelector("#update-icon");
const inputSearchHeader = document.querySelector("#input-search-form");
const closeModalUpdateButton = document.querySelector(".close-button-update");
const modalContainerUpdate = document.querySelector(".modal-container-update");
const formEdit = document.querySelector("#form-edit-product");

closeModalUpdateButton.addEventListener("click", () => {
  modalContainerUpdate.style.display = "none";
});

inputSearchHeader.addEventListener("submit", async (event) => {
  event.preventDefault();
  const data = Object.fromEntries(new FormData(inputSearchHeader)).name;
  const productsFound = await findByName(data);
  counterOfItemsOnTable(productsFound);
  updateTable(productsFound);
});

window.addEventListener("load", async () => {
  counterOfItemsOnTable(await getAll());
  updateTable(await getAll());
});

svgIcon.addEventListener("click", async () => {
  counterOfItemsOnTable(await getAll());
  updateTable(await getAll());
});

formEdit.addEventListener("submit", async (event) => {
  event.preventDefault();

  const formData = new FormData(formEdit);
  const data = Object.fromEntries(formData.entries());

  const requestDto = {
    id: formEdit.dataset.id,
    name: data.name,
    price: data.price,
    quantity: data.quantity,
  };

  const response = await updateItem(requestDto);

  counterOfItemsOnTable(response);
  updateTable(response);
});

tableBody.addEventListener("click", async (event) => {
  const editButton = event.target.closest(".edit");
  if (editButton) {
    const row = editButton.closest("tr");
    if (row) {
      formEdit.dataset.id = row.children[0].innerText;
      modalContainerUpdate.style.display = "flex";
    }
  }
});

tableBody.addEventListener("click", async (event) => {
  const deleteButton = event.target.closest(".delete");
  if (deleteButton) {
    const row = deleteButton.closest("tr");
    if (row) {
      const id = row.firstElementChild.innerText;
      await deleteProduct(id);
      counterOfItemsOnTable(await getAll());
      updateTable(await getAll());
    }
  }
});

async function updateItem(item) {
  const response = await fetch(`http://localhost:8080/items`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(item),
  });
  return response.json();
}

async function deleteProduct(id) {
  await fetch(`http://localhost:8080/items/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
}

function updateTable(productItems) {
  tableBody.innerHTML = "";
  productItems.forEach((element) => {
    const tr = document.createElement("tr");
    const id = document.createElement("td");
    const name = document.createElement("td");
    const price = document.createElement("td");
    const quantity = document.createElement("td");
    const total = document.createElement("td");
    const deleteButton = document.createElement("td");
    const deleteIcon = document.createElement("img");
    const editIcon = document.createElement("img");

    deleteButton.appendChild(deleteIcon);
    deleteButton.appendChild(editIcon);

    deleteIcon.classList.add("delete");
    deleteIcon.src = "/assets/icons/delete.svg";

    editIcon.classList.add("edit");
    editIcon.src = "/assets/icons/edit.svg";

    id.innerText = element.itemId;
    name.innerText = element.product.name;
    price.innerText = `R$${element.product.price}`;
    quantity.innerText = element.quantity;
    total.innerText = element.totalPrice;

    tr.appendChild(id);
    tr.appendChild(name);
    tr.appendChild(price);
    tr.appendChild(quantity);
    tr.appendChild(total);
    tr.appendChild(deleteButton);

    tableBody.appendChild(tr);
  });
}

async function counterOfItemsOnTable(productList) {
  const productItems = productList;
  if (productItems.length > 1) {
    showItems.innerText = `Mostrando ${productItems.length} itens`;
  } else {
    showItems.innerText = `Mostrando ${productItems.length} item`;
  }
  svgIcon.classList.remove("d-none");
}

async function getAll() {
  const response = await fetch(`http://localhost:8080/items`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });
  return response.json();
}

async function findByName(productName) {
  const response = await fetch(
    `http://localhost:8080/items/search?name=${productName}`,
    {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    }
  );
  return response.json();
}
