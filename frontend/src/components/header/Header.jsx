import React from 'react';
import {NavLink} from "react-router-dom";
import './header.css';

const Header = () => {
  return (
    <div class = "header">
      <div class = "title">
      <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/'>Marketplace Website (M)</NavLink>
      </div>
      <div class = "elements">
        <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/marketplace'>Marketplace</NavLink>
        <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/construction'>Collection</NavLink>
        <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/construction'>About Us</NavLink>
        <NavLink style={{color: 'white', textDecoration: 'none'}}  to='/construction'>Login</NavLink>
        <NavLink style={{color: 'white', textDecoration: 'none'}} to='/construction'>Sign Up</NavLink>
      </div>
    </div>  
  )
}

export default Header;