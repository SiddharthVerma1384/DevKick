// let myName = "Siddharth   "
// let myEdu = "Btech      "


// console.log(myName.truelength);


let myHeroes = ["thor", "spiderman"]
let heroPewer = {
    thor : "hammer",
    spiderman : "web",

    getSpiderPower: function(){
        console.log(`Spidy power is ${this.spiderman}`)
    }
}

Object.prototype.sid = function(){
    console.log(`sid is present in all objects`)
}
heroPewer.sid()


let userName = "Siddharth     "
String.prototype.trueLength = function(){
    console.log(`${this}`)
    console.log(`The true length is : ${this.trim().length}`)
}

userName.trueLength()