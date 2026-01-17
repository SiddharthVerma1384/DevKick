// {} -> Scope
/* Global Scope */
var c = 300

/* Block Scope  */
if(true){
    let a = 10
    const b = 20
    var c = 30
}

// console.log(a);
// console.log(b);
// console.log(c);

function one(){
    const userName = "Siddharth"
    function two(){
        const platform = " Yt"
        console.log(userName + platform);        
    }
    // console.log(platform); // because it was defined in inner scope

    two()
}

one()

// ++++++++++ Interesting concept ++++++++++

console.log(addone(5));// can be executed 
  
function addone(num){
    return num + 1
}

/* This concept will be used in hoisting , execution concept.... */

console.log(addTwo(5)) // cannot be executed as function is declared inside a variable 
const addTwo /* Expression */ = function(num){
    return num + 2
}
