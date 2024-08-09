import { Link, useNavigate,useParams } from 'react-router-dom'
// import Navbar from '../components/navbar'
import { useState } from 'react'
import Amenity from '../components/amenity'
import { toast } from 'react-toastify'
import axios from 'axios'
// import { addProperty } from '../services/property'

function AddRoom() {
  const { id } = useParams();
  const [roomNumber, setRoomNumber] = useState('')

  const [roomType, setRoomType] = useState('')
  const [roomStatus ] = useState('AVAILABLE')
  const [rent, setRent] = useState('')
  const [available] = useState(true)
  const [tv, setTv] = useState(false)
  const [ac, setAC] = useState(false)


  const [image, setImage] = useState(undefined)

  const navigate = useNavigate()

  const onSave = async () => {
    if (roomNumber.length == 0) {
      toast.warn('Please enter Hotel Name')
    }  else if (roomType.length == 0) {
      toast.warn('Please enter contact number')
    // } else if (!image) {
    //   toast.warn('Please select a property photo')
    } else {
       debugger
      const result = await axios.post('http://localhost:8080/rooms', {
       
        roomNumber,
        roomType,
        roomStatus,
        rent,
        available,
        tv,
        ac,
        id,
       
     } )
    
     
      if (result['status'] == 201) {
        toast.success('Successfully added a property')
        navigate('/room')
      } else {
        toast.error(result['error'])
      }
    }
  }

  return (
    <div className='background-container '>
      {/* <Navbar /> */}
      <h1 className='page-header'>ADD ROOM DETAILS</h1>
      <div className='form box'>
        <div className='row'>
          <div className='col'>
            <div className='mb-3'>
              <label htmlFor=''>roomNumber</label>
              <input
                onChange={(e) => setRoomNumber(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
          </div>
         
          <div className='mb-3'>
              <h6>Room Type</h6>
              <select className='form-control' onChange={(e) => setRoomType(e.target.value)}>
                <option>Select ROOM TYPE</option>
                <option value='SINGLE'>SINGLE</option>
                <option value='DOUBLE'>DOUBLE</option>
                <option value='SUITE'>SUITE</option>
              </select>
            </div>

         
         
          
        </div>

        <h3>Amenities </h3>
        <div className='row mb-3'>
          <div className='row'>
            <div className='col'>
              <Amenity
                onChange={(status) => setTv(status)}
                
                title='TV'
                icon="bi-water"
              />
              <Amenity
                onChange={(status) => setAC(status)}
                title='AC'
                icon='bi-tv'
              />
             
            </div>
          </div>
          
          
          <div className='col'>
            <div className='mb-3'>
              <label htmlFor=''>Room Rent</label>
              <input
                onChange={(e) => setRent(e.target.value)}
                type='text'
                className='form-control'
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

export default AddRoom