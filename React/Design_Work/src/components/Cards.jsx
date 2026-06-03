function Cards({title = "Default",imagesrc}){
    return <div className="max-w-sm bg-white border border-gray-200 rounded-xl mt-8" shadow overflow-hidden transition-shadow>
        <img className='w-full h-58 object-cover rounded'
        src={imagesrc} 
        alt="sample image" />
        <div className='text-lg font-bold text-red-500'>
          <h2>{title}</h2>
          <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Totam sequi, quisquam architecto facilis earum cupiditate. Laborum cum voluptatibus necessitatibus deserunt?</p>

          <button>Buy now</button>
        </div>
        </div>
}

export default Cards;