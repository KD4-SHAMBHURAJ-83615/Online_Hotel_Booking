
import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import axios from 'axios'

function Register() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [phoneNo, setMobileNo] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [role,setRole] = useState('');

  // get the navigation hook
  const navigate = useNavigate();

  const onRegister = async () => {
    if (firstName.length === 0) {
      toast.error('Please enter first name');
    } else if (lastName.length === 0) {
      toast.error('Please enter last name');
    } else if (email.length === 0) {
      toast.error('Please enter email');
    } else if (phoneNo.length === 0) {
      toast.error('Please enter phone number');
    } else if (password.length === 0) {
      toast.error('Please enter password');
    } else if (confirmPassword.length === 0) {
      toast.error('Please confirm the password');
    } else if (password !== confirmPassword) {
      toast.error('Password does not match');
    } else {
      
      try {
        const response = await axios.post('http://localhost:8080/users/register', {
          firstName,
          lastName,
          email,
          password,
          phoneNo,
          role,
          
        });
            console.log(response.data)
        if (response.status === 201) {
          

          toast.success('Successfully registered a new user');
          navigate('/homeC');
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
          <h1 className='page-header slide-up'>REGISTER</h1>
          <div className='form slide-up box'>
            <div className='mb-3'>
              <br/>
              <h6>First Name</h6>
              <input
                onChange={(e) => setFirstName(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Last Name</h6>
              <input
                onChange={(e) => setLastName(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Email</h6>
              <input
                onChange={(e) => setEmail(e.target.value)}
                type='email'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Mobile No</h6>
              <input
                onChange={(e) => setMobileNo(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Password</h6>
              <input
                onChange={(e) => setPassword(e.target.value)}
                type='password'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Confirm Password</h6>
              <input
                onChange={(e) => setConfirmPassword(e.target.value)}
                type='password'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6>Country</h6>
              <select className='form-control' onChange={(e) => setRole(e.target.value)}>
                <option>Select ROLE</option>
                <option value='CUSTOMER'>CUSTOMER</option>
              </select>
            </div>
            <div className='mb-3'>
              <div>
                Already have an account? <Link className='color' to='/login'>Login here</Link>
              </div>
              <button onClick={onRegister} className='btn btn-success mt-2'>
                Register
              </button>
            </div>
          </div>
        </div>
        <div className='col'></div>
      </div>
    </div>
  );
}

export default Register;

