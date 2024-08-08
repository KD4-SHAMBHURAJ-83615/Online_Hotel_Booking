import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import axios from 'axios'

function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [isEmailEmpty, setEmailEmpty] = useState(false)
  const [isPasswordEmpty, setPasswordEmpty] = useState(false)

  // get navigation hook
  const navigate = useNavigate()

  const onLogin = async () => {
    if (email.length == 0) {
      toast.error('Please enter email')
    } else if (password.length == 0) {
      toast.error('Please enter password')
    } else {
      try {
        
        const response = await axios.post('http://localhost:8080/users/login', {
         
          email,
          password,
          
          
        });
        
           
        if (response.status === 200) {
          
          sessionStorage.setItem('id',response.data.id)
          toast.success('Successfully registered a new user');
          if (response.data.role=='CUSTOMER')
          navigate('/homeC');
           if (response.data.role=='OWNER')
           navigate('/properties');
          
        } else {
          toast.error('User navi registration failed');
        }
      } catch (error) {
        console.error('There was an error signing up!', error);
        toast.error('User registration failed');
      }


        
  
        
     
    }}

  return (
    <div className='background-container '>
   
      <div className='row'>
        <div className='col'></div>
        <div className='col'>
        <h1 className='page-header slide-up'>LOGIN </h1>
          <div className='form slide-up box'>
            <div className='mb-3' >
              <br/>
              <label htmlFor=''>Email</label>
              <input
                onChange={(e) => {
                  if (e.target.value.length == 0) {
                    setEmailEmpty(true)
                  } else {
                    setEmailEmpty(false)
                  }
                  setEmail(e.target.value)
                }}
                type='email'
                className='form-control'
              />
              {isEmailEmpty && (
                <p style={{ color: 'red' }}>Email is mandatory</p>
              )}
            </div>
            <div className='mb-3'>
              <label htmlFor=''>Password</label>
              <input
                onChange={(e) => {
                  if (e.target.value.length == 0) {
                    setPasswordEmpty(true)
                  } else {
                    setPasswordEmpty(false)
                  }
                  setPassword(e.target.value)
                }}
                type='password'
                className='form-control'
              />
              {isPasswordEmpty && (
                <p style={{ color: 'red' }}>Password is mandatory</p>
              )}
            </div>
            <div className='mb-3'>
              <div>
                Don't have account ? <Link className='color' to='/register'>Register here</Link>
              </div>
              <button onClick={onLogin} className='btn btn-success mt-2'>
                Login
              </button>
            </div>
          </div>
        </div>
        <div className='col'></div>
      </div>
     
     
      
    </div>
  )
}

export default Login
