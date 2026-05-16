import './App.css'
import BasicProps from "./components/BasicProps.jsx"
import ChildrenProps from "./components/ChildrenProps.jsx"
import ComplexProps from "./components/ComplexProps.jsx"
import RefProps from "./components/RefProps.jsx"
import ThemeToggler, {ThemeProvider ,useTheme} from "./components/ThemeToggler.jsx"

function Navigation (){
  const isDark = true

  const sections = [
    {id: 'basic', label: 'basic Props', icon: '📦'},
    {id: 'ref', label: 'ref Props', icon: '🔗'},
    {id: 'children', label: 'children Props', icon: '👶'},
    {id: 'complex', label: 'complex Props', icon: '🧩'},
    {id: 'theme', label: 'theme Props', icon: '🎨'},
  ]

  return (
    <nav className={`sticky top-0 z-50 shadow-md flex justify-center`}>
      <div>
        <div>
          {sections.map((section) => (
            <button 
            className= {`px-4 py-2 rounded-lg font-medium mr-2 bg-blue-600 mt-2 text-white hover:bg-blue-800 hover:-translate-y-1 transition-all duration-300`}
            key={section.id}>
              <span className={`mr-2`}>{section.icon}</span>
              {section.label}
            </button>
          ))}
        </div>
      </div>
    </nav>
  )
}



function AppContent(){
  // const isDark = true
  const{isDark} = useTheme()
  return (

    <div className={`min-h-screen bg-gray-800`}>
      <Navigation />
      <div className={`container mx-auto px-4 py-8`}>
        <header className={`text-centre mb-12`}>
          <h1 className="text-5xl font-bold mb-4 text-white">React Props Explained </h1>
          <p className={`text-xl text-white`}>A comprehensive guide to understanding props in React</p>
        </header>
        <div className="space-y-8">
          <div id="basic" className='scroll-mt-200'>
            <BasicProps/>
          </div>

          <div id="child" className='scroll-mt-200'>
            <ChildrenProps/>
          </div>
          
          <div id="complex" className='scroll-mt-200'>
            <ComplexProps/>
          </div>

          <div id="ref" className='scroll-mt-200'>
            <RefProps/>
          </div>

          <div id="toggle" className='scroll-mt-200'>
            <ThemeToggler/>
          </div>

        </div>
      </div>
    </div>
  )
}




function App() {

  return (
    <ThemeProvider>
      <AppContent />
    </ThemeProvider>
  )
}

export default App
