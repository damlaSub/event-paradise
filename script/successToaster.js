// implement toaster for success "Événement créé avec succès." <div class="toast-container position-static">
const toastContainer = document.createElement("div");
form.appendChild(toastContainer);
toastContainer.classList.add("toast-container");
toastContainer.classList.add("position-absolute");
toastContainer.classList.add("bottom-0");
toastContainer.classList.add("end-0");
toastContainer.classList.add("p-3");

const firstToastDiv = document.createElement("div");
toastContainer.appendChild(firstToastDiv);
firstToastDiv.classList.add("toast");
firstToastDiv.classList.add("align-items-center");
firstToastDiv.setAttribute("role", "alert");
firstToastDiv.classList.add("bg-success");
firstToastDiv.classList.add("text-white");

const secondToastDiv = document.createElement("div");
secondToastDiv.classList.add("d-flex");
firstToastDiv.appendChild(secondToastDiv);

const thirdToastDiv = document.createElement("div");
thirdToastDiv.classList.add("toast-body");
thirdToastDiv.innerHTML = "Événement créé avec succès.";
secondToastDiv.appendChild(thirdToastDiv);

const toast = new bootstrap.Toast(firstToastDiv);
