const RoomNo = 1522
let UserEmail = "siddharth_test@gmail.com"
var RoomPin = "12345"
UserCity = "Patna" // Allowed But not preffered
let UserState; // if the value of variable is not declared it is considered as undefined;....

// RoomNo = 1524  /*Can't change its value */
UserEmail = "nitesh_test@gmail.com"
RoomPin = "1357"
UserCity = "East Delhi"
// console.log(RoomNo);

/*
Prefer not to use var 
because issue in block scope and functional scope
*/

console.table([RoomNo, UserEmail, RoomPin, UserCity]);