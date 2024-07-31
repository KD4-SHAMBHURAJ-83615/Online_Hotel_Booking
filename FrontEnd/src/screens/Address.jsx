import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'

function Address() {
  const [addressLine, setAdressLine] = useState('')
  const [city, setCity] = useState('')
  const [pincode, setPincode] = useState('')
  const [selectedState, setState] = useState('');
  const [country, setCountry] = useState('')
  
  

  // get the navigation hook
  const navigate = useNavigate()

  const onAddAddress = () => {
    if (addressLine.length == 0) {
      toast.error('please enter Address')
    } else if (pincode.length == 0) {
      toast.error('please enter pincode')
    } else if (city.length == 0) {
      toast.error('please enter city')
    } else if (selectedState.length == 0) {
      toast.error('please select state ')
    } else if (country.length == 0) {
      toast.error('please select country')
    
      
    } else {
      // call register API, check the status
      // if success go to Login screen
      toast.success('Successfully Address Added')
      //navigate('/login')
    }
  }

  return (
    <div className='background-container '>
      
      
      <div className='row'>
        <div className='col'></div>
        <div className='col'>
        <h1 className='page-header slide-up'>ADDRESS </h1>
          <div className='form slide-up box'>
            <div className='mb-3'>
            <br/>
              <h6 htmlFor=''>Address Line</h6>
              <textarea
                onChange={(e) => setAdressLine(e.target.value)}
                type='text'
                placeholder="Enter Line"
                className='form-control'
              />
              <br/>
              <div className='mb-3'>
              <h6 htmlFor='' >Pincode</h6>
              <input
                onChange={(e) => setPincode(e.target.value)}
                type='text'
                 placeholder="Enter 6-digit pincode"
                  maxLength="6"
                className='form-control'
              />
            </div>
            </div>
            <div className='mb-3'>
              <h6 htmlFor=''>City</h6>
              <input
              placeholder="Enter Your City"
                onChange={(e) => setCity(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            
            <div className='mb-3'>
              <h6 htmlFor=''>State</h6>
              <select className="form-control"  onChange={(e) => setState(e.target.value)} >
                        <option>Select State</option>
                        <option value="Maharashtra">Maharashtra</option>
                        <option value="Karnataka">Karnataka</option>
                        <option value="Goa">Goa</option>
                        <option value="Dehli">Delhi</option>
                        <option value="Gujrat">Gujrat</option>
                        <option value="Asam">Asam</option>
                        <option value="Rajasthan">Rajasthan</option>
                    </select>
             
            </div>
            <div className='mb-3'>
              <h6 htmlFor=''>Country</h6>
              <select className="form-control" onChange={(e) => setCountry(e.target.value)}>
                        <option>Select State</option>
                        <option value="India">India</option>
                    </select>
            </div>
           
           
            <div className='mb-3'>
              {/* <div>
                Already have an account ? <Link to='/login'>Login here</Link>
              </div> */}
              <button  onClick={onAddAddress} className='btn btn-success mt-2 '>
                Add Details
              </button>
            </div>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
  )
}

export default Address
