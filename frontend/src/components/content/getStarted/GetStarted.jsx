import React from 'react';
import "./getStarted.css";
import { NavLink } from 'react-router-dom';

const GetStarted = () => {
  return (
    <div class = "getStartedContent">
        <div class = "getStarted">
            Welcome To <br />
            Marketplace <br />
            Game!
            <button class = "startButton">
                <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/marketplace'>Get Started</NavLink>
            </button>
        </div>
        <div class = "animation">
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