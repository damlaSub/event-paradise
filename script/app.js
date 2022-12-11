const tooltipTriggerList = document.querySelectorAll(
  '[data-bs-toggle="tooltip"]'
);
const tooltipList = [...tooltipTriggerList].map(
  (tooltipTriggerEl) => new bootstrap.Tooltip(tooltipTriggerEl)
);

const form = document.querySelector("form");

const elements = form.elements;
/*
  for(let i = 0; i < elements.length; i++){
      console.log(elements[i]);
  }
  */
// if I have invalid inputs:
// I would have input alerts (red):
// and error messages as tooltip:
for (const element of elements) {
  // like for(String str: strings) en java
  const type = element.type;

  if (type != "submit") {
    element.addEventListener("invalid", (event) => {
      event.preventDefault(); //prevent the event html validdation (field control)

      element.classList.add("is-invalid"); // we will get invalid elements
      //const invalidElement = form.getElementsByClassName("is-invalid");
      const invalidField = form.getElementsByClassName("is-invalid"); // get the first one and add a focus on it
      console.log(invalidField);

      const elementName = element.name;
      const helptext = document.getElementById(`${elementName}-helptext`);
      helptext.classList.add("text-danger");
      //1-add tooltips on inputs, selectors and textarea:

      // 3-add a tooltip on the first element with an error: not finished!

      element.setAttribute("data-bs-toggle", "tooltip");
      element.setAttribute("data-bs-placement", "bottom");
      element.setAttribute("data-bs-custom-class", "custom-tooltip");

      //2- add tooltip according to error type:
      if (element.validity.valueMissing == true) {
        element.setAttribute("data-bs-title", "Ce champ est obligatoire");
      } else if (elementName == "date") {
        element.setAttribute(
          "data-bs-title",
          "Doit être égale ou supérieure à aujourd’hui"
        );
      } else if (elementName == "price") {
        element.setAttribute("data-bs-title", "Doit être positif");
      }

      const tooltip = bootstrap.Tooltip.getOrCreateInstance(element);
      tooltip.show();
    });
  }
}
for (const element of elements) {
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    // implement toaster when the form subitted by success ("Événement créé avec succès.")
    toast.show();
    // delete is-invalid class on input
    element.classList.remove("is-invalid");

    //change helptexts color
    const elementName = element.name;
    const helptext = document.getElementById(`${elementName}-helptext`);
    helptext.classList.remove("text-danger");
    console.log(helptext.classList);
    //implement form reset
    form.reset();
  });
}
