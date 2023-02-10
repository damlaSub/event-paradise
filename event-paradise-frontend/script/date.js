//Convert date format and give an html attribute to the date input in order to determine the min input value

const inputDate = document.getElementById("input-date");
const currentDate = new Date();
const dateFormat = currentDate.toISOString().substr(0, 10);
const minDateAttribute = inputDate.setAttribute("min", dateFormat);
