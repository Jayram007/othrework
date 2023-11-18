import React, { useEffect, useState } from 'react'
import axios from 'axios'


export default function FarmerList() {
  const [list, setList] = useState([])

  //let navigate = useNavigate();
  const editUser = (item, index) => {
    // navigate(`edit?edit=true&id=${item.bid}`)
    /* eslint-disable no-restricted-globals */
    //path=`edit?edit=true&id=${item.bid}`;
    // browserHistory.push(path)
    window.location = `/admin-farmerupdate/edit?edit=true&bid=${item.fid}`;
  }

  const deleteuser = async (item, index) => {

    const url = `http://localhost:9099/admin/delFarmer/${item.fid}`;
    await axios.delete(url);
    alert("deleted successfully");
    getdata();

  }


  const getdata = async () => {
    const url = "http://localhost:9099/admin/farmer-list";
    const response = await axios.get(url)
    const res = response.data

    setList(res)
  }
  useEffect(() => {
    getdata();
  }, [])


  return (
    <div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Email</th>
            <th scope="col">Mobile</th>
            <th scope="col">Username</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {list.map((item, index) =>
            <tr key={index}>
              <th scope="row">{item.id}</th>
              <td>{item.firstname}</td>
              <td>{item.lastname}</td>
              <td>{item.email}</td>
              <td>{item.contact}</td>
              <td>{item.user_name}</td>
              <td>
                <span className="badge bg-primary"
                  role="button"
                  onClick={() => editUser(item, index)}>
                  Edit

                </span>
                <span className="badge bg-danger" role="button" onClick={() => deleteuser(item, index)}>
                  Del
                </span>
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  )
}
