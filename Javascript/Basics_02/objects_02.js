// const tinderUser = new Object()
const tinderUser = {}
// console.log(tinderUser);

tinderUser.id = "24bcb0017"
tinderUser.name = "Atharva Sharma"
tinderUser.isLoggedIn = true

//console.table(tinderUser);

const regularUser = {
    email : "someone@user.com",
    price: {
        bill_amount : "2000",
        status : {
            amount : "paid"
        }
    }
}
const obj = Object.assign({},regularUser,regularUser.price,regularUser.status) // price and status objects are not defined yet....
// Use spread object .....it is much easy than this...(...obj1,...obj2)
console.log(obj);


/* How values from database is managed */

const users = [ // array of objects
    {
        id : 1,
        email : "xyz.@user"
    }
]


console.log(Object.keys(tinderUser));
console.log(Object.entries(tinderUser));
console.log(tinderUser.hasOwnProperty('isLoggedIn'));

/* Destructuring */

const course = {
    name : "js",
    price : "999",
    platform : "YouTube"
}
const {platform : pt} = course // destructuring
//console.log(platform); // now this will throw an error as platform is now changed to -> pt

console.log(pt);


/* JSON */


/* APIs in form of Object  */
// {
//     "name" : "Siddharth Verma",
//     "branch" : "Bioinformatics",
//     "college" : "VIT"
// }

/* APIs in form of arrays */
// [
//     {},
//     {},
//     {}
// ]

