let score = 33
// const {score} = req.body

console.log(typeof(score))
let valueInnumber = Number(score)
console.log(typeof valueInnumber);

// "33" => 33
// "33abs" => can be converted in number ,i.e, no error will be thrown ......
            //but when printed it will be "NaN" -> Not a number....
// true => 1
// false => 0
/* --------------------------------------------------------*/
let isLoggedIn = 1 

// 1 / non-empty string => true
// 0 / empty string => false

let booleanIsLoggedIn = Boolean(isLoggedIn)

console.log(typeof booleanIsLoggedIn);
console.log(booleanIsLoggedIn);

/*---------------------------------------------------*/
let num = 123
let convertedString = String(num)
console.log(typeof num);
console.log(typeof convertedString);

