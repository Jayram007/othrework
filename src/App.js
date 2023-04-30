import logo from "./logo.svg";
import { BrowserRouter as Router, Switch as Routes, Route } from "react-router-dom";
import "./App.css";
import Home from "./components/Home/Home";
import Header from "./components/Header";
import Footer from "./components/Footer";
import FarmerLogin from "./components/FarmerLogin";
import BuyerLogin from "./components/BuyerLogin";
import AdminLogin from "./components/Admin/AdminLogin";
import FarmerWelcome from "./components/FarmerWelcome";
import FarmerReg from "./components/FarmerReg";
import BuyerReg from "./components/BuyerReg";
import Order from "./components/FarmerOrder";
import Product from "./components/FarmerProduct";
import ErrorPage from "./components/ErrorPage";
import CustomProduct from "./components/CustomProduct";
import BuyerWelcome from "./components/BuyerWelcome";
import BuyerProduct from "./components/BuyerProduct";
import BuyerCart from "./components/BuyerCart";
import TermsandCondition from "./components/TermsAndCondition";
import BuyerPay from "./components/BuyerPay";
import BuyerProfile from "./components/BuyerProfile";
import FarmerProfile from "./components/FarmerProfile";
import AuthenticatedRout from "./components/AuthenticateRout";
import AdminWelcome from "./components/Admin/AdminWelcome";
import ForgotPassword from "./components/ForgotPassword";
import FarmerList from "./components/Admin/FarmerList";
import BuyerList from "./components/Admin/BuyerList";
import BuyerUpdate from "./components/Admin/BuyerUpdate";
import Adminproduct from "./components/Admin/Adminproduct";
import OrdersList from "./components/Admin/OrdersList";

function App() {
  return (
    <>
      <Router>
        <Header />

        <Routes>
          <Route path="/" exact component={Home} />
          <Route path="/farmer-login" component={FarmerLogin} />
          <Route path="/buyer-login" component={BuyerLogin} />
          <Route path="/admin-login" component={AdminLogin} />
          <Route path="/admin-buyerupdate" component={BuyerUpdate} />
          <AuthenticatedRout path="/Admin-product" component={Adminproduct} />
          <AuthenticatedRout path="/orders-list" component={OrdersList} />

          <AuthenticatedRout path="/farmer-reg" component={FarmerReg} />
          <AuthenticatedRout path="/Buyer-reg" component={BuyerReg} />
          <Route path="/farmer-list" component={FarmerList} />
          <Route path="/buyer-list" component={BuyerList} />
          <AuthenticatedRout path="/buyer-product" component={BuyerProduct} />
          <AuthenticatedRout path="/buyer/profile" component={BuyerProfile} />
          <AuthenticatedRout
            path="/farmer-welcome/:username"
            component={FarmerWelcome}
          />
          <AuthenticatedRout path="/farmer-order/:username" component={Order} />
          <AuthenticatedRout path="/farmer-product" component={Product} />
          <AuthenticatedRout
            path="/farmer/custom-product"
            component={CustomProduct}
          />
          <AuthenticatedRout
            path="/farmer-product/add-product/wheat"
            component={Product}
          />
          <AuthenticatedRout
            path="/buyer-welcome/:username"
            component={BuyerWelcome}
          />
          <AuthenticatedRout path="/buyer-myCart" component={BuyerCart} />
          <Route path="/terms-condition" component={TermsandCondition} />
          <AuthenticatedRout path="/buyer-pay/:payment" component={BuyerPay} />
          <AuthenticatedRout path="/farmer/profile" component={FarmerProfile} />
          <AuthenticatedRout
            path="/admin-welcome/:username"
            component={AdminWelcome}
          />
          <Route path="/forgot-password" component={ForgotPassword} />
          <Route path="*" component={ErrorPage} />
        </Routes>
        <Footer />
      </Router>
    </>
  );
}
export default App;
