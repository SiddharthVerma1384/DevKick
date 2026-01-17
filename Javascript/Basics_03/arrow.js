// ES 6 javascript feature :----

const User = {
    username : "Nitesh",
    price : " ₹ 265",

    welcomeMessage : function(){
        console.log(`${this.username} , welcome to website`)
    }
    // this -> it refers to the current context
}
User.welcomeMessage()
User.username = "Sid"

User.welcomeMessage()


// function chai(){
//     const username = "Div"
//     console.log(this.username);
    
// }
// chai()

// const chai = function(){
//     const username = "Div"
//     console.log(this.username);
    
// }
// chai()

const chai = () => /* Arrow function */ {
    let username = "Div"
    console.log(this.username);
    
}
chai()

