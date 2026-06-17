const fs = require('fs')
const os = require('os')

const EventEmitter = require('events')

class Logger extends EventEmitter{
    log(message) {
        this.emit('message', {message})
    }
}

const logger = new Logger()
const logFile = './eventlog.txt'

const logToFile = (event) => {
    const LogMessage = `${new Date().toISOString()} - ${event.message} \n`
    fs.appendFileSync(logFile, LogMessage)
}


logger.on('message', logToFile)

setInterval(() => {
    const memoryUsage = (os.freemem() / os.totalmem() * 100)
    logger.log(`Current memory usage: ${memoryUsage.toFixed(2)}`)
}, 3000)

logger.log('Application Started')
logger.log('Application event occured')