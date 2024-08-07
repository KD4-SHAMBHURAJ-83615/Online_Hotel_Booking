import './App.css';
import { Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Login from './screens/Login';
import Register from './screens/Register';
import Address from './screens/Address';
import Properties from './screens/Properties';
import Room from './screens/Room';
import HomeC from './screens/HomeClient';
import RoomC from './screens/RoomClient';


function App() {
  return (
    <div className="container" >
     <Routes>
    {/*<Route path='' element={<Register/>} />*/}
      <Route path='' element={<Login/>} />
      <Route path='Register' element={<Register/>} />
      <Route path='Address' element={<Address/>} />
      <Route path='Properties' element={<Properties/>} />
      <Route path='Room' element={<Room/>} />
      <Route path='HomeC' element={<HomeC/>} />
      <Route path='RoomC' element={<RoomC/>} />
     </Routes>
     <ToastContainer />
    </div>
  );
}

export default App;
