import React from "react";
import Header from "./components/header/Header";
import GetStarted from "./components/content/getStarted/GetStarted";
import Marketplace from "./components/content/marketplace/Marketplace";
import Construction from "./components/content/construction/Construction"

import './App.css';
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter> 
        <body>
          <Header />
          <Routes>
            <Route exact path='/' element={<GetStarted/>} />
            <Route exact path='/marketplace' element={<Marketplace/>} />
            <Route exact path='/construction' element={<Construction/>} />
          </Routes>
        </body>
      </BrowserRouter>
    </div>
  );
}

export default App;
