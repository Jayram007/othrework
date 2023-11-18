import { useParams } from 'react-router-dom';
function BuyerWelcome(){
    const myStyle={
        backgroundImage: 
    "url('https://cdn.pixabay.com/photo/2016/09/21/04/46/barley-field-1684052_1280.jpg')",
        height:'100vh',
        marginTop:'0px',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
    };
        const { username } = useParams();
       
       
        var handleProduct = ()=>{
            window.location = `/buyer-product`;
          }

          var handleMyCart = ()=>{
            window.location = `/buyer-myCart`;
          }
    
        return(
            <div >


                  <div class="container-fluid">
                      <div class="row flex-nowrap">
                          <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-success">
                              <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                                  <a href="http://localhost:3000/farmer-welcome/adii" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                                      <span class="fs-5 d-none d-sm-inline"><div><p className="fs-1  text-center">{username}</p></div></span>
                                  </a>
                                  <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                                     
                                      <li>
                                              
                                          <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                                              
                                
                                              <li>
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline"><button type="button" className="btn btn-primary" onClick={handleProduct}><strong>View Products</strong></button></span> </a>
                                              </li>
                                              <li>
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline"><button type="button" className="btn btn-primary" onClick={handleMyCart}><strong>My Cart</strong></button></span> </a>
                                              </li>
                                          </ul>
                                      </li>
                                      
                                      {/* <li>
                                          <a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                                              <i class="fs-4 bi-bootstrap"></i> <span class="ms-1 d-none d-sm-inline">Bootstrap</span></a>
                                          <ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">
                                              <li class="w-100">
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Item</span> 1</a>
                                              </li>
                                              <li>
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Item</span> 2</a>
                                              </li>
                                          </ul>
                                      </li>
                                      <li>
                                          <a href="#submenu3" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                                              <i class="fs-4 bi-grid"></i> <span class="ms-1 d-none d-sm-inline">Products</span> </a>
                                              <ul class="collapse nav flex-column ms-1" id="submenu3" data-bs-parent="#menu">
                                              <li class="w-100">
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 1</a>
                                              </li>
                                              <li>
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 2</a>
                                              </li>
                                              <li>
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 3</a>
                                              </li>
                                              <li>
                                                  <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 4</a>
                                              </li>
                                          </ul>
                                      </li>
                                      <li>
                                          <a href="#" class="nav-link px-0 align-middle">
                                              <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Customers</span> </a>
                                      </li> */}
                                  </ul>
                                  <hr/>
                                  {/* <div class="dropdown pb-4">
                                     
                                      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                                          <li><a class="dropdown-item" href="#">New project...</a></li>
                                          <li><a class="dropdown-item" href="#">Settings</a></li>
                                          <li><a class="dropdown-item" href="#">Profile</a></li>
                                          <li>
                                              <hr class="dropdown-divider"/>
                                          </li>
                                          <li><a class="dropdown-item" href="#">Sign out</a></li>
                                      </ul>
                                  </div> */}
                              </div>
                          </div>
                          <div class="col py-3">
                          <div><p className="text-center fs-1 "> Buyer-Home-Page </p></div>
                              
                          </div>
                      </div>
                  </div>
    
                
                
            </div>
     
        );
    }

export default BuyerWelcome;