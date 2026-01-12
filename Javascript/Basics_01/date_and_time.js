let myDate = new Date()

console.log(myDate)
console.log(myDate.toJSON())
/*

The above two are same but the difference is 
simple log -> logs the data as human readable used for debugging
.toJSON() -> used for JSON readability .... API/Storage

*/
console.log(myDate.toString())
console.log(myDate.toDateString())
/*
Above both prints in String
*/
console.log(myDate.toLocaleDateString()) // only for date as we write usually
console.log(myDate.toLocaleString()) //for both date and time ....as we write in our copy

let myCreatedData = new Date(2013, 0, 22)//Month Starts from zero in js...
console.log(myCreatedData.toLocaleDateString());

//++++++++++timestamp+++++++++++

let timestamp = Date.now()
console.log(timestamp.toLocaleString("en-IN"));

console.log( myDate.toLocaleString('default',{
    weekday : "long" // This prints day in long format - 
                    // eg- Monday
                    // "short" -> Mon
}));                // "narrow" -> M



