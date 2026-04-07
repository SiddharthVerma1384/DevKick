class User{
    constructor(username){
        this.username = username
    }

    logMe(){
        console.log(`Username : ${this.username}`);
    }

    static createId(){
        return '123'
    }
}



const Sid = new User("Sid")
// console.log(Sid.createId())

class Teacher extends User{
    constructor(username , email){
        super(username)
        this.email = email
    }
}

const iphone = new Teacher("iphone", "iphn@gmal.com")
// iphone.logMe()
console.log(iphone.createId())