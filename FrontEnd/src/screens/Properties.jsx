import Dashboard from '../Dashboard/Dashboard'

import { useState, useEffect } from 'react'
import { getProperties } from '../services/property'
import { useNavigate } from 'react-router-dom'

import imagehotel from '../Images/hotel1.jpg'
import {  useNavigate } from 'react-router-dom'

function Properties() {
  const navigate = useNavigate()

const onAddHotel =  () => {
  navigate('/AddHotel');
}


function Properties() {
  const [properties, setProperties] = useState([])
  const navigate = useNavigate()

  const loadProperties = async () => {
    debugger
    const result = await getProperties()
    if (result != undefined) {
      setProperties(result)
      console.log(result['data'])

      
    }
  }

  useEffect(() => {
    loadProperties()
  }, [])

  const onAddHotel = () => {
    navigate('/AddHotel');
  }


  return (
    <div className="background-container">

      <Dashboard />
      <div className="row mt-4">
        <div className='col-10'></div>
        <div className='col-2'>
          <button onClick={onAddHotel} className='btn btn-success mt-2'>
            Add Hotel
          </button>
        </div>
      </div>
      <div className="row ">
       
        {properties.map((property, index) => (
        <div className='col ms-5 mt-5'>
         
            <div key={index} className="card text-bg-dark slide-up mb-4" style={{ width: 400 }}>
              <img src={property.image || imagehotel} className="card-img" alt="hotel" />
              <div className="card-img-overlay">
                <h5 className="card-title">{property.hotelName}</h5>
                <p className="card-text">
                  {property.address}
                </p>
                <div >
                  <button className="btn btn-success ms-5">View</button>
                  <button className="btn btn-warning ms-5">Edit</button>
                  <button className="btn btn-danger ms-5">Delete</button>
                </div>
              </div>
            </div>
          
        </div>
        ))}
      </div>

    </div>
  )
}

export default Properties
