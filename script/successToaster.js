// implement toaster for success "Événement créé avec succès." <div class="toast-container position-static">
const staticDiv = document.createElement("div");
form.appendChild(staticDiv);
staticDiv.classList.add("toast-container");
staticDiv.classList.add("position-absolute");
staticDiv.classList.add("bottom-0");
staticDiv.classList.add("end-0");
staticDiv.classList.add("p-3");

const firstToastDiv = document.createElement("div");
staticDiv.appendChild(firstToastDiv);
firstToastDiv.classList.add("toast");
firstToastDiv.classList.add("align-items-center");
firstToastDiv.setAttribute("role", "alert");
firstToastDiv.setAttribute("aria-live", "assertive");
firstToastDiv.setAttribute("aria-atomic", true);
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
