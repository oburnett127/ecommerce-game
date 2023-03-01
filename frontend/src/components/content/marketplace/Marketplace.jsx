import React from 'react';
import ReactDOM from 'react-dom/client';
import "./marketplace.css";
import { useQuery } from 'react-query';
import axios from "axios";
import ProductsList from "../ProductsList";


const Marketplace = () => {
    const { data: productsData, isLoading: isLoadingProducts } = useQuery('products',
        () => { return axios.get("http://localhost:8080/product/list");}
    );

    const products = isLoadingProducts ? [] : productsData.data;

    return (
        <div className = "market">
            {isLoadingProducts && <p>Loading...</p>}
            {!isLoadingProducts && <ProductsList products={products} />}
        </div>
    )
}

export default Marketplace;

        {/*<div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>
        <div class = "product">I am Product</div>*/}



