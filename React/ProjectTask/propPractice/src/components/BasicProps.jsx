import { useState } from "react"

function Button({text, color, size, onClick, disabled}){
  return (
    <button 
    onClick={onClick}
    disabled={disabled}
    className={`px-4 py-2 hover:-translate-y-1 rounded-xl font-medium transition-all duration-300 
    ${color == 'primary' ? 'bg-blue-500 hover:bg-blue-700 text-white': ''} 
    ${color == 'secondary' ? 'bg-gray-500 hover:bg-gray-700 text-white': ''} 
    ${color == 'danger' ? 'bg-red-500 hover:bg-red-700 text-white': ''} 
    ${color == 'success' ? 'bg-green-500 hover:bg-green-700 text-white': ''} 
    ${size =='small' ? 'text-sm px-4 py-1': ''}    
    ${size =='large' ? 'text-large px-8 py-3': ''}    
    ${disabled ? 'opacity-50 cursor-not-allowed': 'cursor-pointer'}    
  `}
    >{text}</button>
  )
}

function BasicProps() {
  const[clickCount, setClickCount] = useState(0)
  const[msgDisplay, setMsgDisplay] = useState('No Issues')

  return (
    <section className="p-8 bg-white rounded-xl shadow-2xl">
      <h2 className="text-3xl font-bold mb-4 text-gray-800">Basic Props</h2>
      <p className="text-lg font-medium">This Section manages the issues, count them and updates the status as being worked on</p>

      <div className="space-y-4">

        <div className="mt-4 mb-8 p-4 bg-indigo-100 rounded-2xl shaldow-2xl  font-semibold text-lg text-blue-700">
          <h3>Issue Count : {clickCount}</h3>
          <h3>Issue Status : {msgDisplay}</h3>
        </div>
        
        <div className="flex flex-wrap gap-3">
          <Button
          text="Primary button"
          color="primary"
          onClick={() => setClickCount(clickCount + 1)}
          />
          
          <Button
          text="Secondary button"
          color="secondary"
          size="small"
          disabled={true}
          onClick={() => setClickCount(clickCount + 1)}
          />
          
          <Button
          text="Danger button"
          color="danger"
          onClick={() => setMsgDisplay(() => (
            clickCount === 0 ? msgDisplay : "Issue Generated"
          ))}
          />
          
          <Button
          text="Success button"
          color="success"
          onClick={() => {
            setMsgDisplay(() => (
            clickCount !== 0 ? "Issue Resolved"  : msgDisplay
            ))
            setClickCount(0)
          }}
          />
        </div>
      </div>

    </section>
  )
}

export default BasicProps