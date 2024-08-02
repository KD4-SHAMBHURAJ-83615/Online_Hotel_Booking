import './App.css';
import { Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Login from './screens/Login';
import Register from './screens/Register';
import Address from './screens/Address';
import Properties from './screens/Properties';


function App() {
  return (
    <div className="container" >
     <Routes>
      <Route path='' element={<Properties/>} />
      <Route path='Login' element={<Login/>} />
      <Route path='Register' element={<Register/>} />
      <Route path='Address' element={<Address/>} />
      <Route path='Properties' element={<Properties/>} />
     </Routes>
     <ToastContainer />
    </div>
  );
}

export default App;
