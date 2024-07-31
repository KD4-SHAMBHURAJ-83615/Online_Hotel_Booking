import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'

function Register() {
  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')
  const [mobileNo, setMobileNo] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')

  // get the navigation hook
  const navigate = useNavigate()

  const onRegister = () => {
    if (firstName.length == 0) {
      toast.error('please enter first name')
    } else if (lastName.length == 0) {
      toast.error('please enter last name')
    } else if (email.length == 0) {
      toast.error('please enter email')
    } else if (mobileNo.length == 0) {
      toast.error('please enter email')
    } else if (password.length == 0) {
      toast.error('please enter password')
    } else if (confirmPassword.length == 0) {
      toast.error('please confirm the password')
    } else if (password != confirmPassword) {
      toast.error('password does not match')
      toast.error('password does not match')
    } else {
      // call register API, check the status
      // if success go to Login screen
      toast.success('Successfully registered a new user')
      navigate('/login')
    }
  }

  return (
    <div className='background-container '>
      
      
      <div className='row'>
        <div className='col'></div>
        <div className='col'>
        <h1 className='page-header slide-up'>REGISTER </h1>
          <div className='form slide-up box'>
            <div className='mb-3'>
            
            <br/>
              <h6 htmlFor=''>First Name</h6>
              <input
                onChange={(e) => setFirstName(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6 htmlFor=''>Last Name</h6>
              <input
                onChange={(e) => setLastName(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6 htmlFor='' >Email</h6>
              <input
                onChange={(e) => setEmail(e.target.value)}
                type='email'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6 htmlFor=''>Mobile No</h6>
              <input
                onChange={(e) => setMobileNo(e.target.value)}
                type='text'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6 htmlFor=''>Password</h6>
              <input
                onChange={(e) => setPassword(e.target.value)}
                type='password'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <h6 htmlFor=''>Confirm Password</h6>
              <input
                onChange={(e) => setConfirmPassword(e.target.value)}
                type='password'
                className='form-control'
              />
            </div>
            <div className='mb-3'>
              <div>
                Already have an account ? <Link className='color' to='/login'>Login here</Link>
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
  )
}

export default Register
