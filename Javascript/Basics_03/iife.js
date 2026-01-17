// iife -> Immediately Invoked Function Expression (IIFE) -> To prevent global scope pollution 
//Syntax -> ()->used for function declaration () -> used for function execution 

(function chai(){
    console.log(`DB CONNECTED`);
    
})();

/* As they are immediately invoked so JS dont know where to stop them
    thus both  IIFE not get executed bcz first one is still executing
    thus ';' is used to stop the execution of the function 
*/

( () => {
    console.log(`Chai connected to the server...`);    
} )()
