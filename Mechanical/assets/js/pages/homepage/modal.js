const headerButton = document.querySelector("#form-button-header");
const closeModalButton = document.querySelector(".close-button");
const modalContainer = document.querySelector(".modal-container");
const formAddProduct = document.querySelector("#form-add-product");

closeModalButton.addEventListener("click", () => {
  modalContainer.style.display = "none";
});

headerButton.addEventListener("click", (event) => {
  event.preventDefault();
  modalContainer.style.display = "flex";
});

formAddProduct.addEventListener("submit", async (event) => {
  event.preventDefault();
  const data = Object.fromEntries(new FormData(formAddProduct));
  addProduct(data);
  modalContainer.style.display = "none";
  location.reload();
});

async function addProduct(data) {
  const response = await fetch(`http://localhost:8080/items`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  return response.json();
}
