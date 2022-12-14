// implement toaster for success "Événement créé avec succès." <div class="toast-container position-static">
const toastContainer = document.createElement("div");
form.appendChild(toastContainer);
toastContainer.classList.add(
  "toast-container",
  "position-absolute",
  "bottom-0",
  "end-0",
  "p-3"
);

const firstToastDiv = document.createElement("div");
toastContainer.appendChild(firstToastDiv);
firstToastDiv.classList.add(
  "toast",
  "align-items-center",
  "bg-success",
  "text-white"
);

firstToastDiv.setAttribute("role", "alert");

const secondToastDiv = document.createElement("div");
secondToastDiv.classList.add("d-flex");
firstToastDiv.appendChild(secondToastDiv);

const thirdToastDiv = document.createElement("div");
thirdToastDiv.classList.add("toast-body");
thirdToastDiv.innerHTML = "Événement créé avec succès.";
secondToastDiv.appendChild(thirdToastDiv);

const toast = new bootstrap.Toast(firstToastDiv);
