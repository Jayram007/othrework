import { useState, useEffect } from "react";
import axios from "axios";

function BuyerProfile() {
  const [personalInfo, setPersonalInfo] = useState([]);

  const [firstnameflag, setFirstNameflag] = useState(false);
  const [lastnameflag, setLastNameflag] = useState(false);
  const [emailflag, setEmailflag] = useState(false);
  const [addressflag, setAddressflag] = useState(false);
  const [passwordflag, setPasswordflag] = useState(false);
  const [contactflag, setContactflag] = useState(false);
  const [usernameflag, setUserNameflag] = useState(false);

  function handleFlag(e) {
    if (e.target.name === "firstname") {
      setFirstNameflag(true);
    }
    if (e.target.name === "lastname") {
      setLastNameflag(true);
    }

    if (e.target.name === "email") {
      setEmailflag(true);
    }
    if (e.target.name === "address") {
      setAddressflag(true);
    }
    if (e.target.name === "contact") {
      setContactflag(true);
    }
    if (e.target.name === "username") {
      setUserNameflag(true);
    }
    if (e.target.name === "password") {
      setPasswordflag(true);
    }
  }

  function handleCancel() {
    setFirstNameflag(false);
    setLastNameflag(false);
    setEmailflag(false);
    setAddressflag(false);
    setContactflag(false);
    setUserNameflag(false);
    setPasswordflag(false);
  }

  const [changeInfo, setChangeInfo] = useState({
    firstname: "",
    lastname: "",
    email: "",
    contact: "",
    user_name: "",
    address: "",
    password: "",
  });

  console.log(changeInfo);
  function changeProfile() {
    //http://localhost:9099/change-profile/farmer/
    const url =
      "http://localhost:9099/change-profile/" +
      sessionStorage.getItem("userType") +
      "/" +
      sessionStorage.getItem("authenticatedUser");
    axios
      .post(url, {
        firstname: changeInfo.firstname,
        lastname: changeInfo.lastname,
        email: changeInfo.email,
        contact: changeInfo.contact,
        user_name: changeInfo.user_name,
        address: changeInfo.address,
        password: changeInfo.password,
      })
      .then((response) => {
        console.log(response.data);
        if (response.data == "updated") {
          alert("updated");
          window.location.reload(false);
        }
      })
      .catch((error) => {
        console.log(error.response);
      });
  }
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setChangeInfo({ ...changeInfo, [name]: value });
  };
  console.log(changeInfo);

  const url =
    "http://localhost:9099/buyer/profile/" +
    sessionStorage.getItem("authenticatedUser");
  useEffect(() => {
    axios
      .get(url, {})
      .then((response) => {
        console.log(response.data);
        setPersonalInfo(response.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }, []);
  return (
    <div className="container d-flex justify-content-center fw-bold ">
      <div className="row col-8 ">
        <span class="border border-warning">
          <table>
            <tr>
              <td style={{ columnSpan: "2" }}>Personal Info</td>
            </tr>
            <tr>
              <td>First Name :</td>
              <td>{personalInfo.firstname}</td>
              {!firstnameflag && (
                <td>
                  <button
                    type="button"
                    name="firstname"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {firstnameflag && (
                <td>
                  <input
                    type="text"
                    class="form-control"
                    name="firstname"
                    placeholder="Enter New First Name"
                    value={changeInfo.firstname}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>
            <tr>
              <td>Last Name :</td>
              <td>{personalInfo.lastname}</td>
              {!lastnameflag && (
                <td>
                  <button
                    type="button"
                    name="lastname"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {lastnameflag && (
                <td>
                  <input
                    type="text"
                    name="lastname"
                    class="form-control"
                    placeholder="Enter New Last Name"
                    value={changeInfo.lastname}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>
            <tr>
              <td>Contact No:</td>
              <td>{personalInfo.contact}</td>
              {!contactflag && (
                <td>
                  <button
                    type="button"
                    name="contact"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {contactflag && (
                <td>
                  <input
                    type="text"
                    name="contact"
                    class="form-control"
                    placeholder="Enter New ContactNo"
                    value={changeInfo.contact}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>
            <tr>
              <td>Email :</td>
              <td>{personalInfo.email}</td>
              {!emailflag && (
                <td>
                  <button
                    type="button"
                    name="email"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {emailflag && (
                <td>
                  <input
                    type="text"
                    name="email"
                    class="form-control"
                    placeholder="Enter New Email"
                    value={changeInfo.email}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>
            <tr>
              <td>Address :</td>
              <td>{personalInfo.address}</td>
              {!addressflag && (
                <td>
                  <button
                    type="button"
                    name="address"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {addressflag && (
                <td>
                  <input
                    type="text"
                    name="address"
                    class="form-control"
                    placeholder="Enter New Address"
                    value={changeInfo.address}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>
            <tr>
              <td>User Name :</td>
              <td>{personalInfo.user_name}</td>
              {!usernameflag && (
                <td>
                  <button
                    type="button"
                    name="username"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {usernameflag && (
                <td>
                  <input
                    type="text"
                    name="username"
                    class="form-control"
                    placeholder="Enter New User Name"
                    value={changeInfo.username}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>

            <tr>
              <td>Password :</td>
              {!passwordflag && (
                <td>
                  <button
                    type="button"
                    name="password"
                    class="btn btn-link"
                    onClick={handleFlag}
                  >
                    change
                  </button>
                </td>
              )}
              {passwordflag && (
                <td>
                  <input
                    type="text"
                    name="password"
                    class="form-control"
                    placeholder="Enter New password"
                    value={changeInfo.password}
                    onChange={handleChange}
                  />
                </td>
              )}
            </tr>
            {(firstnameflag ||
              lastnameflag ||
              emailflag ||
              addressflag ||
              passwordflag ||
              contactflag ||
              usernameflag) && (
              <tr>
                <td style={{ columnSpan: "4" }}>
                  <center>
                    <button
                      type="button"
                      class="btn btn-success"
                      onClick={changeProfile}
                    >
                      Save
                    </button>
                  </center>
                </td>

                <td style={{ columnSpan: "4" }}>
                  <center>
                    <button
                      type="button"
                      class="btn btn-danger"
                      onClick={handleCancel}
                    >
                      Cancel
                    </button>
                  </center>
                </td>
              </tr>
            )}
          </table>
        </span>
      </div>
    </div>
  );
}

export default BuyerProfile;
