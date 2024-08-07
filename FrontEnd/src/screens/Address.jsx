// // import { useState,useEffect } from 'react'
// // import {  useNavigate } from 'react-router-dom'
// // import { toast } from 'react-toastify'
// // import axios from 'axios'

// // function Address() {
 
// //   const [addressLine, setAdressLine] = useState('')
// //   const [city, setCity] = useState('')
// //   const [pincode, setPincode] = useState('')
// //   const [state, setState] = useState('');
// //   const [country, setCountry] = useState('')
// //   const [firstName] = useState('')
// //   const [lastName] = useState('')
// //   const [email] = useState('')
// //   const [phoneNo] = useState('')
// //   const [password] = useState('')

// //   const [storedObject, setStoredObject] = useState(null);
 
  
// //   useEffect(() => {
// //     // Retrieve the object from localStorage
// //     const data = localStorage.getItem('user');
// //     if (data) {
// //       setStoredObject(JSON.parse(data));
// //     }
// //   }, []);

// //   firstName=storedObject.firstName;
// //   lastName=storedObject.lastName;
// //   email=storedObject.email;
// //   phoneNo=storedObject.phoneNo;
// //   password=storedObject.password;

// //   // get the navigation hook
// //   const navigate = useNavigate()

// //   const onAddAddress = async () => {
// //     if (addressLine.length == 0) {
// //       toast.error('please enter Address')
// //     } else if (pincode.length == 0) {
// //       toast.error('please enter pincode')
// //     } else if (city.length == 0) {
// //       toast.error('please enter city')
// //     } else if (state.length == 0) {
// //       toast.error('please select state ')
// //     } else if (country.length == 0) {
// //       toast.error('please select country')
    
      
// //     } else {
// //       try {

// //         // Make a POST request to the signup API
        
// //         const response = await axios.post('http://localhost:8080/users/register', {        
// //         firstName,       
// //         lastName,       
// //         email,
// //         password,
// //         phoneNo,
// //         addressLine,
// //         city,
// //         pincode,
// //         state,
// //         country       
// //         });
        
// //         //Handle the response from the server 
// //         if (response.status === 201) {
        
// //         toast.success('Successfully registered a new user');
        
// //         navigate('/home');
// //         }else
// //         toast.error('User registration failed');
        
// //         } catch (error) {
        
// //         console.error("There was an error signing up!", error); toast.error('User registration failed');
// //     }
// //   }}

// //   return (
// //     <div className='background-container '>
      
      
// //       <div className='row'>
// //         <div className='col'></div>
// //         <div className='col'>
// //         <h1 className='page-header slide-up'>HOTEL ADDRESS</h1>
// //           <div className='form slide-up box'>
// //             <div className='mb-3'>
// //             <br/>
// //               <h6 htmlFor=''>{storedObject}</h6>
// //               <textarea
// //                 onChange={(e) => setAdressLine(e.target.value)}
// //                 type='text'
// //                 placeholder="Enter Line"
// //                 className='form-control'
// //               />
// //               <br/>
// //               <div className='mb-3'>
// //               <h6 htmlFor='' >Pincode</h6>
// //               <input
// //                 onChange={(e) => setPincode(e.target.value)}
// //                 type='text'
// //                  placeholder="Enter 6-digit pincode"
// //                   maxLength="6"
// //                 className='form-control'
// //               />
// //             </div>
// //             </div>
// //             <div className='mb-3'>
// //               <h6 htmlFor=''>City</h6>
// //               <input
// //               placeholder="Enter Your City"
// //                 onChange={(e) => setCity(e.target.value)}
// //                 type='text'
// //                 className='form-control'
// //               />
// //             </div>
            
