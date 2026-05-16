
function Card({children, title, color='blue'}){
  const colorClasses={
    blue: 'border-blue-500 bg-blue-500',
    green: 'border-green-500 bg-green-500',
    purpule: 'border-purpule-500 bg-purpule-500',
    red: 'border-red-500 bg-red-500'
  }

  return(
    <div className={`border-l-4 ${colorClasses[color]} p-6 rounded-lg shadow-lg hover:-translate-y-2 transition-all duration-300`}>
      {title && <h3 className="text-xl font-bold mb-3 text-gray-600">{title}</h3>}
      <div className="text-gray-700">
        {children}
      </div>
    </div>
  )
}

function Container({children, layout='vertical'}){
  const layoutClasses = {
    vertical: "flex flex-col space-y-4",
    horizontal: "flex flex-row space-x-4",
    grid: "grid grid-cols-1 md:grid-cols-2 gap-4"
  }

  return(
    <div className={layoutClasses[layout]}>
      {children}
    </div>
  )
}



function ChildrenProps() {
  return (
    <section className="p-8 bg-white rounded-xl shadow-lg">
      <h2 className="text-3xl font-bold mb-4 text-gray-800">ChildrenProps</h2>
      <p className="text-lg font-medium">Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias, ipsam. Adipisci eum sed maxime est.</p>

      <div className="space-y-6">
        <div>
          <h3 className="text-3xl font-bold mb-4 text-gray-800">Card Component with children</h3>
          <Container layout="grid">
            <Card title="User Profile" color="blue">
              <p mb-2>
                <strong>Name:</strong> Siddharth Verma
              </p>
              <p mb-2>
                <strong>Email:</strong> siddharthverma1384@gmail.com
              </p>
              <p mb-2>
                <strong>Role:</strong> Developer
              </p>
            </Card>

            <Card title="Statistical Profile" color="green">
              <p mb-2>
                <strong>Name:</strong> Siddharth Verma
              </p>
              <p mb-2>
                <strong>Email:</strong> siddharthverma1384@gmail.com
              </p>
              <p mb-2>
                <strong>Role:</strong> Developer
              </p>
            </Card>
            
          </Container>
        </div>
      </div>

    </section>
  )
}

export default ChildrenProps

