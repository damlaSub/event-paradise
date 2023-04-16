const form = document.querySelector("form");
const main = document.querySelector("main");

const elements = form.elements;

//for tooltip:
const options = {
  title: "Ce champ est obligatoire",
};

// if I have invalid inputs:
// there would be input alerts (red):
// and a tooltip as error messages:
for (const element of elements) {
  // like for(String str: strings) at java
  const type = element.type;

  if (type != "submit") {
    element.addEventListener("invalid", (event) => {
      event.preventDefault(); //prevent the event html validdation (field control)

      element.classList.add("is-invalid"); // we will get invalid elements

      const elementName = element.name;
      const helptext = document.getElementById(`${elementName}-helptext`);
      helptext.classList.add("text-danger");

      //1-add tooltip attributes on inputs, selectors and textarea:
      element.setAttribute("data-bs-toggle", "tooltip");
      element.setAttribute("data-bs-placement", "bottom");
      element.setAttribute("data-bs-custom-class", "custom-tooltip");

      //2- add tooltip according to error type:
      let message = null;
      // then set a new content for the date and price in case they are "rangeUnderflow":
      if (element.validity.valueMissing == true) {
        message = options.title;
      } else if (elementName == "date" && element.validity.rangeUnderflow) {
        message = errorMessages.date;
      } else if (elementName == "price" && element.validity.rangeUnderflow) {
        message = errorMessages.price;
      }
      // get/create the tooltip
      const tooltip = bootstrap.Tooltip.getOrCreateInstance(element, options);

      //then setContent to tooltip-inner for changing its message
      tooltip.setContent({ ".tooltip-inner": message });
      // 3-add a tooltip on the first element with an error

      const firstInvalidField = form.querySelector(".is-invalid"); // get the first input with an error and add focus on it
      if (firstInvalidField == element) {
        firstInvalidField.focus();
      }
    });
    //add change event on inputs etc for instance changes:

    element.addEventListener("change", (event) => {
      if (element.checkValidity()) {
        const elementName = element.name;
        const helptext = document.getElementById(`${elementName}-helptext`);
        //if my input has a valid value:
        element.classList.replace("is-invalid", "is-valid");
        helptext.classList.replace("text-danger", "text-success");

        // create and dispose a tooltip in case of valid input
        const tooltip = bootstrap.Tooltip.getOrCreateInstance(element);
        tooltip.dispose();
      }
    });
  }
}

function handleSubmit(form) {
  form.addEventListener("submit", (event) => {
    event.preventDefault();

    //implement form reset
    form.reset();

    // implement toaster when the form subitted by success ("Événement créé avec succès.")
    toast.show();

    for (const element of elements) {
      //for not having a remove method on submit button, add an if
      type = element.type;
      if (type != "submit") {
        // delete is-valid class on input so there won't be a green border around the input
        element.classList.remove("is-valid");

        //change helptexts color after the submission:
        const elementName = element.name;
        const helptext = document.getElementById(`${elementName}-helptext`);

        helptext.classList.remove("text-success");
      }
    }
  });
}
