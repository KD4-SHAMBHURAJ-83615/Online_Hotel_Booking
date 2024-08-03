import imagehotel from '../Images/hotel1.jpg'


function HomeC() {
    return (
       <div className="background-container">
       
               {/*search bar for hotel search  */}
            <div className="input-group ">
                <div class="container text-center box1">
                <div class="row justify-content-md-center">
                    <div class="col col-lg-2">
                    <h6 htmlFor=''>City</h6>
                        <input type="text" aria-label="City" placeholder="Enter City" className="form-control opacity-75 "/>
                    </div>
                    <div class="col-md-2">
                    <h6 htmlFor=''>cheak-in-date</h6>
                        <input type="date" aria-label="cheak-in-date"  className="form-control  opacity-75"/>
                    
                    </div>
                    <div class="col col-lg-2">
                    <h6 htmlFor=''>cheak-in-date</h6>
                        <input type="date" aria-label="cheak-in-date"  className="form-control  opacity-75"/>
                    </div>
                    <div class="col col-lg-2">
                      <h6 htmlFor=''>Room Type</h6>
                       <select className="form-control opacity-75" >
                        <option>Select room type </option>
                        <option value="Single">Single-1 adult</option>
                        <option value="Double">Double-2 adult</option>
                        <option value="Suite">Suit-2 adult -2 childs</option>
                       </select>
                    </div>
                    <div class="col col-lg-2">
                        <br />
                         <button class="btn btn-secondary" type="button" id="button-addon2">Search</button>
                    </div>
                </div>
                </div>

            </div>

            {/* display hotels */}
            <div class="container text-center mt-5">
                    <div class="row">
                         {/* card for hotel diplay */}
                        <div class="col-6">
                            <div class="card mb-4 ms-5 slide-up" style={{maxWidth:540}} >
                                <div class="row g-0">
                                    <div class="col-md-4">
                                    <img src={imagehotel} class="img-fluid rounded-start" alt="..."/>
                                    </div>
                                    <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">hotel name</h5>
                                        <p class="card-text">address</p>
                                        <p class="card-text"><small class="text-body-secondary">rating</small></p>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        {/* iterate at here end point */}
                    </div>
            </div>


       </div> 

    )
}

export default HomeC