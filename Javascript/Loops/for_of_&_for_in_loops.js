// for of

// ["", "", ""]
// [{}, {}, {}]

const arr = [1,2,3,4,5]
for (const val of arr) {
    console.log(val);
    
}

//Maps

const map = new Map()
map.set('IN', "India")
map.set('USA', "United States of America")
map.set('Fr', "France")

for (const [key,value] of map) {
    console.log(key +' :- '+ value );
        
}

//but with this same technique , objects cant be iterated , this works only for maps

const myObj = {
    js : "JavaScript",
    cpp : "C++",
    rb : "ruby"
}

for (const key in myObj) {
    console.log(key) //This retracts key only
    console.log(myObj[key]); //This retracts the value of the keys    
}

const myArr = [2,6,8,9]
for (const key in myArr) {
    console.log(key); // This returns the index values, i.e., it treats array as an object and index values as key 
    console.log(myArr[key]); // This type can be object
}


