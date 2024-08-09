import roomimage from '../Images/room.jpg'
import {  useNavigate } from 'react-router-dom'
import { useState, useEffect } from 'react'
import { getRooms } from '../services/room'


function Room() {
  const [rooms, setRooms] = useState([])
 
  const loadRooms= async () => {
    debugger
    const result = await getRooms()
    if (result != undefined) {
      setRooms(result)
      console.log(result['data'])

      
    }
  }

  useEffect(() => {
    loadRooms()
  }, [])


    const navigate = useNavigate()
    const onAddRoom =  () => {
        navigate(`/addroom/${sessionStorage.getItem('hotelId')}`);
      } 
      const onHome =  () => {
        navigate('/properties');
      } 

    return (
      
      <div className="background-container">
        <div className="row transparent-bg" >
            <div className='col-12'style={{textAlign:'center',marginTop:50,color:'white'}}><h1>ROOMS</h1></div>
        </div>

        <div className="row mt-4">
        <div className='col-2'>
           <button onClick={onHome} className='btn btn-success mt-2 ms-5'>
                Home
              </button> 
        </div>
          <div className='col-8'></div>
          <div className='col-2'> 
              <button onClick={onAddRoom} className='btn btn-success mt-2'>
                add Room
              </button> 
            </div>
        </div>
        
       <div className="row">
           
          {/* for room image and details start */}
                <div className='col slide-up ms-3' style={{marginTop:100}}>
               
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
          
       
       </div>
  
      </div>
     
    )
  }
  
  export default Room
  