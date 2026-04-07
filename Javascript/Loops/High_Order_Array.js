 //We have to pass function which works for each element in an array

const lang = ["js", "Java", "Cpp", "Python", "GoLang"]
// lang.forEach( function(val){
//     console.log(val);
    
// } )

// lang.forEach((item) => {
//     console.log(item);    
// })

// ++++++++++++++++ Filter Method ++++++++++++++
// const mynums = [1,2,3,4,5,6,7,8,9,10]

// const NewNums = mynums.filter((nums) => {
//     return nums > 4
// })

// console.log(NewNums);



const mynums = [1,2,3,4,5,6,7,8,9,10]
const newNums = mynums.map((num) => num * 10).map((num) => num + 1)  //Chaining

console.log(newNums);


//+++++++++++ reduce function +++++++++++

const nums = [1,2,3]
const total = nums.reduce((acc,curr) => {
    console.log(`acc : ${acc} and current value : ${curr}`);    
    return acc + curr
},4) // we have to provide some initial value , here it starts from 4

console.log(total);
