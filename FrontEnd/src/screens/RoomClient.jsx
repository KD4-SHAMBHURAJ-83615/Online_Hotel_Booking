import roomimage from '../Images/room.jpg'


function RoomClient() {
    return (
      
      <div className="background-container">
        
        <div className='container '>
           
        <div class="card mb-3"style={{width:200}} >
                <img src={roomimage} class="card-img-top" alt="..." style={{width:200}}/>
                
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                </div>
                </div>
            
        </div>



      

      
       
      </div>
     
    )
  }
  
  export default RoomClient
  