// //             <div className='mb-3' >
// //               <h6 htmlFor=''>State</h6>
// //               <select className="form-control"  onChange={(e) => setState(e.target.value)} >
// //                         <option>Select State</option>
// //                         <option value="Maharashtra">Maharashtra</option>
// //                         <option value="Karnataka">Karnataka</option>
// //                         <option value="Goa">Goa</option>
// //                         <option value="Dehli">Delhi</option>
// //                         <option value="Gujrat">Gujrat</option>
// //                         <option value="Asam">Asam</option>
// //                         <option value="Rajasthan">Rajasthan</option>
// //                     </select>
             
// //             </div>
// //             <div className='mb-3 '>
// //               <h6 htmlFor=''>Country</h6>
// //               <select className="form-control" onChange={(e) => setCountry(e.target.value)}>
// //                         <option>Select State</option>
// //                         <option value="India">India</option>
// //                     </select>
// //             </div>
           
           
// //             <div className='mb-3'>
// //               {/* <div>
// //                 Already have an account ? <Link to='/home'>Login here</Link>
// //               </div> */}
// //               <button  onClick={onAddAddress} className='btn btn-success mt-2 '>
// //                 Add Details
// //               </button>
// //             </div>
// //           </div>
// //         </div>
// //         <div className='col'></div>
// //       </div>
// //     </div>
// //   )
// // }

// // export default Address


// import React, { useState, useEffect } from 'react';
// import { useNavigate } from 'react-router-dom';
// import { toast } from 'react-toastify';
// import axios from 'axios';

// function Address() {
//   const [addressLine, setAddressLine] = useState('');
//   const [city, setCity] = useState('');
//   const [pincode, setPincode] = useState('');
//   const [state, setState] = useState('');
//   const [country, setCountry] = useState('');
//   const [storedObject, setStoredObject] = useState(null);

//   useEffect(() => {
//     // Retrieve the object from localStorage
//     const data = localStorage.getItem('user');
//     if (data) {
//       setStoredObject(JSON.parse(data));
//     }
//   }, []);

//   // get the navigation hook
//   const navigate = useNavigate();

//   const onAddAddress = async () => {
//     if (addressLine.length === 0) {
//       toast.error('Please enter Address');
//     } else if (pincode.length === 0) {
//       toast.error('Please enter pincode');
//     } else if (city.length === 0) {
//       toast.error('Please enter city');
//     } else if (state.length === 0) {
//       toast.error('Please select state');
//     } else if (country.length === 0) {
//       toast.error('Please select country');
//     } else {
//       try {
//         // Make a POST request to the signup API
//         const response = await axios.post('http://localhost:8080/users/register', {
//           addressLine,
//           city,
//           pincode,
//           state,
//           country,
//           firstName: storedObject?.firstName,
//           lastName: storedObject?.lastName,
//           email: storedObject?.email,
//           password: storedObject?.password,
//           phoneNo: storedObject?.phoneNo
          
//         });

//         // Handle the response from the server
//         if (response.status === 200) {
//           toast.success('Successfully registered a new user');
//           navigate('/login');
//         } else {
//           toast.error('User not navigate failed');
//         }
//       } catch (error) {
//         console.log("There was an error signing up!", error);
//         toast.error('User registration failed');
//       }
//     }
//   };

//   return (
//     <div className='background-container'>
//       <div className='row'>
//         <div className='col'></div>
//         <div className='col'>
//           <h1 className='page-header slide-up'>HOTEL ADDRESS</h1>
//           <div className='form slide-up box'>
//             <div className='mb-3'>
//               <br />
//               <h6>Address Line</h6>
//               <textarea
//                 onChange={(e) => setAddressLine(e.target.value)}
//                 type='text'
//                 placeholder='Enter Line'
//                 className='form-control'
//               />
//               <br />
//               <div className='mb-3'>
//                 <h6>Pincode</h6>
//                 <input
//                   onChange={(e) => setPincode(e.target.value)}
//                   type='text'
//                   placeholder='Enter 6-digit pincode'
//                   maxLength='6'
//                   className='form-control'
//                 />
//               </div>
//             </div>
//             <div className='mb-3'>
//               <h6>City</h6>
//               <input
//                 placeholder='Enter Your City'
//                 onChange={(e) => setCity(e.target.value)}
//                 type='text'
//                 className='form-control'
//               />
//             </div>

