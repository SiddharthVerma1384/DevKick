//singleton -> when created by constructor, not by literals
//Object.create //constructor method

//Object Literals
const sym = Symbol("key") //Now we have to use this data type as a key in a key-value pair....
const JsUser={
    name : "Siddharth",
    "Full name" : "Siddharth Verma", // this value cannot be accessed by using . operator
    /* These are the two way of thinking */
    sym : "value1",
    [sym] : "value1",
    age : 21,
    location : "Banglore",
    email : "siddharthverma1384@gmail.com",
    isLoggedIn : false
}

/* Three methods of calling but most effective are 2nd and the 3rd one */

console.log(JsUser.email);
console.log(JsUser["email"]); // by default these keys are cosidered as Strings
console.log(JsUser["Full name"]);

console.log(typeof JsUser.sym); //This is of string data type not a Symbol
console.log(typeof [sym]); //Now this is of Symbol data type
console.log(JsUser[sym]);

console.log(JsUser);
// Object.freeze(JsUser) //Due to this no changes can be made in an object 
JsUser.email = "Sidd_microsoft"
console.log(JsUser.email);
//String Interpolation 
JsUser.greeting = function(){
    console.log(`Hello JS user ${this.name}`);
}

console.log(JsUser.greeting());
