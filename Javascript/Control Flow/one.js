const userLoggedIn = true
const debitCard = true
const LoggedInfromGoogle = false
const LoggedInfromEmail = true

if (userLoggedIn && debitCard){
    console.log("Allow to buy course ....");    
}

if (LoggedInfromGoogle || LoggedInfromEmail){
    console.log("User logged in...");
}


/* Falsey Value
false, 0, -0, BigINt 0n, "", null, undefined, NaN
*/

/* Truthy values
"0", 'false'," ",[],{}, function(){}
*/

//To check empty onjects

const EmptyObj = {}

if(Object.keys(EmptyObj).length === 0){
    console.log("Object is empty ....");    
}

