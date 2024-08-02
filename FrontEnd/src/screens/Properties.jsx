import Dashboard from '../Dashboard/Dashboard'

import imagehotel from '../Images/hotel1.jpg'

function Home() {
  return (
    
    <div className="background-container">
        <Dashboard />
     <div className="row">
        <div className='col-1'></div>
              <div className='col ' style={{marginTop:100}}>
                
              <div className="card text-bg-dark slide-up " style={{width:400}}>
                <img src={imagehotel} className="card-img" alt="hotel image"   />
                <div className="card-img-overlay">
                  <h5 className="card-title">Hotel Name</h5>
                  <p className="card-text">
                   Hotel address 
                   <br />
                   <h4>price</h4>
                  </p><br /><br />
                  <p className="card-text mt-5" >
                    <button className="btn btn-success me-5 ms-5">view details</button>
                      
                    <button className="btn btn-danger ms-5">delete</button>
                  </p>
                </div>
              </div> <br />
 
              </div> 
        <div className='col-1'>  </div>
     
     </div>

    </div>
   
  )
}

export default Home
