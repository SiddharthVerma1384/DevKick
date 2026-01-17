// Nullish Colescing Operator (??) : null and undefined

/* if the value from database is recieved => assing that value or else use null */
let val1
// val1 = 5 ?? 10
// val1 = null ?? 10
// val1 = undefined ?? 15

/* In the below two cases --------------Special case:-----------
if the left side value is null or undefined -> automatically right side value is returned
thus in first case -> left-value = null -> Output => undefined and 
in second case -> left-value = undefined -> Output => null
*/

val2 = null ?? undefined
val1 = undefined ?? null

console.log(val1);
console.log(val2);


//++++++++++Ternary Operator ++++++++++++++

// condition ? true : false
