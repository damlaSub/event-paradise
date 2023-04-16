const locationsUrl = "http://localhost:8080/locations";
const topicsUrl = "http://localhost:8080/topics";

const locationSelectId = "#input-location";
const topicSelectId = "#input-topic";

const locationHtml = `<option value="">Choisir un lieu dans la liste</option>`;
const topicHtml = `<option value="">Choisir un thème dans la liste</option>`;

getData(locationsUrl, locationSelectId, locationHtml);
getData(topicsUrl, topicSelectId, topicHtml);

async function getData(url, idSelector, content) {
  const options = {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  };

  const response = await fetch(url, options);
  const elements = await response.json();
  const target = document.querySelector(idSelector);

  elements.forEach((element) => {
    content += optionContent(element);
  });
  target.innerHTML = content;

  //   console.log("response", response);
  //   console.log("elements", elements);
  //   console.log("target", target);
}

function optionContent(element) {
  return `
    <option value="${element.id}">${element.name}</option>
    `;
}
