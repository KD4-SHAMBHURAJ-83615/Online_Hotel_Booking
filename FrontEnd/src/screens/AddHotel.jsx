import { Link, useNavigate } from 'react-router-dom'
// import Navbar from '../components/navbar'
import { useState } from 'react'
import Amenity from '../components/amenity'
import { toast } from 'react-toastify'
import axios from 'axios'
// import { addProperty } from '../services/property'

function AddProperty() {
  const [hotelName, sethotelName] = useState('')

  const [contactDetails, setcontactDetails] = useState('')


  const [swimmingPool, setSwimmingPool] = useState(false)
  const [restaurant, setRestaurant] = useState(false)
  const [gym, setAC] = useState(false)
  const [userId] = useState(`${sessionStorage.getItem('userId')}`)
  const [wifi, setWifi] = useState(false)
  const [powerbackup, setPowerbackup] = useState(false)
  const [parking, setParking] = useState(false)


  const [image, setImage] = useState(undefined)

  const navigate = useNavigate()

  const onSave = async () => {
    if (hotelName.length == 0) {
      toast.warn('Please enter Hotel Name')
    }  else if (contactDetails.length == 0) {
      toast.warn('Please enter contact number')
    // } else if (!image) {
    //   toast.warn('Please select a property photo')
    } else {
       debugger
      const result = await axios.post('http://localhost:8080/hotels', {
       
        hotelName,
        contactDetails,
       
        swimmingPool,
        restaurant,
        gym,
        parking,
        wifi,
        powerbackup,
        userId,
        image
     } )
    
     
      if (result['status'] == 201) {
        toast.success('Successfully added a property')
        
        sessionStorage.setItem('hotelId',result.data.id)
        navigate(`/address/${result.data.id}`)
      } else {
        toast.error(result['error'])
      }
    }
  }

  return (
    <div className='background-container '>
      {/* <Navbar /> */}
      <div className='row '></div>
      <h1 className='page-header slide-up'>Add Hotel</h1>
      <div className='form box slide-up'>
        <div className='row '>
          <div className='col'>
            <div className='mb-3'>
              <label htmlFor=''>hotelName</label>
              <input
                onChange={(e) => sethotelName(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
          </div>


          {/* <div className='col'>
            <div className='mb-3'>
              <label htmlFor=''>userid</label>
              <input
                onChange={(e) => setUserId(e.target.value)}
                type='text'
                className='form-control'
                value={2}
                readOnly
              />
            </div>
          </div> */}
         
          <div className='col'>
            <div className='mb-3'>
              <label htmlFor=''>Contact Number</label>
              <input
                onChange={(e) => setcontactDetails(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
          </div>
        </div>

        <h3>Amenities </h3>
        <div className='row mb-3'>
          <div className='row'>
            <div className='col'>
              <Amenity
                onChange={(status) => setSwimmingPool(status)}
                
                title='Swimming Pool'
                icon="bi-water"
              />
              <Amenity
                onChange={(status) => setRestaurant(status)}
                title='Restaurant'
                icon='bi-tv'
              />
              <Amenity
                onChange={(status) => setAC(status)}
                title='AC'
                icon='bi-activity'
              />
             
              <Amenity
                onChange={(status) => setWifi(status)}
                title='Wifi'
                icon='bi-droplet-half'
              />
              <Amenity
                onChange={(status) => setPowerbackup(status)}
                title='Powerbackup'
                icon='bi-egg-fried'
              />
              <Amenity
                onChange={(status) => setParking(status)}
                title='Parking'
                icon='bi-p-circle'
              />
            </div>
          </div>
        </div>

        <div className='mb-3'>
          <label htmlFor=''>Image</label>
          <input
            accept='image/*'
            onChange={(e) => setImage(e.target.files[0])}
            type='file'
            className='form-control'
          />
        </div>

        <div className='mb-3'>
          <button onClick={onSave} className='btn btn-success me-2'>
            Go to Next 
          </button>
          <Link to='/properties' className='btn btn-danger'>
            Cancel
          </Link>
        </div>
      </div>
    </div>
  )
}

export default AddProperty