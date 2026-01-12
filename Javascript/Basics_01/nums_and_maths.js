const score = 200
console.log(score);

const balance = new Number(100) //This creates an object
console.log(balance);
/* After creating as an object we can change this to any data type */

//.toLocaleString -> display large nos. using commas---done on the basis of US rules
//.toLocaleString(en-IN) -> display large nos. using commas---done on the basis of Indian rules
//.tofixed() -> use to fix the values after decimal
//.toPrecision() -> to precise the significant figures

// +++++++++++++Maths+++++++++++++++

const min = 10
const max = 20

Math.random() * (max - min + 1) + min // generally random values are being decided between 0 and 1
//But using this formula decides the value -> between min and max and +1 is use to avoid zero...
//to get output above my min value --> + min

