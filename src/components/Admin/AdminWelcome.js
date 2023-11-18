import AdminSideBar from "./AdminSideBar";

function AdminWelcome() {

    return (
        <div>

            <div style={{
                height: "100vh", backgroundColor: "grey", backgroundImage:
                    "url('https://cdn.pixabay.com/photo/2016/09/21/04/46/barley-field-1684052_1280.jpg')", height: "100vh",
                    marginTop: "0px",
                    backgroundSize: "cover",
                    backgroundRepeat: "no-repeat",
            }}>

                <AdminSideBar />

            </div>



        </div>
    )
}

export default AdminWelcome;