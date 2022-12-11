//Date

const inputDate = document.getElementById("input-date"); //.value;

const currentDate = new Date();

let day = currentDate.getDate();
if (day < 10) {
  day = `0${day}`;
}

let month = currentDate.getMonth() + 1;
if (month < 10) {
  month = `0${month}`;
}

let year = currentDate.getFullYear();

let dateFormat = year + "-" + month + "-" + day;

const minDateAttribute = inputDate.setAttribute("min", dateFormat);
