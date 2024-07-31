import './App.css';
import { Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Login from './screens/Login';
import Register from './screens/Register';
import Address from './screens/Address';
import Home from './screens/Home';


function App() {
  return (
    <div className="container" >
     <Routes>
      {/* <Route path='' element={<AddHotel/>} /> */}
      <Route path='' element={<Login/>} />
      <Route path='Register' element={<Register/>} />
      <Route path='Address' element={<Address/>} />
      <Route path='Home' element={<Home/>} />
      {/* <Route path='AddHotel' element={<AddHotel/>} /> */}
     </Routes>
     <ToastContainer />
    </div>
  );
}

export default App;
