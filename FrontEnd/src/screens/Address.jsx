

import { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import axios from 'axios';

function Address() {
  const { id } = useParams(); // Retrieve the user ID from the route parameters
  const [addressLine, setAddressLine] = useState('');
  const [city, setCity] = useState('');
  const [pincode, setPincode] = useState('');
  const [state, setState] = useState('');
  const [country, setCountry] = useState('');

  const navigate = useNavigate();
 
  console.log(id);
  const onSaveAddress = async () => {
    if (addressLine.length === 0) {
      toast.error('Please enter address line');
    } else if (city.length === 0) {
      toast.error('Please enter city');
    } else if (pincode.length === 0) {
      toast.error('Please enter pincode');
    } else if (state.length === 0) {
      toast.error('Please enter state');
    } else if (country.length === 0) {
      toast.error('Please enter country');
    } else {
      try {
        debugger
        const response = await axios.post('http://localhost:8080/address', {
          addressLine,
          city,
          pincode,
          state,
          country,
          id, // Include the user ID in the request
        });
        
        if (response.status === 201) {
          toast.success('Address saved successfully');

         // navigate(`/addroom/${id}`); // Redirect to home page or any other page
         navigate(`/room`);

        } else {
          toast.error('Failed to save address');
        }
      } catch (error) {
        console.error('There was an error saving the address!', error);
        toast.error('Failed to save address');
      }
    }
  };

  return (
    <div className='background-container'>
      <div className='row'>
        <div className='col'></div>
        <div className='col'>
          <h1 className='page-header slide-up'>HOTEL ADDRESS</h1>
          <div className='form slide-up box'>
            <div className='mb-3'>
              <br/>
              <h6>Address Line</h6>
              <input
                onChange={(e) => setAddressLine(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>City</h6>
              <input
                onChange={(e) => setCity(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Pincode</h6>
              <input
                onChange={(e) => setPincode(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>State</h6>
              <input
                onChange={(e) => setState(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Country</h6>
              <input
                onChange={(e) => setCountry(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <button onClick={onSaveAddress} className='btn btn-success mt-2'>
                Save Address
              </button>
            </div>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
  );
}

export default Address;

