import "./marketplace/marketplace.css";

function ProductsList({products}) {

    //console.log(products);

    return (
        <div>
                {products.map((product) => (
                    <div className="product">I am Product</div>
                ))}
        </div>
    );
}

export default ProductsList;