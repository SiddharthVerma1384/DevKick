import {useRef, forwardRef} from "react"

//Input component which accepts a ref prop
const CustomInput = forwardRef(({label, placeholder, className}, ref) => (
  <div className="mb-4">
    <label className="block text-gray-700 font-medium mb-2">{label}</label>
    <input
    ref={ref}
    type="text"
    className={` w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 ${className}`}
    placeholder={placeholder}
    />
  </div>
))

CustomInput.displayName = 'CustomInput'

function RefProps() {

  const inputRef = useRef(null)
  const secondInputRef = useRef(null)

  const focusInput = () => {
    inputRef.current?.focus()
  }
  const getInputValue = () => {
    if(inputRef.current){
      alert(`Input Value: ${inputRef.current.value}`)
    }
  }
  const clearInput = () => {
    if(inputRef.current){
      inputRef.current.value = ''
      inputRef.current.focus()
    }
  }
  const focusSecondInput = () => {
    secondInputRef.current?.focus()
  }

  return (
    <section className="p-8 bg-white rounded-xl shadow-lg">
      <h2>Ref Props</h2>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus commodi consequatur ea nam et, molestiae dolores maxime accusantium magni ut.</p>

      <div>
        <div>
          <h3>Try it out</h3>
          <CustomInput 
          ref={inputRef}
          label = "First Input with ref"
          placeholder = "Type something"
          />
          <CustomInput 
          ref={secondInputRef}
          label = "Second Input with ref"
          placeholder = "Type something else...."
          />

          <div className="flex flex-wrap gap-3 mt-4">
            <button
            className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-700 transition-all hover:-translate-y-1"
            onClick={focusInput}>Focus first Input
            </button>

            <button
            className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-700 transition-all hover:-translate-y-1"
            onClick={focusSecondInput}>Focus Second Input
            </button>

            <button
            className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-700 transition-all hover:-translate-y-1"
            onClick={getInputValue}>Get First Input Value
            </button>

            <button
            className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-700 transition-all hover:-translate-y-1"
            onClick={clearInput}>Clear First Input
            </button>
          </div>

        </div>
      </div>
    </section>
  )
}

export default RefProps