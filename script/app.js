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
  // like for(String str: strings) at java
  const type = element.type;

  if (type != "submit") {
    element.addEventListener("invalid", (event) => {
      event.preventDefault(); //prevent the event html validdation (field control)
      console.log(`${element.name} is invalid`);

      element.classList.add("is-invalid"); // we will get invalid elements

      const elementName = element.name;
      const helptext = document.getElementById(`${elementName}-helptext`);
      helptext.classList.add("text-danger");
      //1-add tooltips on inputs, selectors and textarea:

      element.setAttribute("data-bs-toggle", "tooltip");
      element.setAttribute("data-bs-placement", "bottom");
      element.setAttribute("data-bs-custom-class", "custom-tooltip");
      //how to use setContent? with tooltip?
      //2- add tooltip according to error type:
      //then setContent to tooltip-inner for changing its message
      if (element.validity.valueMissing == true) {
        element.setAttribute("data-bs-title", `${errorMessages.missed}`);
      }
      // I get/create the tooltip
      const tooltip = bootstrap.Tooltip.getOrCreateInstance(element);
      // then I set a new content for the date and price in case they are "rangeUnderflow":
      if (elementName == "date" && element.validity.rangeUnderflow) {
        tooltip.setContent({ ".tooltip-inner": `${errorMessages.date}` });
      } else if (elementName == "price" && element.validity.rangeUnderflow) {
        tooltip.setContent({ ".tooltip-inner": `${errorMessages.price}` });
      } else {
        console.log("Salut toto");
      }

      // 3-add a tooltip on the first element with an error

      const invalidField = form.querySelector(".is-invalid"); // get the first input with an error and add focus on it

      invalidField.focus();
    });

    //add change event on inputs etc for instance changes:

    element.addEventListener("change", (event) => {
      const elementName = element.name;
      const helptext = document.getElementById(`${elementName}-helptext`);
      console.log(`${elementName} has changed`);
      if (element.checkValidity()) {
        //if my input has a valid value:
        element.classList.remove("is-invalid");
        element.classList.add("is-valid");
        helptext.classList.remove("text-danger");
        helptext.classList.add("text-success");
        // create and dispose a tooltip in case of valid input
        const tooltip = bootstrap.Tooltip.getOrCreateInstance(element);

        tooltip.dispose(element);
        console.log(`${elementName} is valid`);
      }
    });
  }
}

form.addEventListener("submit", (event) => {
  event.preventDefault();
  for (const element of elements) {
    // implement toaster when the form subitted by success ("Événement créé avec succès.")
    toast.show();
    // delete is-invalid class on input so I won't have a green border around my input

    element.classList.remove("is-valid");

    //change helptexts color after the submission:
    const elementName = element.name;
    const helptext = document.getElementById(`${elementName}-helptext`);
    console.log(helptext);
    helptext.classList.remove("text-success");

    //implement form reset
    form.reset();
  }
  console.log("submitted");
});
