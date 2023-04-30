import react from "react";
import { useParams } from 'react-router-dom';
import AuthenticateService from "./AuthenticateService";
import SideBar from "./SideBar";


function Welcome()
{
    const { username } = useParams();
  const myStyle={
    backgroundImage: 
"url('https://cdn.pixabay.com/photo/2016/09/21/04/46/barley-field-1684052_1280.jpg')",
    height:'100vh',
    marginTop:'0px',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
};

const sidebarStyle={
    backgroundImage: 
"url('https://i.pinimg.com/236x/f4/7f/24/f47f24709105d4738edda3ebbfc9e35a.jpg')",
    height:'100vh',
    marginTop:'0px',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
};

   
     
    var handleOrder = ()=>{
      window.location = `/farmer-order/${username}`;
    }
    var handleProduct = ()=>{
        window.location = `/farmer-product`;
      }

    return(
        <div style={myStyle}>
            <SideBar/>
            
        </div>
 
    );
}

export default Welcome;