//             <div className='mb-3'>
//               <h6>State</h6>
//               <select className='form-control' onChange={(e) => setState(e.target.value)}>
//                 <option>Select State</option>
//                 <option value='Maharashtra'>Maharashtra</option>
//                 <option value='Karnataka'>Karnataka</option>
//                 <option value='Goa'>Goa</option>
//                 <option value='Dehli'>Delhi</option>
//                 <option value='Gujrat'>Gujrat</option>
//                 <option value='Asam'>Asam</option>
//                 <option value='Rajasthan'>Rajasthan</option>
//               </select>
//             </div>
//             <div className='mb-3'>
//               <h6>Country</h6>
//               <select className='form-control' onChange={(e) => setCountry(e.target.value)}>
//                 <option>Select State</option>
//                 <option value='India'>India</option>
//               </select>
//             </div>

//             <div className='mb-3'>
//               <button onClick={onAddAddress} className='btn btn-success mt-2'>
//                 Add Details
//               </button>
//             </div>
//           </div>
//         </div>
//         <div className='col'></div>
//       </div>
//     </div>
//   );
// }

// export default Address;

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import axios from 'axios';

function Address() {
  const [addressLine, setAddressLine] = useState('');
  const [city, setCity] = useState('');
  const [pincode, setPincode] = useState('');
  const [state, setState] = useState('');
  const [country, setCountry] = useState('');
 

  

  const navigate = useNavigate();

  const onAddAddress = async () => {
    if (addressLine.length === 0) {
      toast.error('Please enter Address');
    } else if (pincode.length === 0) {
      toast.error('Please enter pincode');
    } else if (city.length === 0) {
      toast.error('Please enter city');
    } else if (state.length === 0) {
      toast.error('Please select state');
    } else if (country.length === 0) {
      toast.error('Please select country');
    } else {
      try {
        const response = await axios.post('http://localhost:8080/users/register', {
          addressLine,
          city,
          pincode,
          state,
          country
        });

        if (response.status === 201) {
          toast.success('Successfully registered a new user');
          navigate('/home');
        } else {
          toast.error('User navi registration failed');
        }
      } catch (error) {
        console.error('There was an error signing up!', error);
        toast.error('User registration failed');
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
              <br />
              
                <div>
                  <h6>Address Line</h6>
                </div>
              
              <textarea
                onChange={(e) => setAddressLine(e.target.value)}
                type='text'
                placeholder='Enter Line'
                className='form-control'
              />
              <br />
              <div className='mb-3'>
                <h6>Pincode</h6>
                <input
                  onChange={(e) => setPincode(e.target.value)}
                  type='text'
                  placeholder='Enter 6-digit pincode'
                  maxLength='6'
                  className='form-control'
                />
              </div>
            </div>
            <div className='mb-3'>
              <h6>City</h6>
              <input
                placeholder='Enter Your City'
                onChange={(e) => setCity(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>

            <div className='mb-3'>
              <h6>State</h6>
              <select className='form-control' onChange={(e) => setState(e.target.value)}>
                <option>Select State</option>
                <option value='Maharashtra'>Maharashtra</option>
                <option value='Karnataka'>Karnataka</option>
                <option value='Goa'>Goa</option>
                <option value='Delhi'>Delhi</option>
                <option value='Gujarat'>Gujarat</option>
                <option value='Assam'>Assam</option>
                <option value='Rajasthan'>Rajasthan</option>
              </select>
            </div>
            <div className='mb-3'>
              <h6>Country</h6>
              <select className='form-control' onChange={(e) => setCountry(e.target.value)}>
                <option>Select Country</option>
                <option value='India'>India</option>
              </select>
            </div>

            <div className='mb-3'>
              <button onClick={onAddAddress} className='btn btn-success mt-2'>
                Add Details
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

