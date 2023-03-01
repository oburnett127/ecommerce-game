import React from 'react';
import "./getStarted.css";
import { NavLink } from 'react-router-dom';

const GetStarted = () => {
  return (
    <div className = "getStartedContent">
        <div className = "getStarted">
            Welcome To <br />
            Marketplace <br />
            Game!
            <button className = "startButton">
                <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/marketplace'>Get Started</NavLink>
            </button>
        </div>
        <div className = "animation">
            <img 
            src={require('./../../../assets/placeholder.jpg')} 
            alt = "placeholder"
            width="325"
            />
        </div>
    </div>  
  ) 
}

export default GetStarted;