import roomimage from '../Images/room.jpg'


function Room() {
    return (
      
      <div className="background-container">
        
        
       <div className="row">
          <div className='col-1'></div>

          {/* for room image and details start */}
                <div className='col slide-up' style={{marginTop:100}}>
               
                <div className="card mb-3 "style={{width:500}}>
                    <img src={roomimage} class="card-img-top" alt="..."/>
                    <div className="card-body">
                        <h5 className="card-title">room type</h5>
                        <p className="card-text">room number</p>
                        <p className="card-text">
                            <small className="text-body-secondary">is tv <br />is ac <br /> <br  />rent</small>
                            
                        </p>
                        <button className="btn btn-warning ms-5 me-5">edit</button>
                        <button className="btn btn-danger ms-5">delete</button>
                    </div>
                </div>

                </div> 
            {/* for room image and details  end*/}
          <div className='col-1'>

           
           
           </div>
       
       </div>
  
      </div>
     
    )
  }
  
  export default Room
  