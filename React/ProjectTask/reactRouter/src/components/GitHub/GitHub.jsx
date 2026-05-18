import { useEffect, useState } from "react"
// import { useLoaderData } from "react-router-dom"

function GitHub() {
    // const data = useLoaderData()
    const [data, setData] = useState([])
    useEffect(() => {
        fetch('https://api.github.com/users/SiddharthVerma1384')
        .then(response => response.json())
        .then(data => {
            console.log(data)
            setData(data)
        })
    }, [])
  return (
    <div className="text-white">GitHub followers: {data.followers}
    <img src={data.avatar_url} alt="" />
    </div>

  )
}

// export const githubInfoLoader = async () => {
//     const response = await fetch('https://api.github.com/users/SiddharthVerma1384')
//     return response.json()
// }

export default GitHub

