import Dashboard from '../Dashboard/Dashboard'


import imagehotel from '../Images/hotel1.jpg'
import {  useNavigate } from 'react-router-dom'

function Properties() {
  const navigate = useNavigate()

const onAddHotel =  () => {
  navigate('/AddHotel');
}

  return (
    
    <div className="background-container">
        <Dashboard />
        <div className="row mt-4">
          <div className='col-10'></div>
          <div className='col-2'> 
        <button onClick={onAddHotel} className='btn btn-success mt-2'>
                add hotel
              </button> </div>
        </div>
     <div className="row">
        <div className='col-1'></div>
              <div className='col ' >
                
              <div className="card text-bg-dark slide-up " style={{width:400}}>
                <img src={imagehotel} className="card-img" alt="hotel image"   />
                <div className="card-img-overlay">
                  <h5 className="card-title">Hotel Name</h5>
                  <p className="card-text">
                   Hotel address 
                             
                  </p><br /><br /> <br />
                  <p className="card-text mt-5" >
                    <button className="btn btn-success ms-5">view </button>
                    <button className="btn btn-warning ms-5">edit</button>
                    <button className="btn btn-danger ms-5">delete</button>
                  </p>
                </div>
              </div> <br />
 
              </div> 
       
     
     </div>

    </div>
   
  )
}

export default Properties
