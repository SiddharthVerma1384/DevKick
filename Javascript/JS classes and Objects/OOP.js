const user = {
    username : "Siddharth",
    loginCount : 6,
    signedIn: true
}

// console.log(user.username);

function User(username, loginCount, isLoggedIn){
    this.username = username;
    this.loginCount = loginCount
    this.isLoggedIn = isLoggedIn

    return this
}

const userOne = new User("Sid" , 22, true)
const userTwo = new User("Siddharth", 15, false)
console.log(userOne.constructor);
// console.log(userTwo);



