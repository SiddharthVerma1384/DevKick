//Basic comparisons is same for same data types
//No problem will occur here....But

//Comparison between different data types

console.log("2" > 1);
console.log("02" > 1);

console.log(null > 0);
console.log(null == 0);
console.log(null >= 0);

//js has different usage of comparison and equality check

//Strict check === -> check strictly ....even the data type too..


/*Symbol is used to give uniquness...*/
let id = Symbol('123')
let AnotherId = Symbol('123')

console.log(id === AnotherId); // -> False 
