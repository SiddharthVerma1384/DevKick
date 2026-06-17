const os = require('os')

//info about current user 
const user = os.userInfo()
console.log(user)

// system uptime in seconds 
console.log(`${os.uptime()} seconds`)


console.log(os.platform())
console.log(os.arch())
console.log(os.totalmem())
console.log(os.freemem())