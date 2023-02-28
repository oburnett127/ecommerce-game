import React from 'react';
import ReactDOM from 'react-dom/client';
import "./marketplace.css";

const test = ReactDOM.createRoot(
  document.getElementById('test')
);
const element = <h1>Hello, world</h1>;
test.render(element);

const Marketplace = () => {
  return (
    <div class = "market">
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div id = "test"></div>
    </div>
  )
}

export default Marketplace;