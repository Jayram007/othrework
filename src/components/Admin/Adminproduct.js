import react from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";

function Productlist() {
    const username = sessionStorage.getItem("authenticatedUser")
    const [list, setList] = useState([]);
    const history = useHistory();

    var [searchitem, setSearchitem] = useState({ crop: '' });

    // var [hasLoginFailed, sethasLoginFailed] = useState(false);
    var handleChange = (e) => {
        e.preventDefault();
        var name = e.target.name;
        var value = e.target.value;
        setSearchitem({ ...searchitem, [name]: value, });
    };


    useEffect(() => {
        axios
            .post("http://localhost:9099/buyer/allsearch", {})
            .then((response) => {
                setList(response.data);
            })
            .catch((error) => {
                console.log(error.response);
            });
    }, []);

    function handleSearchAll() {

        axios
            .post("http://localhost:9099/buyer/allsearch", {})
            .then((response) => {
                setList(response.data);
            })
            .catch((error) => {
                console.log(error.response);
            });
        console.log(list)
    }

    function handleSearch(e) {
        e.preventDefault();
        axios
            .post("http://localhost:9099/buyer/search", {
                crop: searchitem.crop,
            })
            .then((response) => {
                setList(response.data);
            })
            .catch((error) => {
                console.log(error.response);
            });
    }





    var [selectedquantity, setSelectedQuantity] = useState({ quantity: '' });








    return (
        <div>
            <div class="d-flex justify-content-between">
                <div >
                    <button type="button" className="btn btn-danger mt-3" onClick={handleSearchAll}>All</button>
                </div>

                <div class="container">
                    <div className="row">
                        <div className="col-4">
                            <form class="d-flex">
                                {/* <input class="form-control me-2" type="search" placeholder="Search For Product" aria-label="Search" name="crop"
                          value={searchitem.crop}
                          onChange={handleChange} />
                        <button class="btn btn-outline-success" type="submit" onClick={handleSearch}>Search</button> */}
                            </form>
                        </div>
                    </div>
                </div>

                <div >
                    <button type="button" className="btn btn-danger mt-3" onClick={history.goBack}>Back</button>
                </div>
            </div>





            <div className="container d-flex justify-content-center">
                <div className="row col-8">

                    <table className="table table-dark table-hover  ">
                        <thead><tr><td>Crop Category</td><td>Quantity</td><td>Price/Quintal</td><td>Farmer</td><td></td></tr></thead>
                        <tbody>

                            {list.map((item) => {
                                return (
                                    <tr key={item.pid}>
                                        <td>{item.crop}</td>
                                        <td>{item.quantity}</td>
                                        <td>₹{(item.expected_Price / item.quantity).toFixed(2)}</td>
                                        <td>{item.farmer.firstname}</td>

                                    </tr>
                                )
                            })
                            }
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    )
}

export default Productlist;