// storing a collection of multiple items under a single variable name

const nums = [1,2,3,4]
console.log(nums[1]);

//+++++++++++++ Array Methods ++++++++++++++++

nums.push(6) // insert the element at end
console.log(nums);
nums.pop() // removes the last element
console.log(nums);
nums.unshift(9) // insert the element at start
console.log(nums);
nums.shift() //removes the first element
console.log(nums);
console.log(nums.includes(9)); //returns boolean value


const newArray = nums.join()
console.log(newArray); // But its type will be string

// Slice -> Take the part of array till the endpoint ...excluding the ending index
// Splice -> it manipulates the orignal array ,i.e, it takes out the ranged value from the original array


//Spread Operator :--
const marvel = ["Spiderman" , "Ironman", "Hulk"]
const dc = ["Superman", "Batman", "flash"]

const all_heros = [...marvel,...dc] //now these are not array any more ....they are spreaded into single elements
console.log(all_heros);

//arr.flat(depth-?)

/* This command is used to seperate all the elements with all the subarrays 
concatenated within it...
Depth -> till how many arrays , elements have to be seperated....
(Infinity) -> Opens every array within and seperate each elements...

*/

console.log(Array.isArray("Sidd")); // check if it is array or not
console.log(Array.from("Sidd")); // convert any data type into array
console.log(Array.from({name : "Sidd"})); //an object is created now , we have to specify that which part we want to convert into array, i.e., key part or value part

