import react from "react";

function Footer() {
  let date = new Date();
  let year = date.getFullYear();
  return (
    <div>
      <div class="container-fluid ">
        <footer
          class="text-center text-lg-start text-white"
          style={{ backgroundColor: "#1c2331" }}
        >
          <section
            class="d-flex justify-content-between p-4"
            style={{ backgroundColor: "#6351ce" }}
          >
            <div class="me-5">
              <h6 class="text-uppercase fw-bold">
                Get Connected With Us On Social Media
              </h6>
            </div>

            <div>
              <a
                href="https://www.instagram.com/agrigoi/?hl=en"
                class="text-white me-4"
              >
                <img
                  className="mt-2 me-2"
                  src="https://cdn-icons-png.flaticon.com/512/2111/2111463.png"
                  style={{ height: "30px", width: "30px" }}
                ></img>
              </a>

              <a href="/" class="text-white me-4">
                <img
                  className="mt-2 me-2"
                  src="https://cdn-icons-png.flaticon.com/512/733/733585.png"
                  style={{ height: "30px", width: "30px" }}
                ></img>
              </a>
              <a href="/" class="text-white me-4">
                <img
                  className="mt-2 me-2"
                  src="https://cdn-icons-png.flaticon.com/512/1384/1384005.png"
                  style={{ height: "30px", width: "30px" }}
                ></img>
              </a>
            </div>
          </section>

          <section class="">
            <div class="container text-center text-md-start mt-5">
              <div class="row mt-3">
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                  <h6 class="text-uppercase fw-bold">KissanSeva</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style={{
                      width: "60px",
                      backgroundColor: "#7c4dff",
                      height: "2px",
                    }}
                  />
                  <p>
                    National Agriculture Market (KisanSeva) is a pan-India
                    electronic trading portal which networks the existing APMC
                    mandis to create a unified national market for agricultural
                    commodities.
                  </p>
                </div>

                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                  <h6 class="text-uppercase fw-bold">Products</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style={{
                      width: "60px",
                      backgroundColor: "#7c4dff",
                      height: "2px",
                    }}
                  />
                  <p>
                    <a href="#!" class="text-white">
                      Agro Market
                    </a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">
                      Crops
                    </a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">
                      InfoService
                    </a>
                  </p>
                </div>

                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                  <h6 class="text-uppercase fw-bold">Useful links</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style={{
                      width: "60px",
                      backgroundColor: "#7c4dff",
                      height: "2px",
                    }}
                  />
                  <p>
                    <a href="#!" class="text-white">
                      Your Account
                    </a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">
                      Become an Affiliate
                    </a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">
                      Shipping Rates
                    </a>
                  </p>

                </div>

                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                  <h6 class="text fw-bold">Contact Us</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style={{
                      width: "60px",
                      backgroundColor: "#7c4dff",
                      height: "2px",
                    }}
                  />
                  <p>
                    <i class="fas fa-home mr-3"></i> Help Desk No.: 1800 270
                    0224
                  </p>
                  <p>
                    <i class="fas fa-envelope mr-3"></i> info@example.com
                  </p>
                  <p>
                    <i class="fas fa-phone mr-3"></i> Fax: +91-11- 26862367
                  </p>
                  <p>
                    <i class="fas fa-print mr-3"></i> Office Time: 09:30 AM. to
                    06:00 PM.
                  </p>
                </div>
              </div>
            </div>
          </section>

          <div
            class="text-center p-3"
            style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}
          >
            ©️Copyright {year} National Agriculture Market Project. All rights
            reserved
          </div>
        </footer>
      </div>
    </div>
  );
}

export default Footer;
