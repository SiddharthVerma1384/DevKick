import { useState } from 'react'

import './App.css'

function App() {
  let [counter, setCounter] = useState(3)

  //let counter = 2

  const addValue = () => {
    // counter = counter + 1    
      setCounter( (counter < 20) ?  counter + 1 : counter) 
       
  }

  const removeValue = () => {
    if (counter > 0){
      setCounter(counter - 1)
    }    
  }

  return (
   <>
    <h1>Chai aur react</h1>
    <h2>counter value : {counter}</h2>

    <button onClick={addValue}>Add value {counter}</button>
    <br />
    <button onClick={removeValue}>Remove value {counter}</button>
    <p>footer: {counter} </p>
   </>
  )
}

export default App
