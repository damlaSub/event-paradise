let data = {
  name: null,
  date: null,
  topicId: null,
  locationId: null,
  price: null,
  description: null,
};
getInputValue(data);
handleSubmit(form);

async function postData(data) {
  const options = {
    methode: "POST",
    headers: {
      "Content-Type": "application/json",
    },
  };
  if (data != null) {
    options.body = JSON.stringify(data);
  }
  return (response = await fetch("http://localhost:8080/events", options));
}

function getInputValue(data) {
  const keys = Object.keys(data);
  keys.forEach((key) => {
    const element = form.elements[key];
    element.addEventListener("change", (event) => {
      data[key] = element.value;
    });
  });
  console.log(keys);
}
